package com.example.onestopmedicalserviceserver.drugRelated.controller;

import com.example.onestopmedicalserviceserver.config.standard.Code;
import com.example.onestopmedicalserviceserver.config.standard.Result;
import com.example.onestopmedicalserviceserver.drugRelated.service.DrugService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags="药品信息")
@RestController
@RequestMapping("drug")
public class DrugController {
    @Autowired
    DrugService drugService;

    @ApiOperation("查询所有药品")
    @GetMapping("selectAll")
    public Result selectAll(){
        return new Result(Code.GET_OK,drugService.selectAll());
    }

    @ApiOperation("查询所有药品名称和药品id(去重)")
    @GetMapping("selectALlDrugNameAndDrugId")
    public Result selectALlDrugNameAndDrugId(){
        return new Result(Code.GET_OK,drugService.selectALlDrugNameAndDrugId());
    }

    @ApiOperation("根据药品id查询")
    @GetMapping("selectById")
    public Result selectById(Integer id){
        return new Result(Code.GET_OK,drugService.selectOneById(id));
    }

    @ApiOperation("根据药品名称+药店id查询返回药店该药信息")
    @GetMapping("selectOneByNameAndDrugstoreId")
    public Result selectOneByNameAndDrugstoreId(String drugName,Integer drugstoreId){
        return new Result(Code.GET_OK,drugService.selectOneByNameAndDrugstoreId(drugName,drugstoreId));
    }

    @ApiOperation("根据药品名称查询")
    @GetMapping("selectListByName")
    public Result selectListByName(String name){
        return new Result(Code.GET_OK,drugService.selectListByName(name));
    }

    @ApiOperation("根据药品名称查询(模糊查询)")
    @GetMapping("fuzzySearchListByName")
    public Result fuzzySearchListByName(String name){
        return new Result(Code.GET_OK,drugService.fuzzySearchListByName(name));
    }

    @ApiOperation("根据药店id查询名下的所售卖的药品")
    @GetMapping("selectListByDrugstoreId")
    public Result selectListByDrugstoreId(Integer id){
        return new Result(Code.GET_OK,drugService.selectListByDrugstoreId(id));
    }

}
