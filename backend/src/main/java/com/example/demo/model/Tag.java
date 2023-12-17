// Tag.java
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tag_id;

    @Column(name = "tag_name", nullable = false)
    private String tag_name;

    // getters and setters

    public Integer getTag_id() {
        return tag_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }
}