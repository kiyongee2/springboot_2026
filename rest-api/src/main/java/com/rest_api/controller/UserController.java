package com.rest_api.controller;

import com.rest_api.entity.User;
import com.rest_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService service;

    @PostMapping
    public String addUser(@RequestBody User user){
        service.save(user);
        return "회원 가입 성공";
    }
}
