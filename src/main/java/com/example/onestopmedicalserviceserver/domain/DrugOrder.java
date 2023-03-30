package com.example.onestopmedicalserviceserver.domain;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("药品订单表")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugOrder {
    String id;
    Double money;
    String createTime;
}
