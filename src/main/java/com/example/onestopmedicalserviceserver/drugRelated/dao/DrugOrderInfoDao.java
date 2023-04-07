package com.example.onestopmedicalserviceserver.drugRelated.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.onestopmedicalserviceserver.drugRelated.domain.DrugOrderInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DrugOrderInfoDao extends BaseMapper<DrugOrderInfo> {
}
