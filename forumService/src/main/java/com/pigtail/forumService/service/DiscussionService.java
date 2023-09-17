package com.pigtail.forumService.service;

import com.pigtail.forumService.dao.DiscussionDao;
import com.pigtail.forumService.dao.ForumDao;
import com.pigtail.forumService.dao.UserDao;
import com.pigtail.forumService.dto.DiscussionRequest;
import com.pigtail.forumService.dto.DiscussionResponse;
import com.pigtail.forumService.model.Discussion;
import com.pigtail.forumService.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DiscussionService {
    private final DiscussionDao discussionDao;
    private final ForumDao forumDao;
    private final UserDao userDao;
    public DiscussionResponse save(DiscussionRequest discussionRequest) {
        Discussion discussion = Discussion.builder()
                            .forum(forumDao.findById(discussionRequest.getForumId()).get())
                            .content(discussionRequest.getContent())
                            .title(discussionRequest.getTitle())
                            .owner(userDao.findById(discussionRequest.getOwnerId()).get())
                            .createdAt(new Date())
                            .build();
        discussionDao.save(discussion);

        return DiscussionResponse.builder()
                .id(discussion.getId())
                .title(discussion.getTitle())
                .createdAt(discussion.getCreatedAt())
                .ownerId(discussion.getOwner().getId())
                .forumId(discussion.getForum().getId())
                .content(discussion.getContent())
                .build();
    }

    public List<Discussion> getAll() {
        return discussionDao.findAll();
    }
}
