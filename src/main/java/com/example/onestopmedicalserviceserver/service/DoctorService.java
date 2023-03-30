package com.example.onestopmedicalserviceserver.service;

import com.example.onestopmedicalserviceserver.domain.Doctor;
import com.example.onestopmedicalserviceserver.entry.DoctorInfo;

import java.util.List;

public interface DoctorService {
    List<Doctor> selectAll();
    List<DoctorInfo> selectAllDoctorInfo();
    Doctor selectOneById(Integer id);
    List<Doctor> selectListByName(String name);
    List<DoctorInfo> selectListBySmallDepartmentId(Integer smallDepartmentId);
    DoctorInfo selectOneByIdToDoctorInfo(Integer id);

}
