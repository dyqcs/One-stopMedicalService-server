package com.example.onestopmedicalserviceserver.drugRelated.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.onestopmedicalserviceserver.drugRelated.dao.DrugDao;
import com.example.onestopmedicalserviceserver.drugRelated.dao.DrugRRotationDao;
import com.example.onestopmedicalserviceserver.drugRelated.domain.Drug;
import com.example.onestopmedicalserviceserver.drugRelated.domain.DrugRotation;
import com.example.onestopmedicalserviceserver.drugRelated.entry.DrugIdAndDrugName;
import com.example.onestopmedicalserviceserver.drugRelated.entry.DrugInfo;
import com.example.onestopmedicalserviceserver.drugRelated.service.DrugService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    DrugDao drugDao;
    @Autowired
    DrugRRotationDao drugRotationDao;

    @Override
    public List<Drug> selectAll() {

        return drugDao.selectList(null);
    }

    @Override
    public Set<DrugIdAndDrugName> selectALlDrugNameAndDrugId() {
        List<Drug> drugs = selectAll();
        Set<DrugIdAndDrugName> drugIdAndDrugNames = new HashSet<>();
        for (Drug drug : drugs){
            DrugIdAndDrugName drugIdAndDrugName = new DrugIdAndDrugName();
            String drugName = drug.getName();
            drugName= drugName+" "+drug.getStandards();
            drugIdAndDrugName.setDrugName(drugName);

            drugIdAndDrugName.setDrugId(drug.getId());
            drugIdAndDrugNames.add(drugIdAndDrugName);
        }
        return drugIdAndDrugNames;
    }


    @Override
    public List<Drug> selectListByName(String name) {
        LambdaQueryWrapper<Drug> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Drug::getName,name);
        return drugDao.selectList(lqw);
    }

    @Override
    public List<Drug> fuzzySearchListByName(String name) {
        LambdaQueryWrapper<Drug> lqw = new LambdaQueryWrapper<>();
        lqw.like(Drug::getName,name);
        return drugDao.selectList(lqw);
    }

    @Override
    public DrugInfo selectOneById(Integer id) {
        Drug drug =  drugDao.selectById(id);
        DrugInfo drugInfo = new DrugInfo();
        BeanUtils.copyProperties(drug,drugInfo);
        LambdaQueryWrapper<DrugRotation> lqw = new LambdaQueryWrapper<>();
        lqw.eq(DrugRotation::getDrugId,id);
        drugInfo.setDrugRotations(drugRotationDao.selectList(lqw));
        return drugInfo;
    }

    @Override
    public Drug selectOneByNameAndDrugstoreId(String drugName, Integer drugstoreId) {
        LambdaQueryWrapper<Drug> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Drug::getName,drugName).eq(Drug::getDrugstoreId,drugstoreId);

        List<Drug> drugs = drugDao.selectList(lqw);

        if(drugs.size()>0)
            return drugs.get(0);

        if( drugs!=null||drugs.size()==0)
            return null;

        return drugDao.selectOne(lqw);
    }

    @Override
    public List<Drug> selectListByDrugstoreId(Integer id) {
        LambdaQueryWrapper<Drug> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Drug::getDrugstoreId,id);
        return drugDao.selectList(lqw);
    }
}
