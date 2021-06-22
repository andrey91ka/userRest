package com.example.usersTestTask.repository;

import com.example.usersTestTask.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
