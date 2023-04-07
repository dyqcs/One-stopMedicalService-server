package com.example.onestopmedicalserviceserver.hospitalRelated.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.onestopmedicalserviceserver.hospitalRelated.domain.Hospital;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HospitalDao extends BaseMapper<Hospital> {
}
