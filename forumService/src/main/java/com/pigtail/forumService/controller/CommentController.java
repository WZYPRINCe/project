package com.pigtail.forumService.controller;

import com.pigtail.forumService.dto.CommentRequest;
import com.pigtail.forumService.dto.CommentResponse;
import com.pigtail.forumService.model.Comment;
import com.pigtail.forumService.model.Forum;
import com.pigtail.forumService.service.CommentService;
import com.pigtail.forumService.service.ForumService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tomato/forum/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // TODO change to dto format
    public CommentResponse save(@RequestBody CommentRequest commentRequest){
        return commentService.save(commentRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getAll(){
        return commentService.getAll();
    }
}
