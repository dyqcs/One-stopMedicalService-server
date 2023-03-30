package com.example.onestopmedicalserviceserver.controller;

import com.example.onestopmedicalserviceserver.service.DrugService;
import com.example.onestopmedicalserviceserver.service.MajorDepartmentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags="大科室信息")
@RestController
@RequestMapping("majorDepartment")
public class MajorDepartmentController {
    @Autowired
    MajorDepartmentService majorDepartmentService;

    @ApiOperation("查询所有大科室")
    @GetMapping("selectAll")
    public Result selectAll(){
        return new Result(Code.GET_OK,majorDepartmentService.selectAll());
    }

    @ApiOperation("查询所有大科室信息")
    @GetMapping("selectAllMajorDepartmentInfo")
    public Result selectAllMajorDepartmentInfo(){
        return new Result(Code.GET_OK,majorDepartmentService.selectAllMajorDepartmentInfo());
    }


    @ApiOperation("根据大科室id查询")
    @GetMapping("selectById")
    public Result selectById(Integer id){
        return new Result(Code.GET_OK,majorDepartmentService.selectOneById(id));
    }

    @ApiOperation("根据医生名字查询大科室")
    @GetMapping("selectListByDoctorName")
    public Result selectListByDoctorName(String doctorName){
        return new Result(Code.GET_OK,majorDepartmentService.selectListByDoctorName(doctorName));
    }

    @ApiOperation("根据医生id编号查询大科室")
    @GetMapping("selectOneByDoctorId")
    public Result selectOneByDoctorId(Integer doctorId){
        return new Result(Code.GET_OK,majorDepartmentService.selectOneByDoctorId(doctorId));
    }

}
