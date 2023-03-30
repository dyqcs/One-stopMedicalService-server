package com.example.onestopmedicalserviceserver.service;

import com.example.onestopmedicalserviceserver.domain.Drugstore;
import com.example.onestopmedicalserviceserver.domain.MajorDepartment;
import com.example.onestopmedicalserviceserver.domain.SmallDepartment;
import com.example.onestopmedicalserviceserver.entry.DrugstoreInfo;
import com.example.onestopmedicalserviceserver.entry.MajorDepartmentInfo;

import java.util.List;

public interface MajorDepartmentService {
    List<MajorDepartment> selectAll();
    List<MajorDepartmentInfo> selectAllMajorDepartmentInfo();
    MajorDepartment selectOneById(int id);
    List<MajorDepartment> selectListByDoctorName(String doctorName);
    MajorDepartment selectOneByDoctorId(Integer doctorId);

}
