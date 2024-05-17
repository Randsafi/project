package com.Online_Recruitment_System.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Optional;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilterVacantDto {
    public Optional<String> namecompany ;

    public Optional<String> job_type;

    public Optional<String> work_place;

}
