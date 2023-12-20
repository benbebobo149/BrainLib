// TagService.java
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;

import com.example.demo.model.Tag;

import com.example.demo.service.JwtService;
import com.example.demo.service.UserService;

import com.example.demo.dto.TagResult;

import com.example.demo.repository.TagRepository;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;
    
    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public TagResult createTag(Tag tag, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        String userId = jwtService.extractUserId(token);
        User user = userService.findById(userId);
        TagResult result = new TagResult();

        if (!jwtService.validateToken(token, user)) {
            result.setResultCode(1);
            return result;
        }

        if (user.getPermission() == 0) {
            result.setResultCode(1);
        } else {
            result.setTag(tagRepository.save(tag));
            result.setResultCode(0);
        }

        return result;
    }

    public int deleteTag(Integer id, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        String userId = jwtService.extractUserId(token);
        User user = userService.findById(userId);

        if (!jwtService.validateToken(token, user)) {
            return 1;
        }

        Tag tag = getTag(id);

        if (user.getPermission() == 0) {
            return 1;
        } else if (tag == null) {
            return 2;
        } else {
            tagRepository.delete(tag);
            return 0
        }
    }

    public TagResult updateTag(Integer id, Tag tagDetails, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        String userId = jwtService.extractUserId(token);
        User user = userService.findById(userId);
        TagResult result = new TagResult();
        
        if (!jwtService.validateToken(token, user)) {
            result.setResultCode(1);
            return result;
        }
        
        Tag tag = getTag(id);

        if (user.getPermission() == 0) {
            result.setResultCode(1);
        } else if (tag == null) {
            result.setResultCode(2);
        } else{
            tag.setTagName(tagDetails.getTagName());
            tag.setTagAbbr(tagDetails.getTagAbbr());

            result.setTag(tagRepository.save(tag));
            result.setResultCode(0);
        }

        return result;
    }
}