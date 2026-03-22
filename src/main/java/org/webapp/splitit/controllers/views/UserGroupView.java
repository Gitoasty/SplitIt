package org.webapp.splitit.controllers.views;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.dataview.GridListDataView;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.webapp.splitit.data.entity.UserGroup;
import org.webapp.splitit.services.base.UserGroupService;

@Route("/userGroup")
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

        Div item = new Div();
        item.setText("Display selected itema");

        grid.asSingleSelect().addValueChangeListener(event -> {
            UserGroup selected = event.getValue();

            if (selected != null) {
                item.setText(
                        "Selected: " + selected.getName() +
                        " | Description: " + selected.getDescription()
                );
            } else {
                item.setText("Nothing selected.");
            }
        });

        add(searchInput, grid, item);
    }
}
