package org.webapp.splitit.controllers.api;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.webapp.splitit.data.dto.UserDTO;
import org.webapp.splitit.data.entity.User;
import org.webapp.splitit.model.enums.UserRoles;
import org.webapp.splitit.services.base.UserGroupService;
import org.webapp.splitit.services.base.UserService;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private UserGroupService groupService;

    @PostMapping("/new")
    public ResponseEntity<User> addNew(@RequestBody @Valid UserDTO userIn) {
        if (userService.getByName(userIn.getUsername()) == null && groupService.getByName(userIn.getGroupName()) != null) {
            User user = new User();
            user.setUsername(userIn.getUsername());
            user.setPassword(userIn.getPassword());
            user.setEmail(userIn.getEmail());
            user.setRole(UserRoles.USER);
            user.setGroup(groupService.getByName(userIn.getGroupName()));

            userService.insert(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
