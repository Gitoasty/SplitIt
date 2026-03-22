package org.webapp.splitit.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.webapp.splitit.data.entity.User;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUsername(String name);

    int deleteByUsername(String name);

    List<User> findAllByGroupId(Integer id);
}
