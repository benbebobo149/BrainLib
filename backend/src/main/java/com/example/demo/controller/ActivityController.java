// ActivityController.java
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import com.example.demo.model.Activity;

import com.example.demo.service.ActivityService;

import com.example.demo.dto.ActivityResult;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllActivities() {
        try {
            List<Activity> allActivities = activityService.getAllActivities();
    
            if (allActivities != null) {
                return ResponseEntity.ok(allActivities);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createActivity(@RequestBody Activity activity) {
        try {
            ActivityResult result = activityService.createActivity(activity);
    
            switch (result.getResultCode()) {
                case 0: // 成功
                    return ResponseEntity.ok(result.getActivity());
                case 1: // 沒有權限
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                default: // 其他錯誤
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            // 處理其他可能的錯誤
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{activity_id}")
    public ResponseEntity<?> deleteActivity(@PathVariable Integer activity_id) {
        try {
            int result = activityService.deleteActivity(activity_id);
    
            switch (result) {
                case 0: // 成功
                    return ResponseEntity.ok().build();
                case 1: // 沒有權限
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                case 2: // 找不到
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                default: // 其他錯誤
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            // 處理其他可能的錯誤
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{activity_id}")
    public ResponseEntity<?> updateActivity(@PathVariable Integer activity_id, @RequestBody Activity activityDetails) {
        try {
            ActivityResult result = activityService.updateActivity(activity_id, activityDetails);
    
            switch (result.getResultCode()) {
                case 0: // 成功
                    return ResponseEntity.ok(result.getActivity());
                case 1: // 沒有權限
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                case 2: // 找不到
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                default: // 其他錯誤
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        } catch (Exception e) {
            // 處理其他可能的錯誤
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{activity_id}")
    public ResponseEntity<?> getActivityById(@PathVariable Integer activity_id) {
        try {
            List<Activity> allActivities = activityService.getActivityById(activity_id);
    
            if (allActivities != null) {
                return ResponseEntity.ok(allActivities);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}