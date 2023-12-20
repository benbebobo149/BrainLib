package com.example.demo.dto;

import com.example.demo.model.Chat;

public class ChatResult {
    private Chat chat;
    private int resultCode;

    // getter 和 setter 方法

    public Chat getChat() {
        return chat;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}  