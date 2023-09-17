package com.pigtail.forumService.dao;

import com.pigtail.forumService.model.Discussion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiscussionDao extends JpaRepository<Discussion,Long> {
}
