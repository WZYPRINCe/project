package com.pigtail.messageService.service;

import com.pigtail.messageService.dao.ConversationDao;
import com.pigtail.messageService.dto.ConversationRequest;
import com.pigtail.messageService.dto.ConversationRespond;
import com.pigtail.messageService.model.Conversation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConversationService {
    private final ConversationDao conversationDao;

    public ConversationRespond create(ConversationRequest conversationRequest){
        return null;
    }
}
