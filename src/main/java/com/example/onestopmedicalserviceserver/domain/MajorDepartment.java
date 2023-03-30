package com.example.onestopmedicalserviceserver.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("大科室")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MajorDepartment {
    @TableId(type = IdType.AUTO)
    Integer id;
    String name;
    @ApiModelProperty("医院id")
    int hospitalId;

}
