package com.pigtail.forumService.controller;

import com.pigtail.forumService.dto.DiscussionRequest;
import com.pigtail.forumService.dto.DiscussionResponse;
import com.pigtail.forumService.model.Discussion;
import com.pigtail.forumService.model.Forum;
import com.pigtail.forumService.service.DiscussionService;
import com.pigtail.forumService.service.ForumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tomato/forum/discussion")
@RequiredArgsConstructor
public class DiscussionController {
    private final DiscussionService discussionService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // TODO change to dto format
    public DiscussionResponse save(@RequestBody DiscussionRequest discussionRequest){

        return discussionService.save(discussionRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Discussion> getAll(){
        return discussionService.getAll();
    }
}
