package com.example.demo.dto;

import com.example.demo.model.Comment;

import java.util.List;

public class CommentListResult {
    private List<Comment> comments;
    private int resultCode;

    // getter 和 setter 方法

    public List<Comment> getComments() {
        return comments;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}  