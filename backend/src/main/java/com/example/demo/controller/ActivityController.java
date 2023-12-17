// ActivityController.java
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Activity;
import com.example.demo.service.ActivityService;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping("/all")
    public List<Activity> getAllActivities() {
        return activityService.getAllActivities();
    }

    @PostMapping
    public Activity createActivity(@RequestBody Activity activity) {
        return activityService.createActivity(activity);
    }

    @DeleteMapping("/{activity_id}")
    public ResponseEntity<?> deleteActivity(@PathVariable Integer activity_id) {
        activityService.deleteActivity(activity_id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{activity_id}")
    public Activity updateActivity(@PathVariable Integer activity_id, @RequestBody Activity activityDetails) {
        return activityService.updateActivity(activity_id, activityDetails);
    }

    @GetMapping("/{activity_id}")
    public Activity getActivityById(@PathVariable Integer activity_id) {
        return activityService.getActivityById(activity_id);
    }
}