package com.example.demo.dto;

import com.example.demo.model.Post;

import java.util.List;

public class PostListResult {
    private List<Post> posts;
    private int resultCode;

    // getter 和 setter 方法

    public List<Post> getPosts() {
        return posts;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}  