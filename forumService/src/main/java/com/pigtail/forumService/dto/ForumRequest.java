package com.pigtail.forumService.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ForumRequest {
    private String name;
    private Long ownerId;
    private String content;
//    private List<String> tags;
}
