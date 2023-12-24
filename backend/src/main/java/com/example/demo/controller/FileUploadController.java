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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;


@RestController
public class FileUploadController  {
    
    @Value("${my.custom.imgurToken}")
    private String imgurToken;

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/uploadFile")
    public ResponseEntity<Map<String, String>> handleFileUpload(@RequestParam("file") MultipartFile file) {
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
          Map<String, String> responseBody = new HashMap<>();
          responseBody.put("url", imageUrl);
          return new ResponseEntity<Map<String, String>>(responseBody, HttpStatus.OK);
      }
    } catch (IOException e) {
      return new ResponseEntity<Map<String, String>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
      return new ResponseEntity<Map<String, String>>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}