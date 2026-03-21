package org.webapp.splitit.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "expenseShares")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExpenseShare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "expenseId", nullable = false)
    private Expense expense;
    @Column(precision = 2)
    private Double shareAmount;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;
    @Column
    private Boolean isPaid;
    @Column
    private Date paidAt;
}