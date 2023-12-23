package com.example.demo.dto;

public class AuthenticationResult {
    private String token;
    private boolean register;

    public AuthenticationResult(String token, boolean register) {
        this.token = token;
        this.register = register;
    }

    // getters and setters
    public String getToken() {
        return token;
    }

    public boolean getRegister() {
        return register;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setRegister(boolean register) {
        this.register = register;
    }
}