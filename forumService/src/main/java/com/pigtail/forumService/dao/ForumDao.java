package com.pigtail.forumService.dao;

import com.pigtail.forumService.model.Forum;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ForumDao extends JpaRepository<Forum,Long> {
}
