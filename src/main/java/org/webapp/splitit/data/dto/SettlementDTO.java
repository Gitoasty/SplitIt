package org.webapp.splitit.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class SettlementDTO {
    @NotBlank
    @NotNull
    private String groupName;
    @NotNull
    private Double amount;
    @NotNull
    private Date settledAt;
    @NotNull
    private String notes;
}
