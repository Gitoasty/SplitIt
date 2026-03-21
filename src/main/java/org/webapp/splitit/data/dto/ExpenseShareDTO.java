package org.webapp.splitit.data.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ExpenseShareDTO {
    @NotNull
    private Double total;
    @NotNull
    private Double shareAmount;
    @NotNull
    private String username;
    private Boolean isPaid;
    private Date paidAt;
}
