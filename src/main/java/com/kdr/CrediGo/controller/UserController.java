package com.kdr.CrediGo.controller;

import com.kdr.CrediGo.service.impl.UserService;
import com.kdr.CrediGo.dto.BankResponse;
import com.kdr.CrediGo.dto.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/user")

public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public BankResponse createAccount(@RequestBody UserRequest userRequest) {
        return userService.createAccount(userRequest);
    }
}
