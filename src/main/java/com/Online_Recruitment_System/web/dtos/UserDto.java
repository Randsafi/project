package com.Online_Recruitment_System.web.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    public Long id;
    public String email;
    public String username;
    public String active;
}
