package org.webapp.splitit.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.webapp.splitit.model.enums.Currencies;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
public class ExpenseGroupDTO {
    private List<ExpenseDTO> expenses;
    @NotBlank
    @NotNull
    private String name;
    @Size(max = 500)
    private String description;
    private Date createdAt;
    @NotNull
    private Currencies currency;
}
