package org.example.service;

import org.example.models.User;
import org.example.repository.user.UserRepository;

/**
 * UserService
 */
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name, String email, String address) {
        User user = new User(name, email, address);
        userRepository.add(user);
        return user;
    }

    public User getUserById(String id) {
        return userRepository.getUserById(id);
    }
}
