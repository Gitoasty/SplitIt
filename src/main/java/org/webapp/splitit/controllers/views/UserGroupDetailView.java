package org.webapp.splitit.controllers.views;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.dataview.GridListDataView;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import org.webapp.splitit.data.entity.User;
import org.webapp.splitit.data.entity.UserGroup;
import org.webapp.splitit.services.base.UserGroupService;
import org.webapp.splitit.services.base.UserService;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Route("details/userGroup")
@RolesAllowed("ADMIN")
public class UserGroupDetailView extends VerticalLayout implements HasUrlParameter<String> {
    private final UserGroupService service;
    private final UserService userService;

    public UserGroupDetailView(UserGroupService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @Override
    public void setParameter(BeforeEvent beforeEvent, String name) {
        String decoded = URLDecoder.decode(name, StandardCharsets.UTF_8);

        Grid<UserGroup> grid = new Grid<>(UserGroup.class);

        GridListDataView<UserGroup> dataView = grid.setItems(service.getByName(decoded));

        Grid<User> userGrid = new Grid<>(User.class);
        GridListDataView<User> userView = userGrid.setItems(userService.getByGroupId(service.getByName(decoded).getId()));

        add(grid, userGrid);


    }
}
