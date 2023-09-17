package com.pigtail.forumService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiscussionRequest {
    private Long ownerId;
    private String title;
    private String content;
    private Long forumId;
}
