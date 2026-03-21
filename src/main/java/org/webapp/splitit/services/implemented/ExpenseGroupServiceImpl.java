package org.webapp.splitit.services.implemented;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.webapp.splitit.data.dto.ExpenseGroupDTO;
import org.webapp.splitit.data.entity.ExpenseGroup;
import org.webapp.splitit.data.repository.ExpenseGroupRepo;
import org.webapp.splitit.model.enums.Currencies;
import org.webapp.splitit.services.base.ExpenseGroupService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExpenseGroupServiceImpl implements ExpenseGroupService {
    private ExpenseGroupRepo repo;
    @Override
    public List<ExpenseGroup> getAll() {
        return repo.findAll();
    }

    @Override
    public ExpenseGroup getById(Integer id) {
        Optional<ExpenseGroup> group = repo.findById(id);

        return group.orElse(null);
    }

    @Override
    public ExpenseGroup getByName(String name) {
        Optional<ExpenseGroup> group = repo.findByName(name);

        return group.orElse(null);
    }

    @Override
    public boolean insert(ExpenseGroupDTO group) {
        ExpenseGroup insertGroup = new ExpenseGroup();
        insertGroup.setName(group.getName());
        insertGroup.setDescription(group.getDescription());
        insertGroup.setCurrency(group.getCurrency());
        Optional<ExpenseGroup> groupSaved = Optional.of(repo.save(insertGroup));

        return groupSaved.isPresent();
    }

    @Override
    @Transactional
    public boolean delete(String name) {
        int deleted = repo.deleteAllByName(name);

        return deleted == 1;
    }

    @Override
    public List<ExpenseGroup> getByCurrency(Currencies currency) {
        return repo.getAllByCurrency(currency);
    }
}
