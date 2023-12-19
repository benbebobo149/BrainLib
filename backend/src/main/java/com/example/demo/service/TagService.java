// TagService.java
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Tag;
import com.example.demo.repository.TagRepository;
import com.example.demo.model.ResourceNotFoundException;

import java.util.List;

@Service
public class TagService {
    @Autowired
    private TagRepository tagRepository;

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Tag addTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public void deleteTag(Integer id) {
        Tag tag = getTag(id);
        tagRepository.delete(tag);
    }

    public Tag updateTag(Integer id, Tag tagDetails) {
        Tag tag = getTag(id);
        tag.setTagName(tagDetails.getTagName());
        return tagRepository.save(tag);
    }

    private Tag getTag(Integer id) {
        return tagRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Tag", "id", id));
    }
}