package com.example.demo.dto;

import com.example.demo.model.User;

public class JwtResult {
    private User user;
    private Integer user_id;
    private Boolean passed;

    // getter 和 setter 方法

    public User getUser() {
        return user;
    }

    public Integer getUserId() {
        return user_id;
    }

    public Boolean getPassed() {
        return passed;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setPassed(Boolean passed) {
        this.passed = passed;
    }
}  