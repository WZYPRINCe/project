package com.pigtail.forumService.dao;

import com.pigtail.forumService.model.Forum;
import com.pigtail.forumService.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagDao extends JpaRepository<Tag,Long> {
    List<Tag> findByForum(Forum forum);
}
