package org.webapp.splitit.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name = "userGroups")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userGroupId", nullable = false)
    private Integer id;

    @Column
    private String name;
    @Column
    private String description;
    @Column
    @CreationTimestamp
    private Date createdAt;
}