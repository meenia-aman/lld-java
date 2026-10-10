package org.example.repository;

import org.example.models.Group;

/**
 * GroupRepository
 */
public interface GroupRepository {
    Group add(Group g);
    Group update(Group g);
    Group getById(String id);
}
