package com.example.role.services;

import com.example.role.dtos.ProjectResponse;
import com.example.role.dtos.UserRequest;
import com.example.role.dtos.UserResponse;
import com.example.role.models.Project;
import com.example.role.models.User;
import com.example.role.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Zeeshan Adil
 * Created by mhmdz on Nov 27, 2020
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
        if (userRequest.getUsername() == null) {
            throw new RuntimeException("Parameter username not found in request");
        } else if (userRequest.getPassword() == null) {
            throw new RuntimeException("Parameter password not found in request");
        }
        User savedUser = null;
        if (userRequest.getId() != null) {
            User oldUser= userRepository.findAllValid(userRequest.getId());
            if (oldUser != null) {
                oldUser.setId(userRequest.getId());
                oldUser.setPassword(userRequest.getPassword());
                oldUser.setUsername(userRequest.getUsername());
               // oldUser.setEnabled(userRequest.isEnabled());
                savedUser = userRepository.save(oldUser);
            } else {
                throw new RuntimeException("Cannot find user with identifier: " + userRequest.getId());
            }

        } else {
            User user = modelMapper.map(userRequest, User.class);
            savedUser = userRepository.save(user);



        }
        UserResponse userResponse = modelMapper.map(savedUser, UserResponse.class);
        return userResponse;
    }
}
