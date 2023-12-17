// TrendTopic.java
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TrandTag")
public class TrendTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tag_id", nullable = false)
    private Integer tag_id;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public Integer getTopic_id() {
        return tag_id;
    }

    public void setTopic_id(Integer tag_id) {
        this.tag_id = tag_id;   
    }
}