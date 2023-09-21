package com.pigtail.forumService.controller;

import com.pigtail.forumService.dto.ForumRequest;
import com.pigtail.forumService.dto.ForumResponse;
import com.pigtail.forumService.model.Forum;
import com.pigtail.forumService.service.ForumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tomato/forum/forum")
@RequiredArgsConstructor
public class ForumController {
    private final ForumService forumService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ForumResponse save(@RequestBody ForumRequest forumRequest){
        return forumService.save(forumRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Forum> getAll(){
        return forumService.getAll();
    }


}
