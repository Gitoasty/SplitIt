package org.webapp.splitit.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.webapp.splitit.model.enums.ExpenseCategories;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {
    private String groupName;
    private String description;
    private Double amount;
    private ExpenseCategories category;
    private Date paidAt;
}
