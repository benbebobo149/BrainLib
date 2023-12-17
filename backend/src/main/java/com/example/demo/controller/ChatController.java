// ChatMessageController.java
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.ChatMessage;
import com.example.demo.service.ChatMessageService;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatMessageController {
    @Autowired
    private ChatMessageService chatMessageService;

    @GetMapping("/user-list")
    public List<ChatMessage> getAllChatMessages() {
        return chatMessageService.getAllChatMessages();
    }

    @PostMapping
    public ChatMessage createChatMessage(@RequestBody ChatMessage chatMessage) {
        return chatMessageService.createChatMessage(chatMessage);
    }

    @GetMapping("/{user_id}")
    public List<ChatMessage> getChatMessagesByUserId(@PathVariable Integer user_id) {
        return chatMessageService.getChatMessagesByUserId(user_id);
    }
}