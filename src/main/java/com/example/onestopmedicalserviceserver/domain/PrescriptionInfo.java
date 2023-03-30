package com.example.onestopmedicalserviceserver.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("处方信息")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescriptionInfo {
    @TableId(type = IdType.AUTO)
    Integer id;
    String name;
    @ApiModelProperty("规格")
    String specifications;
    @ApiModelProperty("使用规格")
    String usageDosage;
    Integer num;
    String prescriptionId;
}
