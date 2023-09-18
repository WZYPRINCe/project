package com.pigtail.forumService.service;

import com.pigtail.forumService.dao.ForumDao;
import com.pigtail.forumService.dao.TagDao;
import com.pigtail.forumService.dao.UserDao;
import com.pigtail.forumService.dto.ForumRequest;
import com.pigtail.forumService.dto.ForumResponse;
import com.pigtail.forumService.model.Forum;
import com.pigtail.forumService.model.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ForumService {
    private final ForumDao forumDao;
    private final UserDao userDao;
    private final TagDao tagDao;
    @Transactional
    @Modifying
    public ForumResponse save(ForumRequest forumRequest) {
        // Map all strings to tags
        List<Tag> tags = forumRequest.getTags().stream().map(this::mapStringTotag).toList();
        // Map all forumRequest to forum
        Forum forum = Forum.builder()
                .name(forumRequest.getName())
                .owner(userDao.findById(forumRequest.getOwnerId()).get())
                .createdAt(new Date())
                .tags(tags)
                .build();
        forumDao.save(forum);

        return ForumResponse.builder()
                .ownerId(forum.getOwner().getId())
                .name(forum.getName())
                .id(forum.getId())
                .createdAt(forum.getCreatedAt())
                .tags(forum.getTags().stream().map(Tag::getName).toList())
                .build();
    }

    private Tag mapStringTotag(String string) {
        Optional<Tag> optionalTag = tagDao.findById(string);
        Tag tag = new Tag(string);
        if(optionalTag.isEmpty()){
            tagDao.save(tag);
        }
        return tag;
    }


    public List<Forum> getAll() {
        return forumDao.findAll();
    }
}
