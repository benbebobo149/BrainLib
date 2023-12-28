// TagService.java
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpServletRequest;

import com.example.demo.model.Tag;
import com.example.demo.model.User;

import com.example.demo.service.JwtService;

import com.example.demo.dto.TagResult;
import com.example.demo.dto.JwtResult;

import com.example.demo.repository.TagRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;
    
    @Autowired
    private JwtService jwtService;

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public TagResult createTag(Tag tag, HttpServletRequest request) {

        JwtResult jwtResult = jwtService.parseRequest(request);
        TagResult result = new TagResult();

        if (jwtResult == null) {
            result.setResultCode(1);
            return result;
        }
        
        if (!jwtResult.getPassed()) {
            result.setResultCode(1);
            return result;
        }

        User user = jwtResult.getUser();
        if (user.getPermission() == 0) {
            result.setResultCode(1);
        }

        Tag OptionalTag = tagRepository.findByTagName(tag.getTagName());

        if (OptionalTag != null) {
            result.setResultCode(2);
            return result;
        }
        result.setTag(tagRepository.save(tag));
        result.setResultCode(0);

        return result;
    }

    public int deleteTag(Integer id, HttpServletRequest request) {

        JwtResult jwtResult = jwtService.parseRequest(request);

        if (jwtResult == null) {
            return 1;
        }
        
        if (!jwtResult.getPassed()) {
            return 1;
        }
        
        User user = jwtResult.getUser();
        Tag tag = null;
        Optional<Tag> OptionalTag = tagRepository.findById(id);

        if (OptionalTag.isPresent()) {
            tag = OptionalTag.get();
        }

        if (user.getPermission() == 0) {
            return 1;
        } else if (tag == null) {
            return 2;
        } else {
            tagRepository.delete(tag);
            return 0;
        }
    }

    public TagResult updateTag(Integer id, Tag tagDetails, HttpServletRequest request) {

        JwtResult jwtResult = jwtService.parseRequest(request);
        TagResult result = new TagResult();

        if (jwtResult == null) {
            result.setResultCode(1);
            return result;
        }
        
        if (!jwtResult.getPassed()) {
            result.setResultCode(1);
            return result;
        }

        User user = jwtResult.getUser();
        Tag tag = null;

        Optional<Tag> OptionalTag = tagRepository.findById(id);

        if (OptionalTag.isPresent()) {
            tag = OptionalTag.get();
        }

        Tag OptionalTag2 = tagRepository.findByTagName(tagDetails.getTagName());

        if (OptionalTag2 != null) {
            if (OptionalTag2.getId() != id) {
                result.setResultCode(3);
                return result;
            }
        }

        if (user.getPermission() == 0) {
            result.setResultCode(1);
        } else if (tag == null) {
            result.setResultCode(2);
        } else{
            tag.setTagName(tagDetails.getTagName());

            result.setTag(tagRepository.save(tag));
            result.setResultCode(0);
        }

        return result;
    }
}