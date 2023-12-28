// ActivityService.java
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpServletRequest;

import com.example.demo.model.Activity;
import com.example.demo.model.User;

import com.example.demo.repository.ActivityRepository;

import com.example.demo.service.JwtService;

import com.example.demo.dto.ActivityResult;
import com.example.demo.dto.JwtResult;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private JwtService jwtService;

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public ActivityResult createActivity(Activity activity, HttpServletRequest request) {

        JwtResult jwtResult = jwtService.parseRequest(request);

        ActivityResult result = new ActivityResult();

        User user = jwtResult.getUser();
        activity.setUser(user);

        if (jwtResult == null) {
            result.setResultCode(1);
            return result;
        }
        
        if (!jwtResult.getPassed()) {
            result.setResultCode(1);
            return result;
        }

        result.setActivity(activityRepository.save(activity));
        result.setResultCode(0);

        return result;
    }

    public int deleteActivity(Integer id, HttpServletRequest request) {

        JwtResult jwtResult = jwtService.parseRequest(request);
        
        if (jwtResult == null) {
            return 1;
        }
        
        if (!jwtResult.getPassed()) {
            return 1;
        }
        
        Activity activity = activityRepository.findById(id).orElse(null);
        
        User user = jwtResult.getUser();

        if (user.getPermission() == 0) {
            return 1;
        } else if (activity == null) {
            return 2;
        } else {
            activityRepository.delete(activity);
            return 0;
        }
    }

    public ActivityResult updateActivity(Integer id, Activity activityDetails, HttpServletRequest request) {
        
        JwtResult jwtResult = jwtService.parseRequest(request);
        ActivityResult result = new ActivityResult();
        
        if (jwtResult == null) {
            result.setResultCode(1);
            return result;
        }
        
        if (!jwtResult.getPassed()) {
            result.setResultCode(1);
            return result;
        }
        
        Activity activity = activityRepository.findById(id).orElse(null);

        if (activity != null) {
            if (activity.getId() == activityDetails.getId()) {
                activity.setTitle(activityDetails.getTitle());
                activity.setContent(activityDetails.getContent());
                activity.setLocation(activityDetails.getLocation());
                activity.setDateTime(activityDetails.getDateTime());
                activity.setVisible(activityDetails.getVisible());
                activityRepository.save(activity);
                result.setResultCode(0);
                result.setActivity(activity);
            } else {
                result.setResultCode(1);
            }
        } else {
            result.setResultCode(2);
        }

        return result;
    }

    public Activity getActivityById(Integer id) {
        return activityRepository.findById(id).orElse(null);
    }
}