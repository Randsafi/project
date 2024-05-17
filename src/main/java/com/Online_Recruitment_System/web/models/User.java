package com.Online_Recruitment_System.web.models;

import jakarta.persistence.MappedSuperclass;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class User {
    private String username;
    private String password;
}
