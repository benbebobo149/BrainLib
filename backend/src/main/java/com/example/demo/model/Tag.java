// Tag.java
package com.example.demo.model;

import com.example.demo.model.TrendTag;
import com.example.demo.model.Post;
import com.example.demo.model.PostTag;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import java.util.List;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityReference(alwaysAsId = false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "Tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIdentityReference(alwaysAsId = false)
    @Column(name = "tagName", nullable = false)
    private String tagName;
    
    @JsonIdentityReference(alwaysAsId = false)
    @OneToOne(mappedBy = "tag", cascade = CascadeType.ALL)
    private TrendTag trendTag;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}