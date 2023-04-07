package com.example.onestopmedicalserviceserver.other.pdf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.onestopmedicalserviceserver.other.pdf.Prescription;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrescriptionDao extends BaseMapper<Prescription> {
}
