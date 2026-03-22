package org.webapp.splitit.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class UserGroupDTO {
    @NotBlank
    @NotNull
    private String name;
    @NotNull
    private String description;
    private Date createdAt;
}
