package org.webapp.splitit.services.implemented;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webapp.splitit.data.dto.UserGroupDTO;
import org.webapp.splitit.data.entity.UserGroup;
import org.webapp.splitit.data.repository.UserGroupRepo;
import org.webapp.splitit.services.base.UserGroupService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserGroupServiceImpl implements UserGroupService {
    UserGroupRepo repo;

    @Override
    public List<UserGroup> getAll() {
        return repo.findAll();
    }


    @Override
    public UserGroup insert(UserGroupDTO in) {
        UserGroup saved = new UserGroup();
        saved.setName(in.getName());
        saved.setDescription(in.getDescription());

        return repo.save(saved);
    }

    @Override
    public UserGroup getByName(String name) {
        Optional<UserGroup>  group = repo.findByName(name);

        return group.orElse(null);
    }

    @Transactional
    @Override
    public boolean delete(String name) {
        return repo.deleteByName(name) == 1;
    }
}
