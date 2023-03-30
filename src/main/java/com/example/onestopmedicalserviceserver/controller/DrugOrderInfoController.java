package com.example.onestopmedicalserviceserver.controller;

import com.example.onestopmedicalserviceserver.service.DrugOrderInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="药品订单药品信息（具体药品订单信息）")
@RestController
@RequestMapping("drugOrderInfo")
public class DrugOrderInfoController {

    @Autowired
    DrugOrderInfoService drugOrderInfoService;

    @ApiOperation("查询所有药品订单信息")
    @GetMapping("selectAll")
    public Result selectAll(){
        return new Result(Code.GET_OK,drugOrderInfoService.selectAll());
    }

    @ApiOperation("根据药品订单信息id查询（当前表id）")
    @GetMapping("selectById")
    public Result selectById(String id){
        return new Result(Code.GET_OK,drugOrderInfoService.selectOneById(id),"");
    }

    @ApiOperation("根据药品订单id查询（订单编号（id））")
    @GetMapping("selectListByDrugOrderId")
    public Result selectListByDrugOrderId(String drugOrderId){
        return new Result(Code.GET_OK,drugOrderInfoService.selectListByDrugOrderId(drugOrderId),"");
    }

}
