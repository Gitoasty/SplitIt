package org.webapp.splitit.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.webapp.splitit.data.entity.Settlement;

@Repository
public interface SettlementRepo extends JpaRepository<Settlement, Integer> {
}
