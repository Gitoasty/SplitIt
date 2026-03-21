package org.webapp.splitit.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.webapp.splitit.model.enums.UserRoles;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String username;
    private String email;
    private UserRoles role;
    private String groupName;
}
