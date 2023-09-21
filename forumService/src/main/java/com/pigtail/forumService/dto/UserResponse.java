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
public class UserResponse {
    private Long id;
    private String nickname;
    private String avatar;
//    private Date createdAt;
}

