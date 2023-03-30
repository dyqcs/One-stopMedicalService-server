package com.example.onestopmedicalserviceserver.controller.chat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel("发送接受信息")
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @ApiModelProperty("发送者")
    private String Sender;

    @ApiModelProperty("接受人")
    private String Recipient;

    @ApiModelProperty("信息")
    private String msg;
}
