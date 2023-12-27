// com.example.demo.controller.OAuth2Controller.java
package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.annotation.AuthenticationPrincipal;
// import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
// import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
// import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
// import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.User;

import com.example.demo.service.JwtService;
import com.example.demo.service.UserService;

import com.example.demo.repository.UserRepository;

import com.example.demo.dto.AuthenticationResult;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class AuthenticateController {

    // private final OAuth2AuthorizedClientService authorizedClientService;

    // public AuthenticateController(OAuth2AuthorizedClientService authorizedClientService) {
    //     this.authorizedClientService = authorizedClientService;
    // }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    // @GetMapping("/authenticate")
    // public ResponseEntity<?> googleCallback(@AuthenticationPrincipal OAuth2User principal, 
    // OAuth2AuthenticationToken authentication) {
    //     try {
    //         OAuth2AuthorizedClient authorizedClient = this.authorizedClientService.loadAuthorizedClient(
    //             authentication.getAuthorizedClientRegistrationId(), authentication.getName());

    //         String accessToken = authorizedClient.getAccessToken().getTokenValue();

    //         String email = principal.getAttribute("email");

    //         if (email == null) {
    //             return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    //         }

    //         User user = userService.getByEmail(email);
    //         boolean isRegister = false;
    //         if (user == null) {
    //             user = new User();
    //             user.setEmail(email);
    //             user.setName(principal.getAttribute("name"));
    //             user.setPermission(0);
    //             userRepository.save(user);
    //             isRegister = true;
    //         } else {
    //             isRegister = true;
    //         }
            
    //         final String token = jwtService.generateToken(user);
    //         AuthenticationResult result = new AuthenticationResult(token, isRegister);
    //         return ResponseEntity.ok(result);

    //     } catch (Exception e) {
    //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    //     }
    // }
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody User user) {
        try {
            if (user == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }

            String email = user.getEmail();
            User checkUser = userService.getByEmail(email);
            User newUser = new User();

            boolean isRegister = false;
            if (checkUser == null) {
                newUser = new User();
                newUser.setEmail(email);
                newUser.setName(user.getName());
                newUser.setPermission(user.getPermission());
                userRepository.save(newUser);
                isRegister = true;
            } else {
                newUser = checkUser;
                isRegister = true;
            }
            
            final String token = jwtService.generateToken(newUser);
            AuthenticationResult result = new AuthenticationResult(token, isRegister);
            return ResponseEntity.ok(result);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}