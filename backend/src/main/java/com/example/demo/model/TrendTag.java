// TrendTopic.java
package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TrandTopics")
public class TrendTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "topic_id", nullable = false)
    private Integer topic_id;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public Integer getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(Integer topic_id) {
        this.topic_id = topic_id;   
    }
}