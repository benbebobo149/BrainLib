package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import javax.servlet.http.HttpServletRequest;

import com.example.demo.model.Tag;

import com.example.demo.service.TagService;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping
    public ResponseEntity<?> getAllTags() {
        try {
            List<Tag> allTags = tagService.getAllTags();
    
            if (allTags != null) {
                return ResponseEntity.ok(allTags);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<?> createTag(@RequestBody Tag tag, HttpServletRequest request) {
        try {
            TagResult result = tagService.createTag(tag, request);
    
            switch (result.getResultCode()) {
                case 0: // 成功
                    return ResponseEntity.ok(result.getTag());
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

    @PutMapping("/{tag_id}")
    public ResponseEntity<?> updateTag(@PathVariable Integer tag_id, @RequestBody Tag tagDetails, HttpServletRequest request) {
        try {
            TagResult result = tagService.updateTag(tag_id, tagDetails, request);
    
            switch (result.getResultCode()) {
                case 0: // 成功
                    return ResponseEntity.ok(result.getTag());
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

    @DeleteMapping("/{tag_id}")
    public ResponseEntity<?> deleteTag(@PathVariable Integer tag_id, HttpServletRequest request) {
        try {
            int result = tagService.deleteTag(tag_id, request);
    
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
}