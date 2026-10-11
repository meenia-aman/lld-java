package org.example.services;

import org.example.models.User;
import org.example.repository.UserRepository;

/**
 * UserService
 */
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    User createUser(String name, String email) {
        User user = new User(name, email);
        return userRepository.add(user);
    }

    User getUserById(String userId) {
        return userRepository.getById(userId);
    }
}
