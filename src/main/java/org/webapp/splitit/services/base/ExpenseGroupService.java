package org.webapp.splitit.services.base;

import org.webapp.splitit.data.dto.ExpenseGroupDTO;
import org.webapp.splitit.data.entity.ExpenseGroup;
import org.webapp.splitit.model.enums.Currencies;

import java.util.List;

public interface ExpenseGroupService {
    List<ExpenseGroup> getAll();

    ExpenseGroup getById(Integer id);

    ExpenseGroup getByName(String name);

    boolean insert(ExpenseGroupDTO group);

    boolean delete(String name);

    List<ExpenseGroup> getByCurrency(Currencies currency);
}
