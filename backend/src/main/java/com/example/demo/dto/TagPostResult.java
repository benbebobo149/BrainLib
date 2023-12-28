package com.example.demo.dto;

import com.example.demo.model.Post;
import com.example.demo.dto.NewPostResult;

import java.util.List;

public class TagPostResult {
    private NewPostResult post;
    private int resultCode;

    // getter 和 setter 方法

    public NewPostResult getPost() {
        return post;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setPost(NewPostResult post) {
        this.post = post;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}  