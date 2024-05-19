package com.Online_Recruitment_System.web.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateVacantDto {
    public String jobType;
    public String description;
    public int numberYearsExperience;
    public String workPlace;
    public int holidays;
}
