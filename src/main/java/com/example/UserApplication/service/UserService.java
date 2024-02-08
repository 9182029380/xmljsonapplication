package com.example.UserApplication.service;

import com.example.UserApplication.entity.User;
import com.example.UserApplication.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type User service.
 */
@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    /**
     * Create user user.
     *
     * @param user the user
     * @return the user
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * Create users list.
     *
     * @param users the users
     * @return the list
     */
    public List<User> createUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    /**
     * Gets user by id.
     *
     * @param id the id
     * @return the user by id
     */
    public User getUserById(int id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Gets users.
     *
     * @return the users
     */
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    /**
     * Update user user.
     *
     * @param user the user
     * @return the user
     */
    public User updateUser(User user) {
        User oldUser=null;
        Optional<User> optionaluser=userRepository.findById(user.getId());
        if(optionaluser.isPresent()) {
            oldUser=optionaluser.get();
            oldUser.setName(user.getName());
            oldUser.setAddress(user.getAddress());
            userRepository.save(oldUser);
        }else {
            return new User();
        }
        return oldUser;
    }

    /**
     * Delete user by id string.
     *
     * @param id the id
     * @return the string
     */
    public String deleteUserById(int id) {
        userRepository.deleteById(id);
        return "User got deleted";
    }

}