package com.example.demo.controller;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import java.io.IOException;

@RestController
public class FileUploadController  {
    
    @Value("${my.custom.imgurToken}")
    private String imgurToken;

    @GetMapping("/uploadFile")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }
    public String uploadFile() {
        // just return hello world for now
        return "Hello World";

        // HttpClient httpclient = HttpClients.createDefault();
        // HttpPost httppost = new HttpPost("https://api.imgur.com/3/image");
        // httppost.setHeader("Authorization", "Bearer " + imgurToken);

        // HttpEntity reqEntity = MultipartEntityBuilder.create()
        //         .addBinaryBody("image", file.getInputStream(), ContentType.create(file.getContentType()), file.getOriginalFilename())
        //         .build();

        // httppost.setEntity(reqEntity);

        // HttpResponse response = httpclient.execute(httppost);
        // HttpEntity resEntity = response.getEntity();

        // if (resEntity != null) {
        //     String responseString = EntityUtils.toString(resEntity);
        //     // Parse the responseString to get the image link
        //     // Return the image link
        //     return responseString;
        // }

        // return null;
    }
}