package com.example.onestopmedicalserviceserver.hospitalRelated.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("医院")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hospital {
    @TableId(type = IdType.AUTO)
    Integer id;
    String name;
    String introduce;
    @ApiModelProperty("经度")
    Double longitude;
    @ApiModelProperty("纬度")
    Double latitude;
}
