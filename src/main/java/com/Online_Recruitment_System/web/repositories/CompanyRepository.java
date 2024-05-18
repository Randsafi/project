package com.Online_Recruitment_System.web.repositories;

import com.Online_Recruitment_System.web.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByNamec(String nameCompany);
}
