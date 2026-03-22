package org.webapp.splitit.services.base;

import org.webapp.splitit.data.dto.UserGroupDTO;
import org.webapp.splitit.data.entity.UserGroup;

import java.util.List;

public interface UserGroupService {
    List<UserGroup> getAll();

    UserGroup insert(UserGroupDTO in);

    UserGroup getByName(String name);
}
