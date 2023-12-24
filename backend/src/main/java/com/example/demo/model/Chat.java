// ChatMessage.java
package com.example.demo.model;

import com.example.demo.model.User;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "sender", nullable = false, referencedColumnName = "id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver", nullable = false, referencedColumnName = "id")
    private User receiver;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "timestamp", nullable = false)
    private Date timestamp;

    // getters and setters

    public Integer getMessage_id() {
        return id;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}