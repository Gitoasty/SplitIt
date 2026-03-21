package org.webapp.splitit.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserGroupDTO {
    private String name;
    private String desription;
    private Date createdAt;
}
