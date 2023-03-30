package com.example.onestopmedicalserviceserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.onestopmedicalserviceserver.dao.PrescriptionInfoDao;
import com.example.onestopmedicalserviceserver.domain.PrescriptionInfo;
import com.example.onestopmedicalserviceserver.service.PrescriptionInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PrescriptionInfoServiceImpl implements PrescriptionInfoService {

    @Autowired
    PrescriptionInfoDao prescriptionInfoDao;

    @Override
    public List<PrescriptionInfo> selectAll() {
        return prescriptionInfoDao.selectList(null);
    }

    @Override
    public PrescriptionInfo selectOneByName(String name) {
        LambdaQueryWrapper<PrescriptionInfo> lqw = new LambdaQueryWrapper<>();
        lqw.eq(PrescriptionInfo::getName,name);
        return prescriptionInfoDao.selectOne(lqw);
    }

    @Override
    public PrescriptionInfo selectOneById(int id) {
        return prescriptionInfoDao.selectById(id);
    }

    @Override
    public int insertOne(PrescriptionInfo prescriptionInfo) {
        return prescriptionInfoDao.insert(prescriptionInfo);
    }

    @Override
    public List<PrescriptionInfo> selectListByPrescriptionId(String id) {
        LambdaQueryWrapper<PrescriptionInfo> lqw = new LambdaQueryWrapper<>();
        lqw.eq(PrescriptionInfo::getPrescriptionId,id);
        return prescriptionInfoDao.selectList(lqw);
    }
}
