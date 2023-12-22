package com.example.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.http.ResponseEntity;

@RestController
public class Oauth2Controller {

    private final OAuth2AuthorizedClientService authorizedClientService;

    public Oauth2Controller(OAuth2AuthorizedClientService authorizedClientService) {
        this.authorizedClientService = authorizedClientService;
    }

    @GetMapping("/")
    public ResponseEntity<String> user(@AuthenticationPrincipal OAuth2User principal, 
                                OAuth2AuthenticationToken authentication) {
        // 從 OAuth2AuthorizedClientService 獲取 access token
        OAuth2AuthorizedClient authorizedClient = this.authorizedClientService.loadAuthorizedClient(
            authentication.getAuthorizedClientRegistrationId(), authentication.getName());
        String accessToken = authorizedClient.getAccessToken().getTokenValue();
    
        // 使用 accessToken 創建 JWT
        String jwt = accessToken;

        // 將 JWT 返回給前端
        return ResponseEntity.ok(jwt);
        // return new RedirectView("/uploadFile");
    }
}