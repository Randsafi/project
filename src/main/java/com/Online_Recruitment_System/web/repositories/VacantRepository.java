package com.Online_Recruitment_System.web.repositories;

import com.Online_Recruitment_System.web.models.vacant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacantRepository extends JpaRepository<vacant,Long> {
    // Example of a query method based on existing properties
    vacant getById(Long id);
//    List<vacant> findByJobType(String jobType);
//    List<vacant> findByJobTypeContaining(String jobType);

    // Add more query methods as needed
}
