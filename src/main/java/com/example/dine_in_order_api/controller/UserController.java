package com.example.dine_in_order_api.controller;

import com.example.dine_in_order_api.model.User;
import com.example.dine_in_order_api.service.UserService;
import com.example.dine_in_order_api.utility.ResponseBuilder;
import com.example.dine_in_order_api.utility.ReponseStructure;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@AllArgsConstructor
public class UserController {

    @Autowired
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ReponseStructure<User>> registerUser(@RequestBody User user)
    {
        user = userService.registerUser(user);
        return ResponseBuilder.success(HttpStatus.CREATED, "User created" , user);

    }
}
