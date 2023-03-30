package com.example.onestopmedicalserviceserver.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.onestopmedicalserviceserver.domain.Drug;
import com.example.onestopmedicalserviceserver.domain.Drugstore;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DrugDao extends BaseMapper<Drug> {
}
