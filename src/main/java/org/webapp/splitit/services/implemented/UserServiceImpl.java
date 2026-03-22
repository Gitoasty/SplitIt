package org.webapp.splitit.services.implemented;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webapp.splitit.data.entity.User;
import org.webapp.splitit.data.repository.UserRepo;
import org.webapp.splitit.services.base.UserService;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepo repo;

    @Override
    public List<User> getAll() {
        return repo.findAll();
    }

    @Override
    public User insert(User in) {
        return repo.save(in);
    }

    @Override
    public User getByName(String name) {
        return repo.findByUsername(name);
    }

    @Override
    public boolean delete(String name) {
        return repo.deleteByUsername(name) == 1;
    }

    @Override
    public List<User> getByGroupId(int groupId) {
        return repo.findAllByGroupId(groupId);
    }
}
