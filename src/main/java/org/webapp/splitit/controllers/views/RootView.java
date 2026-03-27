package org.webapp.splitit.controllers.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.webapp.splitit.security.SecurityService;

@Route("")
@PageTitle("Navigation")
@PermitAll
public class RootView extends VerticalLayout {
    private SecurityService securityService;


    public RootView(@Autowired SecurityService securityService) {
        this.securityService = securityService;

        Button goToUserGroup = new Button("UserGroups", event -> {
            UI.getCurrent().navigate(UserGroupView.class); //tu mogu postaviti i route string
        });

        Nav navigation = new Nav();
        navigation.add(goToUserGroup);

        Button logout;

        if (securityService.getAuthenticatedUser() != null) {
            logout = new Button("Logout", click ->
                    securityService.logout());

            navigation.add(logout);
        }


        add(navigation);
    }
}
