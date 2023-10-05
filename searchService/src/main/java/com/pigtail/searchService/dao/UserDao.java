package com.pigtail.searchService.dao;

import com.pigtail.searchService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
}
