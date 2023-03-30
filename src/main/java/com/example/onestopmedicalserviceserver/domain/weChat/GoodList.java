package com.example.onestopmedicalserviceserver.domain.weChat;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel("微信 GoodList")
@AllArgsConstructor
@NoArgsConstructor
public class GoodList {
    @ApiModelProperty("商品ID")
    private int goodsId;

    private String name;

    private String goodsName;

    private double goodsPrice;

    private String goodsSmallLogo;

    private String goodsIntroduce;
}
