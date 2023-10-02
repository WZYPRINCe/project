package com.pigtail.forumService.controller;

import com.pigtail.forumService.dao.TagDao;
import com.pigtail.forumService.dto.TagResponse;
import com.pigtail.forumService.model.Tag;
import com.pigtail.forumService.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/tomato/forum/tag")
@RequiredArgsConstructor
public class TagController {
    private final TagService tagService;
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TagResponse> getALl(){
        return tagService.getAll();
    }
}
