package com.example.onestopmedicalserviceserver.service;

import com.example.onestopmedicalserviceserver.domain.Drugstore;
import com.example.onestopmedicalserviceserver.domain.SmallDepartment;
import com.example.onestopmedicalserviceserver.entry.DrugstoreInfo;

import java.util.List;
import java.util.Set;

public interface SmallDepartService {
    List<SmallDepartment> selectAll();
    SmallDepartment selectOneById(int id);
    List<SmallDepartment> selectListByDoctorName(String doctorName);
    Set<SmallDepartment> selectListByMajorDepartmentId(Integer majorDepartmentId);
    SmallDepartment selectOneByDoctorId(Integer doctorId);
}
