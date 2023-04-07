package com.example.onestopmedicalserviceserver.hospitalRelated.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.onestopmedicalserviceserver.hospitalRelated.domain.ReservationOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReservationOrderDao extends BaseMapper<ReservationOrder> {
}
