package com.example.onestopmedicalserviceserver.controller.chat;

import com.example.onestopmedicalserviceserver.controller.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags="聊天信息（已弃用）")
@RestController
@RequestMapping("chat")
public class chatController {

    /**
     * 用户发送信息，存储起来
     * @param message
     * @return
     */
    @ApiOperation("发送信息")
    @PostMapping("/send")
    public Result send(@RequestBody Message message){
        //1、判断账号是否存在

        //2、存储发送的信息
        DataMessages.messages.put(message.getRecipient(),message);

        return new Result(1,null);
    }

    /**
     * 监听用户有没有信息
     * @param name
     * @return
     */
    @ApiOperation("接收信息")
    @GetMapping("/monitor")
    public Result monitor(String name){
        //1.判断有没有信息
        if (!DataMessages.messages.containsKey(name)){
            return new Result(0,null);
        }

        //2.发送
        Message message = DataMessages.messages.get(name);
        DataMessages.messages.remove(name);

        return new Result(1,message);
    }
}
