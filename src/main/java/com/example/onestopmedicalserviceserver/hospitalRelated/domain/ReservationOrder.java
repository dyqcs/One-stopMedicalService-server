package com.example.onestopmedicalserviceserver.hospitalRelated.domain;

import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@ApiModel("预约表")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationOrder {
    String id;
    String reservationTime;
    Double money;
    @ApiModelProperty("医生id")
    Integer doctorId;
    @TableLogic
    int status;
}
