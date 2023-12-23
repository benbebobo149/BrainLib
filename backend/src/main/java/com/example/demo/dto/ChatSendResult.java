package com.example.demo.dto;

public class ChatSendResult {
    private Integer receiverId;
    private String content;
    private int resultCode;

    // getter 和 setter 方法

    public Integer getReceiverId() {
        return receiverId;
    }

    public String getContent() {
        return content;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}  