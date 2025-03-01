package com.example.dine_in_order_api.service;

import com.example.dine_in_order_api.dto.request.RegistrationRequest;
import com.example.dine_in_order_api.dto.request.UserRequest;
import com.example.dine_in_order_api.dto.response.UserResponse;
import com.example.dine_in_order_api.model.User;

public interface UserService {

    public UserResponse registerUser(RegistrationRequest registrationRequest);
    public UserResponse findUserById(long userId);
    public UserResponse updateByUserId(UserRequest userRequest, long userId);

}
