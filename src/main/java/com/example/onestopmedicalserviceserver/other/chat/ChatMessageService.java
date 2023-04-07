package com.example.onestopmedicalserviceserver.other.chat;

import java.util.List;

public interface ChatMessageService {
    int insertOne(ChatMessage chatMessage);
    List<ChatMessage> selectListBySenderIdAndRecipientId(String senderId, String recipientId);
}
