package com.pigtail.forumService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiscussionResponse {
    private Date createdAt;
    private Long id;
    private String content;
    private String title;
    private Long forumId;
    private Long ownerId;
}
