package com.example.onestopmedicalserviceserver.hospitalRelated.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.onestopmedicalserviceserver.hospitalRelated.domain.Doctor;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DoctorDao extends BaseMapper<Doctor> {
}
