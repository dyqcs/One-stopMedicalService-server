package com.example.onestopmedicalserviceserver.controller;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("前后端数据传输规范")
public class Result {
    @ApiModelProperty("数据")
    private Object data;
    @ApiModelProperty("编码")
    private Integer code;
    @ApiModelProperty("信息")
    private String msg;

    public Result() {
    }

    public Result(Integer code,Object data) {
        this.data = data;
        this.code = code;
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code,Object data,  String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }
}
