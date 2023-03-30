package com.example.onestopmedicalserviceserver.controller;

import com.example.onestopmedicalserviceserver.service.HospitalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags="医院信息")
@RestController
@RequestMapping("hospital")
public class HospitalController {
    @Autowired
    HospitalService hospitalService;

    @ApiOperation("查询所有医院")
    @GetMapping("selectAll")
    public Result selectAll(){
        return new Result(Code.GET_OK,hospitalService.selectAll());
    }

    @ApiOperation("根据医院名字查询")
    @GetMapping("selectByName")
    public Result selectByName(String name){
        return new Result(Code.GET_OK,hospitalService.selectListByName(name));
    }

    @ApiOperation("根据医院id查询")
    @GetMapping("selectById")
    public Result selectById(Integer id){
        return new Result(Code.GET_OK,hospitalService.selectOneById(id));
    }

    @ApiOperation("根据医生名字查询医院")
    @GetMapping("selectListByDoctorName")
    public Result selectListByDoctorName(String doctorName){
        return new Result(Code.GET_OK,hospitalService.selectListByDoctorName(doctorName));
    }

    @ApiOperation("根据医生id编号查询医院")
    @GetMapping("selectOneByDoctorId")
    public Result selectOneByDoctorId(Integer doctorId){
        return new Result(Code.GET_OK,hospitalService.selectOneByDoctorId(doctorId));
    }

}
