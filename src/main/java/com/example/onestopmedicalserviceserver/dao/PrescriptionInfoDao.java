package com.example.onestopmedicalserviceserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.onestopmedicalserviceserver.domain.Drugstore;
import com.example.onestopmedicalserviceserver.domain.PrescriptionInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrescriptionInfoDao extends BaseMapper<PrescriptionInfo> {
}
