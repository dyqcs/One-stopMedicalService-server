package com.example.onestopmedicalserviceserver.hospitalRelated.service;

import com.example.onestopmedicalserviceserver.hospitalRelated.domain.ReservationOrder;
import com.example.onestopmedicalserviceserver.hospitalRelated.entry.ReservationOrderInfo;

import java.util.List;

public interface ReservationOrderService {
    List<ReservationOrder> selectAll();
    List<ReservationOrderInfo> selectListReservationOrderInfo();
    ReservationOrder selectOneById(String id);
    ReservationOrderInfo selectOneReservationOrderInfo(String id);
    String insertOne(ReservationOrder reservationOrder);
    List<ReservationOrder> selectListByDoctorId(Integer doctorId);
    int deleteReservationOrderById(String id);
}
