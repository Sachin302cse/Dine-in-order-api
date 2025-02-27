package com.example.dine_in_order_api.repositry;

import com.example.dine_in_order_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositry extends JpaRepository<User, Long>{
}
