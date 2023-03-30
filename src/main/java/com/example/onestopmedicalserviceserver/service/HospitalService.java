package com.example.onestopmedicalserviceserver.service;

import com.example.onestopmedicalserviceserver.domain.Drugstore;
import com.example.onestopmedicalserviceserver.domain.Hospital;
import com.example.onestopmedicalserviceserver.entry.DrugstoreInfo;

import java.util.List;

public interface HospitalService {
    List<Hospital> selectAll();
    List<Hospital> selectListByName(String name);
    Hospital selectOneById(Integer id);
    Hospital selectOneByDoctorId(Integer doctorId);
    List<Hospital> selectListByDoctorName(String doctorName);
}
