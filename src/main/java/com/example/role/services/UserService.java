package com.example.role.services;

import com.example.role.dtos.ProjectRequest;
import com.example.role.dtos.ProjectResponse;
import com.example.role.dtos.UserRequest;
import com.example.role.dtos.UserResponse;

import java.util.List;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Nov 27, 2020
 */
public interface UserService {
    UserResponse saveUser(UserRequest userRequest);

    //List<UserResponse> getAllUsers();
}
