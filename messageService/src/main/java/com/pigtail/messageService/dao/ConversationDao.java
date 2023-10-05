package com.pigtail.messageService.dao;

import com.pigtail.messageService.model.Conversation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversationDao extends JpaRepository<Conversation,Long> {
}
