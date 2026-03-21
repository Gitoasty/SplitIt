package org.webapp.splitit.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.webapp.splitit.data.entity.UserGroup;

@Repository
public interface UserGroupRepo extends JpaRepository<UserGroup, Integer> {
}
