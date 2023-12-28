package com.example.demo.dto;

import com.example.demo.model.Post;
import com.example.demo.model.Tag;

import com.example.demo.dto.TagRequest;

import java.util.List;

public class NewPostResult {
    private Integer id;
    private Integer user;
    private String username;
    private String title;
    private String content;
    private String image;
    private Integer thumbUp;
    private Integer comments;
    private Boolean visible;
    private int resultCode;
    private List<TagRequest> tags;

    public NewPostResult() {
        this.thumbUp = 0;
        this.comments = 0;
        this.visible = true;
        this.resultCode = 0;
    }

    // getter 和 setter 方法
    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
    public int getResultCode() {
        return resultCode;
    }
    public Integer getId() {
        return id;
    }

    public Integer getUser() {
        return user;
    }

    public String getUsername() {
        return username;
    }

    public Integer getThumbUp() {
        return thumbUp;
    }

    public Integer getComments() {
        return comments;
    }

    public Boolean getVisible() {
        return visible;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() { return content; }

    public String getImage() { return image; }

    public List<TagRequest> getTags() { return tags; }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setTitle(String title) { this.title = title; }

    public void setContent(String content) { this.content = content; }

    public void setTags(List<TagRequest> tags) { this.tags = tags; }

    public void setImage(String image) { this.image = image; }

    public void setUser(Integer user) {
        this.user = user;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setThumbUp(Integer thumbUp) {
        this.thumbUp = thumbUp;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

}  