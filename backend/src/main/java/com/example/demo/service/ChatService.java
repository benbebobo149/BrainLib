// ChatService.java
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;

import com.example.demo.model.Chat;
import com.example.demo.model.User;

import com.example.demo.repository.ChatRepository;

import com.example.demo.service.UserService;
import com.example.demo.service.JwtService;

import com.example.demo.dto.ChatResult;
import com.example.demo.dto.JwtResult;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ChatService {
    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private UserRepository userService;

    @Autowired
    private JwtService jwtService;

    public List<Chat> getAllChats() {
        return chatRepository.findAll();
    }

    public Chat sendChat(ChatSendResult newChat, HttpServletRequest request) {

        JwtResult jwtResult = jwtService.parseRequest(request);
        ChatResult result = new ChatResult();
        
        if (!(jwtResult != null) && (!jwtResult.getPassed())) {
            result.setResultCode(1);
            return result;
        }

        User sender = userService.findById(newChat.getSender());
        User receiver = userService.findById(newChat.getReceiver());

        

        chat = chatRepository.save(chat);
        result.setResultCode(0);
        result.setChat(chat);

        return result;
    }

    public List<Chat> getConversation(Integer user_id, HttpServletRequest request) {
        User user = userService.findById(user_id);

        if (user == null) {
            return new ArrayList<>();
        }

        List<Chat> sentChats = chatMessageRepository.findBySender(user);
        List<Chat> receivedChats = chatMessageRepository.findByReceiver(user);

        if (sentChats.isEmpty() && receivedChats.isEmpty()) {
            return new ArrayList<>();
        }

        List<User> sentUsers = sentChats.stream()
        .map(Chat::getReceiver)
        .distinct()
        .collect(Collectors.toList());

        List<User> receivedUsers = receivedChats.stream()
            .map(Chat::getSender)
            .distinct()
            .collect(Collectors.toList());

        return Stream.concat(sentUsers.stream(), receivedUsers.stream())
            .distinct()
            .collect(Collectors.toList());
    }

    private Chat getChat(Integer id) {
        return chatRepository.findById(id).orElse(null);
    }
}