package com.example.onestopmedicalserviceserver.other.pdf;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("处方单")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prescription {
    @ApiModelProperty("雪花算法不用输入")
    @TableId(type = IdType.ASSIGN_ID)
    String id;
    String hospital;
    String createTime;
    String name;
    String sex;
    Integer age;
    @ApiModelProperty("科室")
    String department;
    @ApiModelProperty("诊断")
    String diagnose;
    String doctor;
    Double money;
    @ApiModelProperty("药师")
    String pharmacist;
    @ApiModelProperty("备注")
    String remarks;
}
