// TrendTopic.java
package com.example.demo.model;

import com.example.demo.model.Tag;

import jakarta.persistence.*;

@Entity
@Table(name = "TrandTag")
public class TrendTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "tag", nullable = false, referencedColumnName = "id")
    private Tag tag;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;   
    }
}