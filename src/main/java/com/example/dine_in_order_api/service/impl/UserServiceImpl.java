package com.example.dine_in_order_api.service.impl;

import com.example.dine_in_order_api.dto.request.RegistrationRequest;
import com.example.dine_in_order_api.dto.request.UserRequest;
import com.example.dine_in_order_api.dto.response.UserResponse;
import com.example.dine_in_order_api.enums.UserRole;
import com.example.dine_in_order_api.exception.UserNotFoundByIdException;
import com.example.dine_in_order_api.mapper.UserMapper;
import com.example.dine_in_order_api.model.Admin;
import com.example.dine_in_order_api.model.Staff;
import com.example.dine_in_order_api.model.User;
import com.example.dine_in_order_api.repositry.UserRepositry;
import com.example.dine_in_order_api.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private final UserRepositry userRepositry;
    @Autowired
    private final UserMapper userMapper;

    @Override
    public UserResponse registerUser(RegistrationRequest registrationRequest) {
        User user = this.createUserByRole(registrationRequest.getRole());
        userMapper.mapToUserEntity(registrationRequest, user);
        userRepositry.save(user);
        return userMapper.mapToUserResponse(user);

    }

    @Override
    public UserResponse findUserById(long userId) {

        return userRepositry.findById(userId)
                .map(userMapper::mapToUserResponse)
                .orElseThrow(()-> new UserNotFoundByIdException("Failed to find user, user not found by id"));

    }

    @Override
    public UserResponse updateByUserId(UserRequest userRequest, long userId) {
        return userRepositry.findById(userId)
                .map(exUser -> {
                    userMapper.mapToUserEntity(userRequest, exUser);
                    userRepositry.save(exUser);
                    return userMapper.mapToUserResponse(exUser);  // Return the mapped response
                })
                .orElseThrow(() -> new UserNotFoundByIdException("Failed to find user, user not found by id"));
    }

    private User createUserByRole(UserRole role){
        User user;

        switch(role){
            case ADMIN-> user = new Admin();
            case STAFF-> user = new Staff();
            default->throw new RuntimeException("Failed to register user, invalid user type");
        }
        return user;
    }


}
