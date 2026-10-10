package org.example.services;

import java.util.List;
import org.example.models.Group;
import org.example.models.User;
import org.example.repository.GroupRepository;

/**
 * GroupService
 */
public class GroupService {

    private GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public Group CreateGroup(String name, String createdBy, List<User> users) {
        Group group = new Group(name, createdBy, users);
        return this.groupRepository.add(group);
    }

    public Group getGroupById(String id) {
        return this.groupRepository.getById(id);
    }

    public Group updateGroup(String id, Group group) {
        return this.groupRepository.update(group);
    }
}
