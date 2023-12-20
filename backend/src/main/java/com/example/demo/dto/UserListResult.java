package com.example.demo.dto;

import com.example.demo.model.User;

import java.util.List;

public class UserListResult {
    private List<User> users;
    private int resultCode;

    // getter 和 setter 方法

    public List<User> getUsers() {
        return users;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setUser(List<User> users) {
        this.users = users;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}  