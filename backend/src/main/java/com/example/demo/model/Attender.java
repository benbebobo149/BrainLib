// BrainUserActivityMapping.java
package com.example.demo.model;

import com.example.demo.model.User;
import com.example.demo.model.Activity;

import jakarta.persistence.*;

@Entity
@Table(name = "Attenders")
public class Attender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "users", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "activity", nullable = false)
    private Activity activity;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}