package com.example.onestopmedicalserviceserver.controller;

import com.example.onestopmedicalserviceserver.domain.Doctor;
import com.example.onestopmedicalserviceserver.service.DoctorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="医生信息")
@RestController
@RequestMapping("doctor")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    @ApiOperation("查询所有医生")
    @GetMapping("selectAll")
    public Result selectAll(){
        return new Result(Code.GET_OK,doctorService.selectAll());
    }

    @ApiOperation("查询所有医生信息(包括医院科室等信息)")
    @GetMapping("selectAllDoctorInfo")
    public Result selectAllDoctorInfo(){
        return new Result(Code.GET_OK,doctorService.selectAllDoctorInfo());
    }

    @ApiOperation("根据医生id查询")
    @GetMapping("selectOneById")
    public Result selectOneById(Integer id){
        return new Result(Code.GET_OK,doctorService.selectOneById(id));
    }

    @ApiOperation("根据小科室id查询旗下的医生")
    @GetMapping("selectListBySmallDepartmentId")
    public Result selectListBySmallDepartmentId(Integer id){
        return new Result(Code.GET_OK,doctorService.selectListBySmallDepartmentId(id));
    }

    @ApiOperation("根据医生id查询医生所有信息(包括医院科室等信息)")
    @GetMapping("selectOneByIdToDoctorInfo")
    public Result selectOneByIdToDoctorInfo(Integer id){
        return new Result(Code.GET_OK,doctorService.selectOneByIdToDoctorInfo(id));
    }

    @ApiOperation("根据医生名字查询")
    @GetMapping("selectListByName")
    public Result selectListByName(String name){
        return new Result(Code.GET_OK,doctorService.selectListByName(name));
    }

    @ApiOperation("插入一个医生")
    @PostMapping("insertOne")
    public Result insertOne(@RequestBody Doctor doctor){
        return new Result(Code.GET_OK,doctorService.insertOne(doctor),"");
    }

    @ApiOperation("根据医生id删除医生信息")
    @GetMapping("insertOne")
    public Result insertOne(int id){
        return new Result(Code.GET_OK,doctorService.deleteById(id),"");
    }

    @ApiOperation("根据医生id修改医生信息")
    @GetMapping("update")
    public Result update(@RequestBody Doctor doctor){
        return new Result(Code.GET_OK,doctorService.update(doctor),"");
    }
}
