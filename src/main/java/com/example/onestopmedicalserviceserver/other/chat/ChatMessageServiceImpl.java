package com.example.onestopmedicalserviceserver.other.chat;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatMessageServiceImpl implements ChatMessageService {

    @Autowired
    ChatMessageDao chatMessageDao;

    @Override
    public int insertOne(ChatMessage chatMessage) {
        return chatMessageDao.insert(chatMessage);
    }

    @Override
    public List<ChatMessage> selectListBySenderIdAndRecipientId(String senderId, String recipientId) {
        LambdaQueryWrapper<ChatMessage> lqw = new LambdaQueryWrapper<>();
        lqw.eq(ChatMessage::getSenderId,senderId).eq(ChatMessage::getRecipientId,recipientId);
        List<ChatMessage> chatMessages = chatMessageDao.selectList(lqw);
        for (ChatMessage chatMessage:chatMessages){
            chatMessageDao.deleteById(chatMessage.getId());
        }
        return chatMessages;
    }
}
