package com.example.onestopmedicalserviceserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.onestopmedicalserviceserver.dao.DoctorDao;
import com.example.onestopmedicalserviceserver.domain.Doctor;
import com.example.onestopmedicalserviceserver.entry.DoctorInfo;
import com.example.onestopmedicalserviceserver.service.DoctorService;
import com.example.onestopmedicalserviceserver.service.HospitalService;
import com.example.onestopmedicalserviceserver.service.MajorDepartmentService;
import com.example.onestopmedicalserviceserver.service.SmallDepartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorDao doctorDao;
    @Autowired
    SmallDepartService smallDepartService;
    @Autowired
    MajorDepartmentService majorDepartmentService;
    @Autowired
    HospitalService hospitalService;

    @Override
    public List<Doctor> selectAll() {
        return doctorDao.selectList(null);
    }

    @Override
    public List<DoctorInfo> selectAllDoctorInfo() {
        List<Doctor> doctors = selectAll();
        List<DoctorInfo> doctorInfos = new ArrayList<>();
        for (Doctor doctor:doctors){
            doctorInfos.add(selectOneByIdToDoctorInfo(doctor.getId()));
        }
        return doctorInfos;
    }

    @Override
    public Doctor selectOneById(Integer id) {
        return doctorDao.selectById(id);
    }

    @Override
    public List<Doctor> selectListByName(String name) {
        LambdaQueryWrapper<Doctor> lqw = new LambdaQueryWrapper<>();

        lqw.eq(Doctor::getName,name);
        return doctorDao.selectList(lqw);
    }

    @Override
    public List<DoctorInfo> selectListBySmallDepartmentId(Integer smallDepartmentId) {
        LambdaQueryWrapper<Doctor> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Doctor::getSmallDepartmentId,smallDepartmentId);
        List<Doctor> doctors = doctorDao.selectList(lqw);
        List<DoctorInfo> doctorInfos = new ArrayList<>();
        for (Doctor doctor:doctors){
            DoctorInfo doctorInfo = selectOneByIdToDoctorInfo(doctor.getId());
            if(doctorInfo!=null)
                doctorInfos.add(doctorInfo);
        }
        return doctorInfos;
    }

    @Override
    public DoctorInfo selectOneByIdToDoctorInfo(Integer id) {
        Doctor doctor = selectOneById(id);
        if (doctor==null)
            return null;
        DoctorInfo doctorInfo = new DoctorInfo();
        BeanUtils.copyProperties(doctor,doctorInfo);
        doctorInfo.setHospital(hospitalService.selectOneByDoctorId(id));
        doctorInfo.setMajorDepartment(majorDepartmentService.selectOneByDoctorId(id));
        doctorInfo.setSmallDepartment(smallDepartService.selectOneByDoctorId(id));
        return doctorInfo;
    }

    @Override
    public int deleteById(int id) {
        return doctorDao.deleteById(id);
    }

    @Override
    public int insertOne(Doctor doctor) {
        return doctorDao.insert(doctor);
    }

    @Override
    public int update(Doctor doctor) {
        LambdaQueryWrapper<Doctor> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Doctor::getId,doctor.getId());
        return doctorDao.update(doctor,lqw);
    }
}
