package com.example.dine_in_order_api.controller;

import com.example.dine_in_order_api.dto.request.RegistrationRequest;
import com.example.dine_in_order_api.dto.request.UserRequest;
import com.example.dine_in_order_api.dto.response.UserResponse;
import com.example.dine_in_order_api.model.User;
import com.example.dine_in_order_api.service.UserService;
import com.example.dine_in_order_api.utility.ResponseBuilder;
import com.example.dine_in_order_api.utility.ResponseStructure;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private  UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> registerUser(@RequestBody @Valid RegistrationRequest registrationRequest)
    {
        UserResponse userResponse = userService.registerUser(registrationRequest);
        return ResponseBuilder.success(HttpStatus.CREATED, "User created" , userResponse);

    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> findByUserId( @PathVariable long userId){
        UserResponse response= userService.findUserById(userId);
        return ResponseBuilder.success(HttpStatus.FOUND, "User found" , response);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<ResponseStructure<UserResponse>> updateByUserId(@RequestBody UserRequest userRequest,
                                                                          @PathVariable long userId){
        UserResponse response= userService.updateByUserId(userRequest,userId);
        return ResponseBuilder.success(HttpStatus.OK, "User Updated" , response);
    }


}
