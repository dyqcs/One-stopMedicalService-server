package com.example.onestopmedicalserviceserver.drugRelated.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("药品订单信息表")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrugOrderInfo {
    @TableId(type = IdType.AUTO)
    Integer id;
    String drugOrderId;
    Integer drugId;
    Integer num;
    String drugName;
}
