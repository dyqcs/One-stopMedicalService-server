package com.example.onestopmedicalserviceserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.onestopmedicalserviceserver.dao.MajorDepartmentDao;
import com.example.onestopmedicalserviceserver.domain.Doctor;
import com.example.onestopmedicalserviceserver.domain.MajorDepartment;
import com.example.onestopmedicalserviceserver.domain.SmallDepartment;
import com.example.onestopmedicalserviceserver.entry.MajorDepartmentInfo;
import com.example.onestopmedicalserviceserver.service.MajorDepartmentService;
import com.example.onestopmedicalserviceserver.service.SmallDepartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class MajorDepartmentServiceImpl implements MajorDepartmentService {

    @Autowired
    MajorDepartmentDao majorDepartmentDao;
    @Autowired
    SmallDepartService smallDepartService;

    @Override
    public List<MajorDepartment> selectAll() {
        return majorDepartmentDao.selectList(null);
    }

    //判断大科室是否重复
    public MajorDepartmentInfo result(String name,List<MajorDepartmentInfo> majorDepartmentInfos){
        for(MajorDepartmentInfo majorDepartmentInfo:majorDepartmentInfos){
            if(majorDepartmentInfo.getName().equals(name)){
                return majorDepartmentInfo;
            }
        }
        return null;
    }

    @Override
    public List<MajorDepartmentInfo> selectAllMajorDepartmentInfo() {
        List<MajorDepartment> majorDepartments = selectAll();
        List<MajorDepartmentInfo> majorDepartmentInfos = new ArrayList<>();
        for (MajorDepartment majorDepartment:majorDepartments){

            MajorDepartmentInfo majorDepartmentInfo1 = result(majorDepartment.getName(), majorDepartmentInfos);
            if(majorDepartmentInfo1!=null){
                Set<SmallDepartment> smallDepartments = majorDepartmentInfo1.getSmallDepartments();
                smallDepartments.addAll(smallDepartService.selectListByMajorDepartmentId(majorDepartment.getId()));
                continue;
            }

            MajorDepartmentInfo majorDepartmentInfo = new MajorDepartmentInfo();
            BeanUtils.copyProperties(majorDepartment,majorDepartmentInfo);
            majorDepartmentInfo.setSmallDepartments(smallDepartService.selectListByMajorDepartmentId(majorDepartment.getId()));
            majorDepartmentInfos.add(majorDepartmentInfo);

        }
        return majorDepartmentInfos;
    }

    @Override
    public MajorDepartment selectOneById(int id) {
        return majorDepartmentDao.selectById(id);
    }

    @Override
    public List<MajorDepartment> selectListByDoctorName(String doctorName) {
        List<SmallDepartment> smallDepartments = smallDepartService.selectListByDoctorName(doctorName);
        List<MajorDepartment> majorDepartments = new ArrayList<>();
        for(SmallDepartment smallDepartment:smallDepartments){
            MajorDepartment majorDepartment = selectOneById(smallDepartment.getMajorDepartmentId());
            if (majorDepartment!=null)
                majorDepartments.add(majorDepartment);
        }
        return majorDepartments;
    }

    @Override
    public MajorDepartment selectOneByDoctorId(Integer doctorId) {
        SmallDepartment smallDepartment = smallDepartService.selectOneByDoctorId(doctorId);
        if(smallDepartment==null)
            return null;
        return selectOneById(smallDepartment.getMajorDepartmentId());
    }

}
