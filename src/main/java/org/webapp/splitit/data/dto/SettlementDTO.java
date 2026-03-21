package org.webapp.splitit.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SettlementDTO {
    private String groupName;
    private Double amount;
    private Date settledAt;
    private String notes;
}
