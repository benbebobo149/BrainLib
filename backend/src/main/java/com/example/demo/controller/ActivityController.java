// ActivityController.java
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import jakarta.servlet.http.HttpServletRequest;

import com.example.demo.model.Activity;

import com.example.demo.service.ActivityService;

import com.example.demo.dto.ActivityResult;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/all")
    public ResponseEntity<?> getAllActivities() {
        try {
            List<Activity> allActivities = activityService.getAllActivities();
    
            if (allActivities.size() > 0) {
                return ResponseEntity.ok(allActivities);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping
    public ResponseEntity<?> createActivity(@RequestBody Activity activity, HttpServletRequest request) {
        try {
            ActivityResult result = activityService.createActivity(activity, request);
    
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
            System.out.println(e);
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping("/{activity_id}")
    public ResponseEntity<?> deleteActivity(@PathVariable Integer activity_id, HttpServletRequest request) {
        try {
            int result = activityService.deleteActivity(activity_id, request);
    
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

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping("/{activity_id}")
    public ResponseEntity<?> updateActivity(@PathVariable Integer activity_id, @RequestBody Activity activityDetails, HttpServletRequest request) {
        try {
            ActivityResult result = activityService.updateActivity(activity_id, activityDetails, request);
    
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

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/{activity_id}")
    public ResponseEntity<?> getActivityById(@PathVariable Integer activity_id) {
        try {
            Activity activity = activityService.getActivityById(activity_id);
    
            if (activity != null) {
                return ResponseEntity.ok(activity);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}