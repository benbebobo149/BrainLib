// com.example.demo.controller.OAuth2Controller.java
package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.model.JwtUtil;
import com.example.demo.model.AuthenticationResponse;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;

@RestController
public class OAuth2Controller {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/authenticate")
    public ResponseEntity<?> googleCallback(OAuth2AuthenticationToken token) {
        try {
            String email = token.getPrincipal().getAttribute("email");
            User user = userService.findByEmail(email);
            boolean isNew = false;
            if (email == null) {
                isNew = true;
                user = new User();
                user.setEmail(token.getPrincipal().getAttribute("email"));
                user.setName(null);
                userService.save(user);
            }

            final String jwt = jwtUtil.generateToken(user);
            return ResponseEntity.ok(new AuthenticationResponse(jwt, isNew));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}