package com.example.onestopmedicalserviceserver.drugRelated.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.onestopmedicalserviceserver.drugRelated.domain.Drug;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DrugDao extends BaseMapper<Drug> {
}
