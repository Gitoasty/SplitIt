package org.webapp.splitit.controllers.api;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webapp.splitit.data.dto.UserGroupDTO;
import org.webapp.splitit.data.entity.UserGroup;
import org.webapp.splitit.services.base.UserGroupService;

@RestController
@RequestMapping("/api/userGroup")
@AllArgsConstructor
public class UserGroupController {
    private UserGroupService service;

    @PostMapping("/new")
    public ResponseEntity<UserGroup> addNew(@RequestBody @Valid UserGroupDTO group) {
        if (service.getByName(group.getName()) == null) {
            service.insert(group);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
