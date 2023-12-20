// ChatService.java
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Chat;
import com.example.demo.repository.ChatRepository;
import com.example.demo.model.ResourceNotFoundException;

import java.util.List;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;

    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }

    public Chat createChat(Chat chat) {
        return chatRepository.save(chat);
    }

    public List<Chat> getChatsByUserId(Integer user_id) {
        // Implement the logic to retrieve chat messages by user_id
        return null;
    }

    private Chat getChat(Integer id) {
        return chatRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Chat", "id", id));
    }
}