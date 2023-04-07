package com.example.onestopmedicalserviceserver.drugRelated.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.onestopmedicalserviceserver.drugRelated.dao.DrugstoreDao;
import com.example.onestopmedicalserviceserver.drugRelated.domain.Drug;
import com.example.onestopmedicalserviceserver.drugRelated.domain.Drugstore;
import com.example.onestopmedicalserviceserver.other.pdf.PrescriptionInfo;
import com.example.onestopmedicalserviceserver.drugRelated.entry.DrugstoreInfo;
import com.example.onestopmedicalserviceserver.drugRelated.entry.DrugstoreInfoDrugMoney;
import com.example.onestopmedicalserviceserver.drugRelated.entry.GeographicInfo;
import com.example.onestopmedicalserviceserver.drugRelated.service.DrugService;
import com.example.onestopmedicalserviceserver.drugRelated.service.DrugstoreService;
import com.example.onestopmedicalserviceserver.util.GeoHashUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.Metrics;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
public class DrugstoreServiceImpl implements DrugstoreService {

    @Autowired
    DrugstoreDao drugstoreDao;
    @Autowired
    GeoHashUtil geoHashUtil;
    @Value("${redisKeys.geoDrugstore}")
    String geoKey;
    @Autowired
    DrugService drugService;

    @Override
    public Double distanceBetweenWwoPlaces(Integer drugstore01Id, Integer drugstore02Id) {
        Distance kilometers = geoHashUtil.calDistance(geoKey, drugstore01Id.toString(), drugstore02Id.toString(), RedisGeoCommands.DistanceUnit.valueOf("KILOMETERS"));
        return kilometers.getValue();
    }
    @Override
    public List<Drugstore> selectAll() {
        return drugstoreDao.selectList(null);
    }
    @Override
    public Drugstore selectOneByName(String name) {
        LambdaQueryWrapper<Drugstore> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Drugstore::getName,name);

