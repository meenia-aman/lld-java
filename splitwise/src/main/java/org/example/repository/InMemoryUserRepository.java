package org.example.repository;

import java.util.HashMap;
import java.util.Map;
import org.example.models.User;

/**
 * InMemoryUserRepository
 */
public class InMemoryUserRepository implements UserRepository {

    private Map<String, User> users = new HashMap<>();

    @Override
    public User add(User user) {
        this.users.put(user.getId(), user);
        return user;
    }

    @Override
    public User getById(String userId) {
        return this.users.getOrDefault(userId, null);
    }
}
