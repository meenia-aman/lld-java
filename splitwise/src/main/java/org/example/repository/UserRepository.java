package org.example.repository;

import org.example.models.User;

/**
 * UserRepository
 */
public interface UserRepository {
    User add(User user);
    User getById(String userId);
}
