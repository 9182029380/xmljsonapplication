package com.example.UserApplication.controller;

import com.example.UserApplication.entity.User;
import com.example.UserApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

/**
 * The type User controller.
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
//    @PostMapping
//    public User addUser(@RequestBody User user) {
//        return userService.createUser(user);
//    }

    /**
     * Add users list.
     *
     * @param users the users
     * @return the list
     */
    @PostMapping
    public List<User> addUsers(@RequestBody List<User> users) {
        return userService.createUsers(users);
    }

    /**
     * Gets user by id.
     *
     * @param id the id
     * @return the user by id
     */
    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    /**
     * Gets all users.
     *
     * @return the all users
     */
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getUsers();
    }

    /**
     * Update user user.
     *
     * @param user the user
     * @return the user
     */
    @PutMapping("/updateuser")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * Delete user string.
     *
     * @param id the id
     * @return the string
     */
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUserById(id);
    }

}
