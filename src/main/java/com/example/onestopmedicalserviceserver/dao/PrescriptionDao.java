package com.example.onestopmedicalserviceserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.onestopmedicalserviceserver.domain.Drugstore;
import com.example.onestopmedicalserviceserver.domain.Prescription;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrescriptionDao extends BaseMapper<Prescription> {
}
