package com.example.onestopmedicalserviceserver.hospitalRelated.service;

import com.example.onestopmedicalserviceserver.hospitalRelated.domain.Doctor;
import com.example.onestopmedicalserviceserver.hospitalRelated.entry.DoctorInfo;

import java.util.List;

public interface DoctorService {
    List<Doctor> selectAll();
    List<DoctorInfo> selectAllDoctorInfo();
    Doctor selectOneById(Integer id);
    List<Doctor> selectListByName(String name);
    List<DoctorInfo> selectListBySmallDepartmentId(Integer smallDepartmentId);
    DoctorInfo selectOneByIdToDoctorInfo(Integer id);
    int deleteById(int id);
    int insertOne(Doctor doctor);
    int update(Doctor doctor);
}
