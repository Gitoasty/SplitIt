package org.webapp.splitit.controllers.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.dataview.GridListDataView;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import org.webapp.splitit.data.dto.UserGroupDTO;
import org.webapp.splitit.data.entity.UserGroup;
import org.webapp.splitit.model.enums.Currencies;
import org.webapp.splitit.services.base.UserGroupService;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Route("userGroup")
@PermitAll
public class UserGroupView extends VerticalLayout {

    public UserGroupView(UserGroupService service) {
        Grid<UserGroup> grid = new Grid<>(UserGroup.class);

        GridListDataView<UserGroup> dataView = grid.setItems(service.getAll());

        TextField searchInput = new TextField("Search", event -> {
            if (!event.getValue().isEmpty()) {
                dataView.setFilter(userGroup ->
                        userGroup.getName().toLowerCase().contains(event.getValue().toLowerCase()));
            } else {
                dataView.removeFilters();
            }
        });

        grid.asSingleSelect().addValueChangeListener(event -> {
            UserGroup selected = event.getValue();

            if (selected != null) {
                String encoded = URLEncoder.encode(selected.getName(), StandardCharsets.UTF_8);
                UI.getCurrent().navigate("details/userGroup/" + encoded);
            }
        });

        grid.addComponentColumn(group -> {
            Button deleteBtn = new Button("Delete");

            deleteBtn.addClickListener(e -> {
                if (service.delete(group.getName())) {
                    grid.setItems(service.getAll());

                    Notification.show("Deleted: " + group.getName()).setPosition(Notification.Position.TOP_CENTER);
                }
            });

            return deleteBtn;
        });

        TextField name = new TextField("Name");
        TextField description = new TextField("Description");

        Button save = new Button("Create Group");

        save.addClickListener(e -> {

            if (name.isEmpty() || description.isEmpty()) {
                Notification.show("Molim popuniti sva polja!").setPosition(Notification.Position.TOP_CENTER);
                return;
            }

            UserGroupDTO group = new UserGroupDTO();
            group.setName(name.getValue());
            group.setDescription(description.getValue());

            try {
                service.insert(group);

                grid.setItems(service.getAll());

                name.clear();
                description.clear();

                Notification.show("Group created").setPosition(Notification.Position.TOP_CENTER);

            } catch (Exception ex) {
                Notification.show("Error creating group").setPosition(Notification.Position.TOP_CENTER);
            }
        });

        HorizontalLayout form = new HorizontalLayout(
                name, description, save
        );

        add(searchInput, grid, form);
    }
}
