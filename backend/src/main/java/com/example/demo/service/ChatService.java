// ChatMessageService.java
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.ChatMessage;
import com.example.demo.repository.ChatMessageRepository;
import com.example.demo.model.ResourceNotFoundException;

import java.util.List;

@Service
public class ChatMessageService {
    @Autowired
    private ChatMessageRepository chatMessageRepository;

    public List<ChatMessage> getAllChatMessages() {
        return chatMessageRepository.findAll();
    }

    public ChatMessage createChatMessage(ChatMessage chatMessage) {
        return chatMessageRepository.save(chatMessage);
    }

    public List<ChatMessage> getChatMessagesByUserId(Integer user_id) {
        // Implement the logic to retrieve chat messages by user_id
        return null;
    }

    private ChatMessage getChatMessage(Integer id) {
        return chatMessageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("ChatMessage", "id", id));
    }
}