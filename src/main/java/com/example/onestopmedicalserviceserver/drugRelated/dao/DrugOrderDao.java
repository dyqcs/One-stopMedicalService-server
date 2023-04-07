package com.example.onestopmedicalserviceserver.drugRelated.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.onestopmedicalserviceserver.drugRelated.domain.DrugOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DrugOrderDao extends BaseMapper<DrugOrder> {
}
