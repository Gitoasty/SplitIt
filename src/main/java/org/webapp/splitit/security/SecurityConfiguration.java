package org.webapp.splitit.security;

import com.vaadin.flow.spring.security.VaadinSecurityConfigurer;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.webapp.splitit.controllers.views.LoginView;
import org.webapp.splitit.services.implemented.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfiguration {
    final UserServiceImpl userService;

    @Bean
    @Order(1)
    public SecurityFilterChain apiSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/api/**")
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/auth/**").permitAll()
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
                        .requestMatchers("/api/user/**").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(AbstractHttpConfigurer::disable)
                .httpBasic(Customizer.withDefaults());
        // or JWT later if you want stateless auth

        return http.build();
    }

    @Bean
    @Order(2)
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configure your static resources with public access
        http.authorizeHttpRequests(auth -> auth.requestMatchers("/public/**")
                .permitAll());

        // Configure Vaadin's security using VaadinSecurityConfigurer
        http.with(VaadinSecurityConfigurer.vaadin(), configurer -> {
            // This is important to register your login view to the
            // navigation access control mechanism:
            configurer.loginView(LoginView.class);

            // You can add any possible extra configurations of your own
            // here (the following is just an example):
            // configurer.enableCsrfConfiguration(false);
        });

        return http.build();
    }

    /**
     * Demo UserDetailsManager which only provides two hardcoded
     * in memory users and their roles.
     * NOTE: This shouldn't be used in real world applications.
     */
    @Bean
    public UserDetailsManager userDetailsService() {
        List<UserDetails> userList = new ArrayList<>();

        for (org.webapp.splitit.data.entity.User user : userService.getAll()) {
            userList.add(User.withUsername(user.getUsername())
                    .password(user.getPassword())
                    .roles(String.valueOf(user.getRole()))
                    .build()
            );
        }
        return new InMemoryUserDetailsManager(userList);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
