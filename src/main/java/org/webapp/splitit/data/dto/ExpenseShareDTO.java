package org.webapp.splitit.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseShareDTO {
    private Double total;
    private Double shareAmount;
    private String username;
    private Boolean isPaid;
    private Date paidAt;
}
