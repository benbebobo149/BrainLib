package com.example.demo.dto;

import com.example.demo.model.Tag;

public class TagResult {
    private Tag tag;
    private int resultCode;

    // getter 和 setter 方法

    public Tag getTag() {
        return tag;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}  