package com.example.onestopmedicalserviceserver.drugRelated.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel("药店")
@AllArgsConstructor
@NoArgsConstructor
public class Drugstore {
    @TableId(type = IdType.AUTO)
    Integer id;
    String name;
    @ApiModelProperty("经度")
    Double longitude;
    @ApiModelProperty("纬度")
    Double latitude;
    String introduce;
    String address;
}
