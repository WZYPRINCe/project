package com.pigtail.forumService.dao;

import com.pigtail.forumService.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDao extends JpaRepository<Comment,Long> {
}
