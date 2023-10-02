package com.pigtail.forumService.dao;

import com.pigtail.forumService.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagDao extends JpaRepository<Tag,String> {
}
