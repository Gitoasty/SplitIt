package org.webapp.splitit.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.webapp.splitit.model.enums.ExpenseCategories;

import java.util.Date;

@Entity
@Table(name = "expenses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "expenseId", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "groupId", nullable = false)
    private ExpenseGroup group;

    @Column
    private String description;
    @Column
    private Double amount;
    @Column
    @Enumerated(EnumType.STRING)
    private ExpenseCategories category;
    @Column
    private Date paidAT;
}
