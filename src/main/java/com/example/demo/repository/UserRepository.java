package com.example.demo.repository;

import java.util.Optional;
import com.example.demo.entity.User;

// Minimal interface to satisfy UserServiceImpl
public interface UserRepository {
    Optional<User> findByUsername(String username);
    User save(User user);
}
