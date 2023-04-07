package com.example.onestopmedicalserviceserver.hospitalRelated.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.onestopmedicalserviceserver.hospitalRelated.dao.SmallDepartmentDao;
import com.example.onestopmedicalserviceserver.hospitalRelated.domain.Doctor;
import com.example.onestopmedicalserviceserver.hospitalRelated.domain.SmallDepartment;
import com.example.onestopmedicalserviceserver.hospitalRelated.service.DoctorService;
import com.example.onestopmedicalserviceserver.hospitalRelated.service.SmallDepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SmallDepartServiceImpl implements SmallDepartService {

    @Autowired
    SmallDepartmentDao smallDepartmentDao;
    @Autowired
    DoctorService doctorService;

    @Override
    public List<SmallDepartment> selectAll() {
        return smallDepartmentDao.selectList(null);
    }


    @Override
    public SmallDepartment selectOneById(int id) {
        return smallDepartmentDao.selectById(id);
    }

    @Override
    public List<SmallDepartment> selectListByDoctorName(String doctorName) {
        List<Doctor> doctors = doctorService.selectListByName(doctorName);
        List<SmallDepartment> smallDepartments = new ArrayList<>();
        for(Doctor doctor:doctors){
            SmallDepartment smallDepartment = selectOneById(doctor.getSmallDepartmentId());
            if (smallDepartment!=null)
                smallDepartments.add(smallDepartment);
        }
        return smallDepartments;
    }

    @Override
    public Set<SmallDepartment> selectListByMajorDepartmentId(Integer majorDepartmentId) {
        LambdaQueryWrapper<SmallDepartment> lqw = new LambdaQueryWrapper<>();
        lqw.eq(SmallDepartment::getMajorDepartmentId,majorDepartmentId);
        Set<SmallDepartment> smallDepartments = new HashSet<>();
        List<SmallDepartment> smallDepartments1 = smallDepartmentDao.selectList(lqw);
        for(SmallDepartment smallDepartment:smallDepartments1){
            smallDepartments.add(smallDepartment);
        }
        return smallDepartments;
    }

    @Override
    public SmallDepartment selectOneByDoctorId(Integer doctorId) {
        Doctor doctor = doctorService.selectOneById(doctorId);
        if(doctor==null)
            return null;
        return selectOneById(doctor.getSmallDepartmentId());
    }
}
