package org.webapp.splitit.data.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.webapp.splitit.model.enums.ExpenseCategories;

import java.util.Date;

@Data
@AllArgsConstructor
public class ExpenseDTO {
    @NotNull
    private String groupName;
    @NotNull
    private String description;
    @PositiveOrZero
    private Double amount;
    @NotNull
    private ExpenseCategories category;
    private Date paidAt;
}
