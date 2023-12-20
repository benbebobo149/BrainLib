// ChatMessageController.java
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Chat;

import com.example.demo.service.ChatService;
import com.example.demo.service.UserService;

import com.example.demo.dto.ChatResult;

import java.util.Set;

@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @Autowired
    private UserService userService;


    @GetMapping("/user-list")
    public ResponseEntity<?> getConversation() {
        try {
            Set<Chat> conversation = userService.getConversation();
    
            if (conversation != null) {
                return ResponseEntity.ok(conversation);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createChat(@RequestBody Chat chat) {
        try {
            ChatResult result = chatService.createChat(chat);
    
            switch (result.getResultCode()) {
                case 0: // 成功
                    return ResponseEntity.ok().build();
                case 1: // 沒有權限
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                default: // 其他錯誤
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            // 處理其他可能的錯誤
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<?> getChatByUserId(@PathVariable Integer user_id) {
        try {
            Chat chat = chatService.getChatByUserId(user_id);
    
            if (chat != null) {
                return ResponseEntity.ok(chat);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}