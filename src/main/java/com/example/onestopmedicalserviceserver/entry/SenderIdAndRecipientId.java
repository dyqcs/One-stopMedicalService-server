package com.example.onestopmedicalserviceserver.entry;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@ApiModel("发送者id+接收者id")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SenderIdAndRecipientId {
    String senderId;
    String recipientId;
}
