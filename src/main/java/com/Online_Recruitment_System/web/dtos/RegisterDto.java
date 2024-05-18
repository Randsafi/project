package com.Online_Recruitment_System.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    public String email;

    public String ussername;

    public String password;

    public boolean active;
}
