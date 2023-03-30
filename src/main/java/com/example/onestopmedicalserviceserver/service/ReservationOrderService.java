package com.example.onestopmedicalserviceserver.service;

import com.example.onestopmedicalserviceserver.domain.ReservationOrder;
import com.example.onestopmedicalserviceserver.entry.ReservationOrderInfo;
import io.swagger.models.auth.In;

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
