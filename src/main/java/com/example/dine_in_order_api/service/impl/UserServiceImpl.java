package com.example.dine_in_order_api.service.impl;

import com.example.dine_in_order_api.enums.UserRole;
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

    @Override
    public User registerUser(User user) {
        User user2 = this.createUserByRole(user.getUserRole());
        this.mapToNewUser(user,user2);
        return userRepositry.save(user2);
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

    private void mapToNewUser(User user , User newUser){
        newUser.setUsername(user.getUsername());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setUserRole(user.getUserRole());
    }


}
