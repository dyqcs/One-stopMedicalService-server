package com.example.onestopmedicalserviceserver.controller;

import com.example.onestopmedicalserviceserver.domain.Prescription;
import com.example.onestopmedicalserviceserver.entry.prescription.PrescriptionForm;
import com.example.onestopmedicalserviceserver.service.PrescriptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="处方单信息")
@RestController
@RequestMapping("prescription")
public class PrescriptionController {
    @Autowired
    PrescriptionService prescriptionService;

    @ApiOperation("查询所有处方单")
    @GetMapping("selectAll")
    public Result selectAll(){
        return new Result(Code.GET_OK,prescriptionService.selectAll());
    }

    @ApiOperation("根据处方单id查询")
    @GetMapping("selectById")
    public Result selectById(String id){
        return new Result(Code.GET_OK,prescriptionService.selectOneById(id),"");
    }

    @ApiOperation("创建处方单")
    @PostMapping("insertOne")
    public Result insertOne(@RequestBody PrescriptionForm pf){
        return new Result(Code.GET_OK,prescriptionService.createPrescriptionForm(pf),"");
    }

}
