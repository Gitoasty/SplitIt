package org.webapp.splitit.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.webapp.splitit.model.enums.Currencies;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseGroupDTO {
    private List<ExpenseDTO> expenses;
    private String name;
    private String description;
    private Date createdAt;
    private Currencies currency;
}
