package com.pigtail.forumService.service;

import com.pigtail.forumService.dao.UserDao;
import com.pigtail.forumService.dto.UserRequest;
import com.pigtail.forumService.dto.UserResponse;
import com.pigtail.forumService.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserDao userDao;
    public UserResponse save(UserRequest userRequest) {
        User user = User
                .builder()
                .avatar(userRequest.getAvatar())
                .nickname(userRequest.getNickname())
//                .createdAt(new Date())
                .build();
        userDao.save(user);

        return UserResponse.builder()
                .id(user.getId())
                .nickname(user.getNickname())
//                .createdAt(user.getCreatedAt())
                .avatar(user.getAvatar())
                .build();
    }

    public List<User> getAll() {
        return userDao.findAll();
    }
}
