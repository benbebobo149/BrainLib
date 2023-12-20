package com.example.demo.dto;

import com.example.demo.entity.Comment;

public class CommentResult {
    private Comment comment;
    private int resultCode;

    // getter 和 setter 方法

    public Comment getComment() {
        return comment;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setComments(Comment comment) {
        this.comment = comment;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}  