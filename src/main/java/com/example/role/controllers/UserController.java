package com.example.role.controllers;

import com.example.role.dtos.UserRequest;
import com.example.role.dtos.UserResponse;
import com.example.role.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Nov 27, 2020
 */
@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/save")
    public ResponseEntity saveUser(@RequestBody UserRequest userRequest) {

        UserResponse userResponse = userService.saveUser(userRequest);
        return ResponseEntity.ok(userResponse);
    }

}
