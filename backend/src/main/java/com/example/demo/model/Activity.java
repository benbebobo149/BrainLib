// Activity.java
package com.example.demo.model;

import com.example.demo.model.User;
import com.example.demo.model.Attender;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.util.Date;
import java.util.List;
import java.util.Set;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Table(name = "Activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonIdentityReference(alwaysAsId = true)
    @ManyToOne
    @JoinColumn(name = "users", nullable = false, referencedColumnName = "id")
    private User user;

    @Column(name = "title", nullable = false)
    private String title;
    
    @Column(name = "content", nullable = false)
    private String content;
    
    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "visible", columnDefinition = "boolean default false")
    private Boolean visible;
    
    @Column(name = "dateTime", nullable = true)
    private Date dateTime;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getLocation() {
        return location;
    }

    public Boolean getVisible() {
        return visible;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
}