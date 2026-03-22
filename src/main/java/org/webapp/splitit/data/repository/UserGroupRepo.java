package org.webapp.splitit.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.webapp.splitit.data.entity.UserGroup;

import java.util.Optional;

@Repository
public interface UserGroupRepo extends JpaRepository<UserGroup, Integer> {

    Optional<UserGroup> findByName(String name);

    int deleteByName(String name);
}
