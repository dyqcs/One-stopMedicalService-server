package com.example.onestopmedicalserviceserver.service.impl;

import com.example.onestopmedicalserviceserver.dao.DrugOrderDao;
import com.example.onestopmedicalserviceserver.domain.DrugOrder;
import com.example.onestopmedicalserviceserver.domain.DrugOrderInfo;
import com.example.onestopmedicalserviceserver.entry.DrugOrderForm;
import com.example.onestopmedicalserviceserver.service.DrugOrderInfoService;
import com.example.onestopmedicalserviceserver.service.DrugOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class DrugOrderServiceImpl implements DrugOrderService {

    @Autowired
    DrugOrderDao drugOrderDao;
    @Autowired
    DrugOrderInfoService drugOrderInfoService;

    @Override
    public List<DrugOrder> selectAll() {
        return drugOrderDao.selectList(null);
    }

    @Override
    public DrugOrder selectOneById(String id) {
        return drugOrderDao.selectById(id);
    }

    @Override
    public DrugOrderForm selectDrugOrderFormById(String id) {
        DrugOrder drugOrder = selectOneById(id);
        if (drugOrder == null)
            return null;
        DrugOrderForm drugOrderForm = new DrugOrderForm();
        BeanUtils.copyProperties(drugOrder,drugOrderForm);
        drugOrderForm.setDrugOrderInfos(drugOrderInfoService.selectListByDrugOrderId(id));
        return drugOrderForm;
    }

    @Override
    public String insertDrugOrderForm(DrugOrderForm drugOrderForm) {
        DrugOrder drugOrder = drugOrderForm;
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String transformDate=simpleDateFormat.format(new Date());

        drugOrderForm.setCreateTime(transformDate);

        int insert = drugOrderDao.insert(drugOrder);
        if (insert<=0)
            return null;
        List<DrugOrderInfo> drugOrderInfos = drugOrderForm.getDrugOrderInfos();
        for (DrugOrderInfo drugOrderInfo : drugOrderInfos){
            drugOrderInfo.setDrugOrderId(drugOrder.getId());
            drugOrderInfoService.insertOne(drugOrderInfo);
        }
        return drugOrderForm.getId();
    }
}
