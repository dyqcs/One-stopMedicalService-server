package com.example.onestopmedicalserviceserver.hospitalRelated.controller;

import com.example.onestopmedicalserviceserver.config.standard.Code;
import com.example.onestopmedicalserviceserver.config.standard.Result;
import com.example.onestopmedicalserviceserver.hospitalRelated.service.SmallDepartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags="小科室信息")
@RestController
@RequestMapping("smallDepart")
public class SmallDepartController {
    @Autowired
    SmallDepartService smallDepartService;

    @ApiOperation("查询所有小科室")
    @GetMapping("selectAll")
    public Result selectAll(){
        return new Result(Code.GET_OK,smallDepartService.selectAll());
    }

    @ApiOperation("根据小科室id查询")
    @GetMapping("selectById")
    public Result selectById(Integer id){
        return new Result(Code.GET_OK,smallDepartService.selectOneById(id));
    }

    @ApiOperation("根据大科室id查询旗下的小科室")
    @GetMapping("selectListByMajorDepartmentId")
    public Result selectListByMajorDepartmentId(Integer majorDepartmentId){
        return new Result(Code.GET_OK,smallDepartService.selectListByMajorDepartmentId(majorDepartmentId));
    }

    @ApiOperation("根据医生名字查询小科室")
    @GetMapping("selectListByDoctorName")
    public Result selectListByDoctorName(String doctorName){
        return new Result(Code.GET_OK,smallDepartService.selectListByDoctorName(doctorName));
    }

    @ApiOperation("根据医生id编号查询小科室")
    @GetMapping("selectOneByDoctorId")
    public Result selectOneByDoctorId(Integer doctorId){
        return new Result(Code.GET_OK,smallDepartService.selectOneByDoctorId(doctorId));
    }

}
