// BrainUserActivityMapping.java
package com.example.demo.model;

import com.example.demo.model.BrainUser;
import com.example.demo.model.Activity;

import jakarta.persistence.*;

@Entity
@Table(name = "UserActivityMapping")
public class UserActivityMapping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "brainUser", nullable = false)
    private BrainUser brainUser;

    @ManyToOne
    @JoinColumn(name = "activity", nullable = false)
    private Activity activity;

    // getters and setters

    public Integer getId() {
        return id;
    }

    public BrainUser getBrainUser() {
        return brainUser;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setBrainUser(BrainUser brainUser) {
        this.brainUser = brainUser;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}