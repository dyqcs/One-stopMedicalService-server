package com.example.onestopmedicalserviceserver.hospitalRelated.service;

import com.example.onestopmedicalserviceserver.hospitalRelated.domain.SmallDepartment;

import java.util.List;
import java.util.Set;

public interface SmallDepartService {
    List<SmallDepartment> selectAll();
    SmallDepartment selectOneById(int id);
    List<SmallDepartment> selectListByDoctorName(String doctorName);
    Set<SmallDepartment> selectListByMajorDepartmentId(Integer majorDepartmentId);
    SmallDepartment selectOneByDoctorId(Integer doctorId);
}
