package com.pigtail.forumService.service;

import com.pigtail.forumService.dao.ForumDao;
import com.pigtail.forumService.dao.UserDao;
import com.pigtail.forumService.dto.ForumRequest;
import com.pigtail.forumService.dto.ForumResponse;
import com.pigtail.forumService.model.Forum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ForumService {
    private final ForumDao forumDao;
    private final UserDao userDao;

    public ForumResponse save(ForumRequest forumRequest){
        Forum forum = Forum.builder()
                .content(forumRequest.getContent())
                .createdAt(new Date())
                .name(forumRequest.getName())
                .owner(userDao.getReferenceById(forumRequest.getOwnerId()))
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
                .build();
    }

    public List<Forum> getAll(){
        return forumDao.findAll();
    }
}
