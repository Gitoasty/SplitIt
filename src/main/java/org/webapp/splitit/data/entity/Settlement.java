package org.webapp.splitit.data.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


//TODO add updating the settlement in the service when inserting an expense
@Entity
@Table(name = "settlements")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Settlement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "settlementId", nullable = false)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "groupId", nullable = false, unique = true)
    private ExpenseGroup group;
    @Column
    private Double amount;
    @Column
    private Date settledAt;
    @Column
    private String notes;
}