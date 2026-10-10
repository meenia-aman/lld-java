package org.example.repository;

import java.util.HashMap;
import java.util.Map;
import org.example.models.Group;

/**
 * InMemoryGroupRepository
 */
public class InMemoryGroupRepository implements GroupRepository {

    private Map<String, Group> groups = new HashMap<>();

    @Override
    public Group add(Group g) {
        groups.put(g.getId(), g);
        return g;
    }

    @Override
    public Group update(Group g) {
        groups.put(g.getId(), g);
        return g;
    }

    @Override
    public Group getById(String id) {
        return this.groups.getOrDefault(id, null);
    }
}
