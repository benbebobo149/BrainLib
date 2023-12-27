package com.example.demo.controller;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jakarta.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.service.JwtService;
import com.example.demo.dto.JwtResult;

@RestController
public class FileUploadController  {

    @Autowired
    private JwtService jwtService;

    @Value("${my.custom.imgurToken}")
    private String imgurToken;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/uploadFile")
    public ResponseEntity<?> handleFileUpload(@RequestParam("image") MultipartFile file, HttpServletRequest request) {
        JwtResult jwtResult = jwtService.parseRequest(request);
            
        if (jwtResult == null && !jwtResult.getPassed()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

    HttpClient httpclient = HttpClients.createDefault();
    HttpPost httppost = new HttpPost("https://api.imgur.com/3/image");
    httppost.setHeader("Authorization", "Bearer " + imgurToken);


    try {
      HttpEntity reqEntity = MultipartEntityBuilder.create()
              .addBinaryBody("image", file.getInputStream(), ContentType.create(file.getContentType()), file.getOriginalFilename())
              .build();

      httppost.setEntity(reqEntity);

      HttpResponse response = httpclient.execute(httppost);
      HttpEntity resEntity = response.getEntity();

      if (resEntity != null) {
          String responseString = EntityUtils.toString(resEntity);
          JSONObject jsonObject = new JSONObject(responseString);
          String imageUrl =  jsonObject.getJSONObject("data").getString("link");
          Map<String, Object> fileMap = new HashMap<>();
          fileMap.put("url", imageUrl);
          Map<String, Object> responseBody = new HashMap<>();
          responseBody.put("success", 1);
          responseBody.put("file", fileMap);
          return new ResponseEntity<Map<String, Object>>(responseBody, HttpStatus.OK);
      }
    } catch (IOException e) {
      return new ResponseEntity<Map<String, Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
      return new ResponseEntity<Map<String, Object>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}