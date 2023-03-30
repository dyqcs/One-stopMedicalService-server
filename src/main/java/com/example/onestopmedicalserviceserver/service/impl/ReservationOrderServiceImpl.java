package com.example.onestopmedicalserviceserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.onestopmedicalserviceserver.dao.ReservationOrderDao;
import com.example.onestopmedicalserviceserver.domain.ReservationOrder;
import com.example.onestopmedicalserviceserver.entry.ReservationOrderInfo;
import com.example.onestopmedicalserviceserver.service.DoctorService;
import com.example.onestopmedicalserviceserver.service.ReservationOrderService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ReservationOrderServiceImpl implements ReservationOrderService {

    @Autowired
    ReservationOrderDao reservationOrderDao;

    @Autowired
    DoctorService doctorService;

    @Override
    public List<ReservationOrder> selectAll() {
        return reservationOrderDao.selectList(null);
    }

    @Override
    public List<ReservationOrderInfo> selectListReservationOrderInfo() {
        List<ReservationOrder> reservationOrders = selectAll();
        List<ReservationOrderInfo> infos = new ArrayList<>();
        for (ReservationOrder reservationOrder:reservationOrders){
            infos.add(selectOneReservationOrderInfo(reservationOrder.getId()));
        }
        return infos;
    }

    @Override
    public ReservationOrder selectOneById(String id) {
        return reservationOrderDao.selectById(id);
    }

    @Override
    public ReservationOrderInfo selectOneReservationOrderInfo(String id) {
        ReservationOrderInfo info = new ReservationOrderInfo();
        ReservationOrder reservationOrder = selectOneById(id);
        if (reservationOrder==null)
            return null;
        BeanUtils.copyProperties(reservationOrder,info);
        info.setDoctorInfo(doctorService.selectOneByIdToDoctorInfo(reservationOrder.getDoctorId()));
        return info;
    }

    @Override
    public String insertOne(ReservationOrder reservationOrder) {
        reservationOrderDao.insert(reservationOrder);
        return reservationOrder.getId();
    }

    @Override
    public List<ReservationOrder> selectListByDoctorId(Integer doctorId) {
        LambdaQueryWrapper<ReservationOrder> lqw = new LambdaQueryWrapper<>();
        lqw.eq(ReservationOrder::getDoctorId,doctorId);
        return reservationOrderDao.selectList(lqw);
    }

    @Override
    public int deleteReservationOrderById(String id) {
        return reservationOrderDao.deleteById(id);
    }
}
