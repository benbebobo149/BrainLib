package com.example.demo.dto;

import com.example.demo.model.User;

public class JwtResult {
    private User user;
    private Boolean passed;

    // getter 和 setter 方法

    public User getUser() {
        return user;
    }

    public Boolean getPassed() {
        return passed;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPassed(Boolean passed) {
        this.passed = passed;
    }
}  