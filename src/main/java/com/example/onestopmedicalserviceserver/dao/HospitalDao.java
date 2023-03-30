package com.example.onestopmedicalserviceserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.onestopmedicalserviceserver.domain.Drugstore;
import com.example.onestopmedicalserviceserver.domain.Hospital;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HospitalDao extends BaseMapper<Hospital> {
}
