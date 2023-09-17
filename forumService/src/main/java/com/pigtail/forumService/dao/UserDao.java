package com.pigtail.forumService.dao;

import com.pigtail.forumService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
}
