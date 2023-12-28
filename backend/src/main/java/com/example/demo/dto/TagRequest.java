package com.example.demo.dto;

public class TagRequest {
    private Integer id;
    private String tagName;

    // getter 和 setter 方法

    public Integer getId() {
        return id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}  