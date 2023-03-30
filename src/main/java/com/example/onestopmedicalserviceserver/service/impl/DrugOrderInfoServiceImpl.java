package com.example.onestopmedicalserviceserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.onestopmedicalserviceserver.dao.DrugOrderInfoDao;
import com.example.onestopmedicalserviceserver.domain.DrugOrderInfo;
import com.example.onestopmedicalserviceserver.service.DrugOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DrugOrderInfoServiceImpl implements DrugOrderInfoService {

    @Autowired
    DrugOrderInfoDao drugOrderInfoDao;

    @Override
    public List<DrugOrderInfo> selectAll() {
        return drugOrderInfoDao.selectList(null);
    }

    @Override
    public List<DrugOrderInfo> selectListByDrugOrderId(String drugOrderId) {
        LambdaQueryWrapper<DrugOrderInfo> lqw = new LambdaQueryWrapper<>();
        lqw.eq(DrugOrderInfo::getDrugOrderId,drugOrderId);
        return drugOrderInfoDao.selectList(lqw);
    }

    @Override
    public DrugOrderInfo selectOneById(String id) {
        return drugOrderInfoDao.selectById(id);
    }

    @Override
    public int insertOne(DrugOrderInfo drugOrderInfo) {
        return drugOrderInfoDao.insert(drugOrderInfo);
    }
}
