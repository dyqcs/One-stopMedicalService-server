package com.example.onestopmedicalserviceserver.hospitalRelated.service;

import com.example.onestopmedicalserviceserver.hospitalRelated.domain.MajorDepartment;
import com.example.onestopmedicalserviceserver.hospitalRelated.entry.MajorDepartmentInfo;

import java.util.List;

public interface MajorDepartmentService {
    List<MajorDepartment> selectAll();
    List<MajorDepartmentInfo> selectAllMajorDepartmentInfo();
    MajorDepartment selectOneById(int id);
    List<MajorDepartment> selectListByDoctorName(String doctorName);
    MajorDepartment selectOneByDoctorId(Integer doctorId);

}
