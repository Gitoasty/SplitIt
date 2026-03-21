package org.webapp.splitit.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.webapp.splitit.model.enums.UserRoles;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false)
    private Integer id;

    @Column(unique = true)
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    @Enumerated(EnumType.STRING)
    private UserRoles role;
    @ManyToOne
    @JoinColumn(name = "userGroupId")
    private UserGroup group;
}