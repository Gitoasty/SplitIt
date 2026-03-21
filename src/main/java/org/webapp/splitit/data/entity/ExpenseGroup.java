package org.webapp.splitit.data.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.webapp.splitit.model.enums.Currencies;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "expenseGroups")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "groupId", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Expense> expenses;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    @CreationTimestamp
    private Date createdAt;
    @Column
    @Enumerated(EnumType.STRING)
    private Currencies currency;
}



