package com.pigtail.messageService.dao;

import com.pigtail.messageService.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageDao extends JpaRepository<Message,Long> {
}
