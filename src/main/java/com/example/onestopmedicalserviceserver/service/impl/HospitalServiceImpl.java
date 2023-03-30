package com.example.onestopmedicalserviceserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.onestopmedicalserviceserver.dao.HospitalDao;
import com.example.onestopmedicalserviceserver.domain.Doctor;
import com.example.onestopmedicalserviceserver.domain.Hospital;
import com.example.onestopmedicalserviceserver.domain.MajorDepartment;
import com.example.onestopmedicalserviceserver.domain.SmallDepartment;
import com.example.onestopmedicalserviceserver.service.DoctorService;
import com.example.onestopmedicalserviceserver.service.HospitalService;
import com.example.onestopmedicalserviceserver.service.MajorDepartmentService;
import com.example.onestopmedicalserviceserver.service.SmallDepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class HospitalServiceImpl implements HospitalService {

    @Autowired
    HospitalDao hospitalDao;
    @Autowired
    MajorDepartmentService majorDepartmentService;

    @Override
    public List<Hospital> selectAll() {
        return hospitalDao.selectList(null);
    }

    @Override
    public List<Hospital> selectListByName(String name) {
        LambdaQueryWrapper<Hospital> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Hospital::getName,name);
        return hospitalDao.selectList(lqw);
    }

    @Override
    public Hospital selectOneById(Integer id) {
        return hospitalDao.selectById(id);
    }

    @Override
    public Hospital selectOneByDoctorId(Integer doctorId) {
        MajorDepartment majorDepartment = majorDepartmentService.selectOneByDoctorId(doctorId);
        if(majorDepartment==null)
            return null;
        return selectOneById(majorDepartment.getHospitalId());
    }

    @Override
    public List<Hospital> selectListByDoctorName(String doctorName) {
        List<MajorDepartment> majorDepartments = majorDepartmentService.selectListByDoctorName(doctorName);
        List<Hospital> hospitals = new ArrayList<>();
        for(MajorDepartment majorDepartment:majorDepartments){
            Hospital hospital = selectOneById(majorDepartment.getHospitalId());
            if (hospital!=null)
                hospitals.add(hospital);
        }
        return hospitals;
    }
}
