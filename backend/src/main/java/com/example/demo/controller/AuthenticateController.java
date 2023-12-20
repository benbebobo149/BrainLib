// com.example.demo.controller.OAuth2Controller.java
package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

import com.example.demo.model.User;

import com.example.demo.util.JwtService;

import com.example.demo.service.UserService;

import com.example.demo.dto.AuthenticationResult;

@RestController
public class AuthenticateController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/authenticate")
    public ResponseEntity<?> googleCallback(OAuth2AuthenticationToken token) {
        try {
            String email = token.getPrincipal().getAttribute("email");

            if (email == null) {
                throw new AuthenticationException();
            }

            User user = userService.findByEmail(email);
            boolean isRegister = false;
            if (user == null) {
                user = new User();
                user.setEmail(email);
                user.setName(null);
                userService.save(user);
                isRegister = true;
            } else {
                isRegister = true;
            }
            
            final String token = jwtService.generateToken(user);
            AuthenticationResult result = new AuthenticationResult(token, isRegister);
            return ResponseEntity.ok(result);

        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}