package org.example.repository.user;

import org.example.models.User;

/**
 * UserRepository
 */
public interface UserRepository {
    User add(User u);
    User update(User u);
    User getUserById(String id);
}
