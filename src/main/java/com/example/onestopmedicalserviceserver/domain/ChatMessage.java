package com.example.onestopmedicalserviceserver.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@ApiModel("消息发送")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatMessage {
    @TableId(type = IdType.AUTO)
    Integer id;
    @ApiModelProperty("发送者id")
    String senderId;
    @ApiModelProperty("接收者id")
    String recipientId;
    @ApiModelProperty("发送信息")
    String message;
    //逻辑删除，实则修改
    @TableLogic
    int status;
}
