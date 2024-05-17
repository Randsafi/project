package com.Online_Recruitment_System.web.repositories;

import com.Online_Recruitment_System.web.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
