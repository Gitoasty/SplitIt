package org.webapp.splitit.controllers.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class RootView extends VerticalLayout {

    public RootView() {
        Button goToUserGroup = new Button("UserGroups", event -> {
            UI.getCurrent().navigate(UserGroupView.class); //tu mogu postaviti i route string
        });

        Nav navigation = new Nav();
        navigation.add(goToUserGroup);

        add(navigation);
    }
}
