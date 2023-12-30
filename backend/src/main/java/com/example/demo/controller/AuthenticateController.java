package com.example.demo.controller;

import com.example.demo.dto.AuthenticationResult;
import com.example.demo.dto.TokenRequest;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class AuthenticateController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private UserService userService;

  @Autowired
  private JwtService jwtService;

  @PostMapping("/authenticate")
  public ResponseEntity<?> google(@RequestBody TokenRequest tokenRequest)
    throws Exception {
    String token = tokenRequest.getToken();

    HttpHeaders headers = new HttpHeaders();
    headers.set("Authorization", "Bearer " + token);

    HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response = restTemplate.exchange(
      "https://www.googleapis.com/oauth2/v3/userinfo?access_token=" + token,
      HttpMethod.GET,
      entity,
      String.class
    );

    JSONObject jsonObject = new JSONObject(response.getBody());
    // get email
    String email = jsonObject.getString("email");
    User checkUser = userService.getByEmail(email);

    boolean isRegister = false;
    if (checkUser == null) {
      checkUser = new User();
      checkUser.setEmail(email);
      checkUser.setName(null);
      checkUser.setPermission(2);
      userRepository.save(checkUser);
      isRegister = true;
    } else {
      isRegister = true;
    }
    final String jwt_token = jwtService.generateToken(checkUser);
    AuthenticationResult result = new AuthenticationResult(
      jwt_token,
      isRegister
    );
    return ResponseEntity.ok(result);
  }
}
