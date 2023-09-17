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

import java.util.Date;
import java.util.List;
@Service
@RequiredArgsConstructor

public class ForumService {
    private final ForumDao forumDao;
    private final UserDao userDao;
    private final TagDao tagDao;
    @Transactional
    @Modifying
    public ForumResponse save(ForumRequest forumRequest) {
//        System.out.println(tags);
        Forum forum = Forum.builder()
                .name(forumRequest.getName())
                .owner(userDao.findById(forumRequest.getOwnerId()).get())
                .createdAt(new Date())
                .build();
//        System.out.println(forumRequest);
        forumDao.save(forum);
        List<Tag> tags = forumRequest.getTags()
                .stream()
                .map(tag->mapToTags(tag,forum))
                .toList();
//        forum.setTags(tags);
        Long currentId = forum.getId();
        Forum forum1 = forumDao.findById(currentId).get();
        forum1.setTags(tags);
        System.out.println(forum1);
        forumDao.save(forum1);
//        System.out.println(forum);
        return ForumResponse.builder()
                .ownerId(forum.getOwner().getId())
                .name(forum.getName())
                .id(forum.getId())
                .createdAt(forum.getCreatedAt())
                .tags(tagDao.findByForum(forum).stream().map(this::mapToString).toList())
                .build();
    }

    private String mapToString(Tag tag) {
        return tag.getName();
    }

    private Tag mapToTags(String string,Forum forum) {
        Tag tag = Tag.builder()
                .name(string)
                .forum(forum)
                .build();
        tagDao.save(tag);
        return tag;

    }

    public List<Forum> getAll() {
        return forumDao.findAll();
    }
}
