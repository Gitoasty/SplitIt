package org.webapp.splitit.services.base;

import org.webapp.splitit.data.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User insert(User in);

    User getByName(String name);

    boolean delete(String name);

    List<User> getByGroupId(int groupId);
}
