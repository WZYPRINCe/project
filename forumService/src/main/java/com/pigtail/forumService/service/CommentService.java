package com.pigtail.forumService.service;

import com.pigtail.forumService.dao.CommentDao;
import com.pigtail.forumService.dao.DiscussionDao;
import com.pigtail.forumService.dao.UserDao;
import com.pigtail.forumService.dto.CommentRequest;
import com.pigtail.forumService.dto.CommentResponse;
import com.pigtail.forumService.model.Comment;
import com.pigtail.forumService.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentDao commentDao;
    private final DiscussionDao discussionDao;
    private final UserDao userDao;
    public CommentResponse save(CommentRequest commentRequest) {
        Comment comment = Comment.builder()
                .content(commentRequest.getContent())
                .discussion(discussionDao.findById(commentRequest.getDiscussionId()).get())
                .owner(userDao.getReferenceById(commentRequest.getOwnerId()))
                .createdAt(new Date())
                .build();
        commentDao.save(comment);
        return CommentResponse.builder()
                .content(comment.getContent())
                .createdAt(comment.getCreatedAt())
                .discussionId(comment.getDiscussion().getId())
                .ownerId(comment.getOwner().getId())
                .id(comment.getId())
                .build();
    }

    public List<Comment> getAll() {
        return commentDao.findAll();
    }
}
