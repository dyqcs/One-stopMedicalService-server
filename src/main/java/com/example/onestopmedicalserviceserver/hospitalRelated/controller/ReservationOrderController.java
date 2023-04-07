package com.example.onestopmedicalserviceserver.hospitalRelated.controller;

import com.example.onestopmedicalserviceserver.config.standard.Code;
import com.example.onestopmedicalserviceserver.config.standard.Result;
import com.example.onestopmedicalserviceserver.hospitalRelated.domain.ReservationOrder;
import com.example.onestopmedicalserviceserver.hospitalRelated.service.ReservationOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="预约订单")
@RestController
@RequestMapping("reservationOrder")
public class ReservationOrderController {

    @Autowired
    ReservationOrderService reservationOrderService;

    @ApiOperation("查询所有预约订单")
    @GetMapping("selectAll")
    public Result selectAll(){
        return new Result(Code.GET_OK,reservationOrderService.selectAll());
    }

    @ApiOperation("查询所有预约订单(包括医生全部信息)")
    @GetMapping("selectListReservationOrderInfo")
    public Result selectListReservationOrderInfo(){
        return new Result(Code.GET_OK,reservationOrderService.selectListReservationOrderInfo());
    }

    @ApiOperation("添加预约订单")
    @PostMapping("insertOne")
    public Result insertOne(@RequestBody ReservationOrder reservationOrder){
        return new Result(Code.GET_OK,reservationOrderService.insertOne(reservationOrder),"");
    }

    @ApiOperation("根据预约订单id查询")
    @GetMapping("selectById")
    public Result selectById(String id){
        return new Result(Code.GET_OK,reservationOrderService.selectOneById(id),"");
    }

    @ApiOperation("根据预约订单id查询(包括医生全部信息)")
    @GetMapping("selectOneReservationOrderInfo")
    public Result selectOneReservationOrderInfo(String id){
        return new Result(Code.GET_OK,reservationOrderService.selectOneReservationOrderInfo(id),"");
    }

    @ApiOperation("根据预约订单id删除")
    @GetMapping("deleteReservationOrderById")
    public Result deleteReservationOrderById(String id){
        return new Result(Code.GET_OK,reservationOrderService.deleteReservationOrderById(id),"");
    }

    @ApiOperation("根据医生id查询名下的预约订单")
    @GetMapping("selectListByDoctorId")
    public Result selectListByDoctorId(Integer doctorId){
        return new Result(Code.GET_OK,reservationOrderService.selectListByDoctorId(doctorId),"");
    }
}
