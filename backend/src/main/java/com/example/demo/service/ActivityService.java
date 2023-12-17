// ActivityService.java
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Activity;
import com.example.demo.repository.ActivityRepository;
import com.example.demo.model.ResourceNotFoundException;

import java.util.List;

@Service
public class ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    public List<Activity> getAllActivities() {
        return activityRepository.findAll();
    }

    public Activity createActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    public void deleteActivity(Integer id) {
        Activity activity = getActivity(id);
        activityRepository.delete(activity);
    }

    public Activity updateActivity(Integer id, Activity activityDetails) {
        Activity activity = getActivity(id);
        activity.setTitle(activityDetails.getTitle());
        activity.setContent(activityDetails.getContent());
        activity.setLocation(activityDetails.getLocation());
        activity.setDateTime(activityDetails.getDateTime());
        activity.setTags(activityDetails.getTags());
        return activityRepository.save(activity);
    }

    public Activity getActivityById(Integer id) {
        return activityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Activity", "id", id));
    }

    private Activity getActivity(Integer id) {
        return activityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Activity", "id", id));
    }
}