package com.pigtail.forumService.controller;

import com.pigtail.forumService.dto.UserRequest;
import com.pigtail.forumService.dto.UserResponse;
import com.pigtail.forumService.model.User;
import com.pigtail.forumService.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tomato/forum/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    // TODO change to dto format
    public UserResponse save(@RequestBody UserRequest userRequest){
        return userService.save(userRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll(){
        return userService.getAll();
    }

}
