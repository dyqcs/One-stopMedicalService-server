package com.example.onestopmedicalserviceserver.controller;

import com.example.onestopmedicalserviceserver.entry.DrugOrderForm;
import com.example.onestopmedicalserviceserver.service.DrugOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="药品订单")
@RestController
@RequestMapping("drugOrder")
public class DrugOrderController {

    @Autowired
    DrugOrderService drugOrderService;

    @ApiOperation("查询所有药品订单")
    @GetMapping("selectAll")
    public Result selectAll(){
        return new Result(Code.GET_OK,drugOrderService.selectAll());
    }

    @ApiOperation("根据药品订单id查询")
    @GetMapping("selectById")
    public Result selectById(String id){
        return new Result(Code.GET_OK,drugOrderService.selectOneById(id),"");
    }

    @ApiOperation("根据药品订单id查询药品订单详细信息（包括药品清单）")
    @GetMapping("selectDrugOrderFormById")
    public Result selectDrugOrderFormById(String id){
        return new Result(Code.GET_OK,drugOrderService.selectDrugOrderFormById(id),"");
    }

    @ApiOperation("添加药品订单（包括药品清单）")
    @PostMapping("insertDrugOrderForm")
    public Result insertDrugOrderForm(@RequestBody DrugOrderForm drugOrderForm){
        return new Result(Code.GET_OK,drugOrderService.insertDrugOrderForm(drugOrderForm),"");
    }
}
