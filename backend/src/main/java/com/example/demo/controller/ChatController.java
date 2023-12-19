// ChatMessageController.java
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Chat;
import com.example.demo.service.ChatService;
import com.example.demo.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @GetMapping("/user-list")
    public List<ChatMessage> getConversation() {
        return chatService.getConversation();
    }

    @PostMapping
    public ChatMessage createChatMessage(@RequestBody ChatMessage chatMessage) {
        return chatService.createChatMessage(chatMessage);
    }

    @GetMapping("/{user_id}")
    public List<ChatMessage> getChatMessagesByUserId(@PathVariable Integer user_id) {
        return chatService.getChatMessagesByUserId(user_id);
    }
}