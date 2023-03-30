package com.example.onestopmedicalserviceserver.controller.test;

import com.example.onestopmedicalserviceserver.controller.Code;
import com.example.onestopmedicalserviceserver.controller.Result;
import com.example.onestopmedicalserviceserver.service.weChat.GoodListService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags="微信小程序测试")
@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    GoodListService goodListService;

    @ApiOperation("所有商品")
    @GetMapping("selectAll")
    public Result selectAll(){
        return new Result(Code.GET_OK, goodListService.selectAll(),"嘿嘿");
    }

    @ApiOperation("单个商品")
    @GetMapping("selectOne")
    public Result selectOne(int goodsId){

        return new Result(Code.GET_OK,goodListService.selectOneById(goodsId),"嘿嘿");
    }

    @ApiOperation("根据名字查商品")
    @GetMapping("selectByName")
    Result selectByName(String name){

        return new Result(Code.GET_OK,goodListService.selectOneByName(name));
    }
}
