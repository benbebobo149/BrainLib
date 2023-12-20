package com.example.demo.dto;

import com.example.demo.model.User;

public class UserResult {
    private User user;
    private int resultCode;

    // getter 和 setter 方法

    public User getUser() {
        return user;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}  