package org.webapp.splitit.controllers.api;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webapp.splitit.data.dto.ExpenseGroupDTO;
import org.webapp.splitit.data.entity.ExpenseGroup;
import org.webapp.splitit.model.enums.Currencies;
import org.webapp.splitit.services.implemented.ExpenseGroupServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/expenseGroup")
@AllArgsConstructor
public class ExpenseGroupController {
    private ExpenseGroupServiceImpl service;

    @GetMapping("/all")
    public List<ExpenseGroup> getAll() {
        return service.getAll();
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<ExpenseGroup> getOne(@PathVariable Integer id) {
        ExpenseGroup out = service.getById(id);

        if (out == null) {
            return (ResponseEntity<ExpenseGroup>) ResponseEntity.notFound();
        } else {
            return ResponseEntity.ok().body(out);
        }
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<ExpenseGroup> getByName(@PathVariable String name) {
        ExpenseGroup out = service.getByName(name);

        if (out == null) {
            return (ResponseEntity<ExpenseGroup>) ResponseEntity.notFound();
        } else {
            return ResponseEntity.ok().body(out);
        }
    }

    @PostMapping("/currency")
    public ResponseEntity<List<ExpenseGroup>> getByCurrency(@RequestBody Currencies currency) {
        List<ExpenseGroup> list = service.getByCurrency(currency);

        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(list);
        }
    }

    @PostMapping("/new")
    public ResponseEntity<ExpenseGroup> addNew(@RequestBody @Valid ExpenseGroupDTO group) {
        if (service.getByName(group.getName()) == null) {
            service.insert(group);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<ExpenseGroup> remove(@PathVariable String name) {
        if (service.getByName(name) != null) {
            service.delete(name);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
