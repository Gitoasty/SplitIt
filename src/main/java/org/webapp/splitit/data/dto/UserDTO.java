package org.webapp.splitit.data.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.webapp.splitit.model.enums.UserRoles;

@Data
@AllArgsConstructor
public class UserDTO {
    @NotBlank
    @NotNull
    @Pattern(regexp = "^[\\p{Alpha} ]*$", message = "Name should contain only alphabets and space")
    private String username;
    @NotNull
    private String email;
    @NotNull
    private UserRoles role;
    @NotNull
    private String groupName;
}
