package org.example.repository.user;

import java.util.HashMap;
import java.util.Map;
import org.example.models.User;

/**
 * InMemoryUserRepository
 */
public class InMemoryUserRepository implements UserRepository {

    private Map<String, User> users = new HashMap<>();

    @Override
    public User add(User u) {
        users.put(u.getId(), u);
        return u;
    }

    @Override
    public User update(User u) {
        users.put(u.getId(), u);
        return u;
    }

    @Override
    public User getUserById(String id) {
        return users.getOrDefault(id, null);
    }
}
