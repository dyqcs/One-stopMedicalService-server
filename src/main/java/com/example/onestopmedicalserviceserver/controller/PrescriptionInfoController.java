package com.example.onestopmedicalserviceserver.controller;

import com.example.onestopmedicalserviceserver.service.PrescriptionInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags="处方开药信息（具体开药信息）")
@RestController
@RequestMapping("prescriptionInfo")
public class PrescriptionInfoController {
    @Autowired
    PrescriptionInfoService prescriptionInfoService;

    @ApiOperation("查询所有处方开药信息")
    @GetMapping("selectAll")
    public Result selectAll(){
        return new Result(Code.GET_OK,prescriptionInfoService.selectAll());
    }

    @ApiOperation("根据处方开药名字查询")
    @GetMapping("selectByName")
    public Result selectByName(String name){
        return new Result(Code.GET_OK,prescriptionInfoService.selectOneByName(name));
    }

    @ApiOperation("根据处方开药id（自身表id 主键）查询")
    @GetMapping("selectById")
    public Result selectById(Integer id){
        return new Result(Code.GET_OK,prescriptionInfoService.selectOneById(id));
    }

    @ApiOperation("根据处方单id（处方单表id 外键）查询所有处方信息")
    @GetMapping("selectListByPrescriptionId")
    public Result selectListByPrescriptionId(String id){
        return new Result(Code.GET_OK,prescriptionInfoService.selectListByPrescriptionId(id));
    }

}
