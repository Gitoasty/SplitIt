package org.webapp.splitit.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.webapp.splitit.data.entity.ExpenseGroup;
import org.webapp.splitit.model.enums.Currencies;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseGroupRepo extends JpaRepository<ExpenseGroup, Integer> {

    List<ExpenseGroup> findAllByName(String name);

    Optional<ExpenseGroup> findByName(String name);

    int deleteAllByName(String name);

    List<ExpenseGroup> getAllByCurrency(Currencies currency);
}
