package com.example.onestopmedicalserviceserver.hospitalRelated.service;

import com.example.onestopmedicalserviceserver.hospitalRelated.domain.Hospital;

import java.util.List;

public interface HospitalService {
    List<Hospital> selectAll();
    List<Hospital> selectListByName(String name);
    Hospital selectOneById(Integer id);
    Hospital selectOneByDoctorId(Integer doctorId);
    List<Hospital> selectListByDoctorName(String doctorName);
}