        return drugstoreDao.selectOne(lqw);
    }
    @Override
    public List<Drugstore> selectListByDrugName(String name) {
        List<Drug> drugs = drugService.selectListByName(name);
        List<Drugstore> drugstores = new ArrayList<>();

        for (Drug drug:drugs){
            Drugstore drugstore = drugstoreDao.selectById(drug.getDrugstoreId());
            drugstores.add(drugstore);
        }
        return drugstores;
    }
    @Override
    public List<DrugstoreInfo> geoNearByPlace(Double longitude, Double latitude, Integer distance,Integer limit) {

        //加锁
        Lock l = new ReentrantLock();

        List<DrugstoreInfo> drugstoreInfos = new ArrayList<>();

        List<GeoResult<RedisGeoCommands.GeoLocation<String>>> drugstores = geoHashUtil.findRadius(geoKey, longitude, latitude, distance, Metrics.KILOMETERS, limit);

        l.lock();
        geoHashUtil.geoAdd(geoKey,longitude,latitude,"target");

        for (GeoResult<RedisGeoCommands.GeoLocation<String>> drugstore:drugstores){
            DrugstoreInfo drugstoreInfo = new DrugstoreInfo();
            //父类属性传给子类
            Drugstore father = drugstoreDao.selectById(drugstore.getContent().getName());
            if(father==null)
                continue;
            BeanUtils.copyProperties(father, drugstoreInfo);
            //获取俩位置之间的距离
            Distance distance1 = geoHashUtil.calDistance(geoKey, "target", drugstore.getContent().getName(), RedisGeoCommands.DistanceUnit.valueOf("KILOMETERS"));
            drugstoreInfo.setDistance(distance1.getValue());
            //放入集合中
            drugstoreInfos.add(drugstoreInfo);
        }

        geoHashUtil.remGeo(geoKey,"target");

        l.unlock();
        return drugstoreInfos;
    }
    @Override
    public List<DrugstoreInfo> geoNearByPlaceAllDrugstoreInfo(Double longitude, Double latitude, Integer distance, Integer limit) {
        List<DrugstoreInfo> drugstoreInfos = geoNearByPlace(longitude, latitude, distance, limit);
        for (DrugstoreInfo drugstoreInfo:drugstoreInfos){
            drugstoreInfo.setDrugs(drugService.selectListByDrugstoreId(drugstoreInfo.getId()));
        }
        return drugstoreInfos;
    }
    @Override
    public List<DrugstoreInfoDrugMoney> geoNearByPlaceAccordingToMoney(Double longitude, Double latitude, Integer distance, Integer limit, String drugName) {
        List<DrugstoreInfoDrugMoney> drugstoreInfoDrugMonies = new ArrayList<>();

        List<DrugstoreInfo> drugstoreInfos = geoNearByPlace(longitude, latitude, distance, limit);

        for (DrugstoreInfo drugstoreInfo : drugstoreInfos){
            Drug drug = drugService.selectOneByNameAndDrugstoreId(drugName, drugstoreInfo.getId());
            if (drug==null)
                continue;
            DrugstoreInfoDrugMoney drugstoreInfoDrugMoney = new DrugstoreInfoDrugMoney();
            BeanUtils.copyProperties(drugstoreInfo,drugstoreInfoDrugMoney);
            drugstoreInfoDrugMoney.setPrice(drug.getPrice());
            List<Drug> drugs = new ArrayList<>();
            drugs.add(drug);
            drugstoreInfoDrugMoney.setDrugs(drugs);
            drugstoreInfoDrugMonies.add(drugstoreInfoDrugMoney);
        }
        //自然排序
        drugstoreInfoDrugMonies.sort(Comparator.naturalOrder());
        return drugstoreInfoDrugMonies;
    }
    @Override
    public List<DrugstoreInfo> geoNearByPlaceAccordingToDistance(Double longitude, Double latitude, Integer distance, Integer limit, String drugName) {

        List<DrugstoreInfo> drugstoreInfos01 = new ArrayList<>();
        List<DrugstoreInfo> drugstoreInfos = geoNearByPlace(longitude, latitude, distance, limit);
        List<Drugstore> drugstores = selectListByDrugName(drugName);

        for(DrugstoreInfo drugstoreInfo:drugstoreInfos){
            for (Drugstore drugstore:drugstores){
                if (drugstore.getId().intValue()==drugstoreInfo.getId().intValue()){
                    Drug drug = drugService.selectOneByNameAndDrugstoreId(drugName, drugstoreInfo.getId());
                    List<Drug> drugs = new ArrayList<>();
                    drugs.add(drug);
                    drugstoreInfo.setDrugs(drugs);
                    drugstoreInfos01.add(drugstoreInfo);
                    break;
                }
            }
        }

        return drugstoreInfos01;
    }
    @Override
    public List<DrugstoreInfo> calculateDistanceByPrescriptionInfo(GeographicInfo geoInfo) {
        List<DrugstoreInfo> drugstoreInfos1 = new ArrayList<>();

        List<DrugstoreInfo> drugstoreInfos = geoNearByPlace(geoInfo.getLongitude(), geoInfo.getLatitude(), geoInfo.getDistance(), geoInfo.getLimit());

        for (DrugstoreInfo drugstoreInfo:drugstoreInfos){
            drugstoreInfo.setDrugs(drugService.selectListByDrugstoreId(drugstoreInfo.getId()));
            if (dealWith(1,drugstoreInfo,geoInfo.getPrescriptionInfos())>0){
                drugstoreInfos1.add(drugstoreInfo);
            }
            if (geoInfo.getPrescriptionInfos().size()==0)
                break;
        }

//        System.out.println(geoInfo.getPrescriptionInfos());

        if(geoInfo.getPrescriptionInfos().size()>0)
            return null;

        return drugstoreInfos1;
    }

    @Override
    public List<DrugstoreInfo> calculateMoneyByPrescriptionInfo(GeographicInfo geoInfo) {
        List<DrugstoreInfo> drugstoreInfos01 = new ArrayList<>();
        List<DrugstoreInfo> drugstoreInfos = geoNearByPlaceAllDrugstoreInfo(geoInfo.getLongitude(), geoInfo.getLatitude(), geoInfo.getDistance(), geoInfo.getLimit());
        List<PrescriptionInfo> prescriptionInfos = geoInfo.getPrescriptionInfos();

//        System.out.println("1、"+drugstoreInfos.size());

        //1、保留包含处方单药品的药店
        List<Integer> integers = new ArrayList<>();
        for (DrugstoreInfo drugstoreInfo:drugstoreInfos){
            if (dealWith(2,drugstoreInfo,prescriptionInfos)==0){

//                System.out.println("删除"+drugstoreInfos.indexOf(drugstoreInfo));
//                System.out.println(drugstoreInfo);
//                System.out.println("---------");
                integers.add(drugstoreInfos.indexOf(drugstoreInfo));
            }
        }
        for(Integer integer:integers){
            int result = integer;
            DrugstoreInfo drugstoreInfo = drugstoreInfos.get(result);
            drugstoreInfo=null;

        }
//        System.out.println("2、"+drugstoreInfos.size());
//        System.out.println(drugstoreInfos);
        //2、获得处方单药价最少的药店
//        System.out.println(drugstoreInfos);

        List<Integer> integers1 = new ArrayList<>();
        for (PrescriptionInfo prescriptionInfo:prescriptionInfos){
            int index=-1;
            double money=-1;

            for (DrugstoreInfo drugstoreInfo:drugstoreInfos){
                for (Drug drug:drugstoreInfo.getDrugs()){
                    if (drug.getName().equals(prescriptionInfo.getName())){
                        if (money==-1){
                            index = drugstoreInfos.indexOf(drugstoreInfo);
                            money = drug.getPrice();
                            break;
                        }
                        if (drug.getPrice()<money){
                           index = drugstoreInfos.indexOf(drugstoreInfo);
                           break;
                        }
                    }
                }
            }
            if (index==-1){
                return null;
            }
            integers1.add(index);
        }
//        System.out.println("3、"+integers1.size());

        //3、去除处方单药价最少的药店其他药品
        int i=0;
        for (PrescriptionInfo prescriptionInfo:prescriptionInfos){
            int index = integers1.get(i);
            DrugstoreInfo drugstoreInfo = new DrugstoreInfo();
            BeanUtils.copyProperties(drugstoreInfos.get(index),drugstoreInfo);

            List<Drug> drugs = new ArrayList<>();
            for (Drug drug:drugstoreInfo.getDrugs()){
                if (drug.getName().equals(prescriptionInfo.getName())){
                    drugs.add(drug);
                    break;
                }
            }
            drugstoreInfo.setDrugs(drugs);
            drugstoreInfos01.add(drugstoreInfo);
            i++;
        }
//        System.out.println("4、"+drugstoreInfos01.size());

        //4、整合药店
        List<Integer> integers2 = new ArrayList<>();
        for (DrugstoreInfo drugstoreInfo:drugstoreInfos01){
            int index = drugstoreInfos01.indexOf(drugstoreInfo);

            if (integers2.contains(index)){
                continue;
            }

            for (DrugstoreInfo drugstoreInfo1:drugstoreInfos01){
                int index1 = drugstoreInfos01.indexOf(drugstoreInfo1);
                if (index==index1){
                    continue;
                }
                if (drugstoreInfo.getId().intValue()== drugstoreInfo1.getId().intValue()){
                    integers2.add(index1);
                    drugstoreInfo.getDrugs().addAll(drugstoreInfo1.getDrugs());
                }
            }

        }
        for (int index:integers2){
            drugstoreInfos01.remove(index);
        }
//        System.out.println(drugstoreInfos01);

        Collections.sort(drugstoreInfos01, (o1, o2) -> (int) (o1.getDistance() - o2.getDistance()));
        return drugstoreInfos01;
    }

    //判断当前药店是否含有该处方单所需要的药品
    public int dealWith(int i,DrugstoreInfo drugstoreInfo,List<PrescriptionInfo> prescriptionInfos){
        List<Drug> drugs1 = new ArrayList<>();
        List<Drug> drugs = drugstoreInfo.getDrugs();
        List<Integer> integers = new ArrayList<>();

        for (PrescriptionInfo prescriptionInfo:prescriptionInfos){
            for (Drug drug:drugs){
                if (prescriptionInfo.getName().equals(drug.getName())){
//                    System.out.println(drug.getName());
                    drugs1.add(drug);
                    integers.add(prescriptionInfos.indexOf(prescriptionInfo));
                    break;
                }
            }
        }
        if (i==1){
            //删除匹配的元素
            deletePrescriptionInfos(integers,prescriptionInfos);
        }

        drugstoreInfo.setDrugs(drugs1);
//        System.out.println(drugstoreInfo);
        return drugs1.size();
    }
    //删除匹配的元素
    public void deletePrescriptionInfos(List<Integer>integers,List<PrescriptionInfo> prescriptionInfos){
        int offer = 0;
        Collections.sort(integers);
        for (Integer integer:integers) {
            int index=integer;
            prescriptionInfos.remove(index-offer);
            offer++;
        }
    }
}
