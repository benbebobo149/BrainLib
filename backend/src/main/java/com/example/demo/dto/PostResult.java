package com.example.demo.dto;

import com.example.demo.model.Post;

public class PostResult {
    private Post post;
    private int resultCode;

    // getter 和 setter 方法

    public Post getPost() {
        return post;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}  