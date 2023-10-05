package com.pigtail.messageService.dao;

import com.pigtail.messageService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {
}
