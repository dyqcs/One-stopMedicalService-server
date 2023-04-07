package com.example.onestopmedicalserviceserver.other.chat;

import com.example.onestopmedicalserviceserver.config.standard.Code;
import com.example.onestopmedicalserviceserver.config.standard.Result;
import com.example.onestopmedicalserviceserver.other.chat.entry.SenderIdAndRecipientId;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags="聊天")
@RestController
@RequestMapping("chatMessage")
public class ChatMessageController {

    @Autowired
    ChatMessageService chatMessageService;

    @ApiOperation("发送信息")
    @PostMapping("sendMessage")
    public Result sendMessage(@RequestBody ChatMessage chatMessage){
        return new Result(Code.GET_OK,chatMessageService.insertOne(chatMessage));
    }

    @ApiOperation("监听信息")
    @PostMapping("monitorMessage")
    public Result monitorMessage(@RequestBody SenderIdAndRecipientId sr){
        return new Result(Code.GET_OK,chatMessageService.selectListBySenderIdAndRecipientId(sr.getSenderId(), sr.getRecipientId()));
    }
}
