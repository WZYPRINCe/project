package com.pigtail.forumService.service;

import com.pigtail.forumService.dao.ForumDao;
import com.pigtail.forumService.dao.UserDao;
import com.pigtail.forumService.dto.ForumRequest;
import com.pigtail.forumService.dto.ForumResponse;
import com.pigtail.forumService.model.Forum;
import com.pigtail.forumService.model.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ForumService {
    private final ForumDao forumDao;
    private final UserDao userDao;
    private final TagService tagService;

    public ForumResponse save(ForumRequest forumRequest){
        Forum forum = Forum.builder()
                .content(forumRequest.getContent())
                .createdAt(new Date())
                .name(forumRequest.getName())
                .owner(userDao.getReferenceById(forumRequest.getOwnerId()))
                .tags(tagService.save(forumRequest.getTags()))
                .build();
        forumDao.save(forum);

//        forum.setContent("this is a changed content");
//        forumDao.save(forum);

        return ForumResponse.builder()
                .content(forum.getContent())
                .id(forum.getId())
                .ownerId(forum.getOwner().getId())
                .createdAt(forum.getCreatedAt())
                .name(forum.getName())
                .tags(forum.getTags().stream().map(Tag::getName).toList())
                .build();
    }

    public List<Forum> getAll(){
        return forumDao.findAll();
    }
}
