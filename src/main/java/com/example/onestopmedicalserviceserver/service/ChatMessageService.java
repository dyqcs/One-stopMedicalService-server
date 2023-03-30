package com.example.onestopmedicalserviceserver.service;

import com.example.onestopmedicalserviceserver.domain.ChatMessage;

import java.util.List;

public interface ChatMessageService {
    int insertOne(ChatMessage chatMessage);
    List<ChatMessage> selectListBySenderIdAndRecipientId(String senderId, String recipientId);
}
