package com.example.onestopmedicalserviceserver.drugRelated.controller;

import com.example.onestopmedicalserviceserver.config.standard.Code;
import com.example.onestopmedicalserviceserver.config.standard.Result;
import com.example.onestopmedicalserviceserver.drugRelated.entry.GeographicInfo;
import com.example.onestopmedicalserviceserver.drugRelated.entry.TwoDrugstoreId;
import com.example.onestopmedicalserviceserver.drugRelated.service.DrugstoreService;
import com.example.onestopmedicalserviceserver.util.GeoHashUtil;
import com.example.onestopmedicalserviceserver.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="药店信息")
@RestController
@RequestMapping("drugstore")
public class DrugstoreController {

    @Autowired
    GeoHashUtil geoHashUtil;

    @Autowired
    RedisUtil redisUtil;
    @Autowired
    DrugstoreService drugstoreService;

    @ApiOperation("跟据俩个药店id计算相距距离")
    @PostMapping("distanceBetweenWwoPlaces")
    public Result distanceBetweenWwoPlaces(@RequestBody TwoDrugstoreId twoDrugstoreId){
        return new Result(Code.GET_OK,drugstoreService.distanceBetweenWwoPlaces(twoDrugstoreId.getDrugstore01Id(),twoDrugstoreId.getDrugstore02Id()));
    }

    @ApiOperation("查询所有药店信息")
    @GetMapping("selectAll")
    public Result selectAll(){
        return new Result(Code.GET_OK,drugstoreService.selectAll());
    }

    @ApiOperation("根据药店名称查询药店")
    @GetMapping("selectByName")
    public Result selectByName(String name){
        return new Result(Code.GET_OK,drugstoreService.selectOneByName(name));
    }

    @ApiOperation("根据药品名称查询所有拥有该药的药店")
    @GetMapping("selectListByDrugName")
    public Result selectListByDrugName(String name){
        return new Result(Code.GET_OK,drugstoreService.selectListByDrugName(name));
    }

    @ApiOperation("根据指定的经纬度查询以distance为距离的药店")
    @PostMapping("nearbyPlace")
    public Result nearbyPlace(@RequestBody GeographicInfo geographicInfo){
        return new Result(Code.GET_OK,drugstoreService.geoNearByPlace(geographicInfo.getLongitude(),geographicInfo.getLatitude(),geographicInfo.getDistance(),geographicInfo.getLimit()));
    }

    @ApiOperation("根据当前位置和药品名称进行药店查找（按药价升序排序）")
    @PostMapping("geoNearByPlaceAccordingToMoney")
    public Result geoNearByPlaceAccordingToMoney(@RequestBody GeographicInfo geographicInfo){
        return new Result(Code.GET_OK,drugstoreService.geoNearByPlaceAccordingToMoney(geographicInfo.getLongitude(),geographicInfo.getLatitude(),geographicInfo.getDistance(),geographicInfo.getLimit(),geographicInfo.getDrugName()));
    }

    @ApiOperation("根据当前位置进行药店查找（综合排序）")
    @PostMapping("geoNearByPlaceAllDrugstoreInfo")
    public Result geoNearByPlaceAllDrugstoreInfo(@RequestBody GeographicInfo geographicInfo){
        System.out.println(geographicInfo);
        return new Result(Code.GET_OK,drugstoreService.geoNearByPlaceAllDrugstoreInfo(geographicInfo.getLongitude(),geographicInfo.getLatitude(),geographicInfo.getDistance(),geographicInfo.getLimit()));
    }

    @ApiOperation("根据当前位置和药品名称进行药店查找（按距离升序排序）")
    @PostMapping("geoNearByPlaceAccordingToDistance")
    public Result geoNearByPlaceAccordingToDistance(@RequestBody GeographicInfo geographicInfo){
        return new Result(Code.GET_OK,drugstoreService.geoNearByPlaceAccordingToDistance(geographicInfo.getLongitude(),geographicInfo.getLatitude(),geographicInfo.getDistance(),geographicInfo.getLimit(),geographicInfo.getDrugName()));
    }

    @ApiOperation("根据当前位置和处方信息进行药店查找（按距离查找）")
    @PostMapping("calculateDistanceByPrescriptionInfo")
    public Result calculateDistanceByPrescriptionInfo(@RequestBody GeographicInfo geographicInfo){
        return new Result(Code.GET_OK,drugstoreService.calculateDistanceByPrescriptionInfo(geographicInfo));
    }

    @ApiOperation("根据当前位置和处方信息进行药店查找（按金额查找）")
    @PostMapping("calculateMoneyByPrescriptionInfo")
    public Result calculateMoneyByPrescriptionInfo(@RequestBody GeographicInfo geographicInfo){
        System.out.println(geographicInfo);
        return new Result(Code.GET_OK,drugstoreService.calculateMoneyByPrescriptionInfo(geographicInfo));
    }
}
