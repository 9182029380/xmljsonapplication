package com.example.UserApplication.repo;

import com.example.UserApplication.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * The interface User repository.
 */
public interface UserRepository extends JpaRepository<User,Integer> {
}
