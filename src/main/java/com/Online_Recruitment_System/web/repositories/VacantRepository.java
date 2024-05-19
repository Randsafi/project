package com.Online_Recruitment_System.web.repositories;

import com.Online_Recruitment_System.web.models.vacant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacantRepository extends JpaRepository<vacant,Long> {
    // Example of a query method based on existing properties
    vacant getById(Long id);

    @Override
    List<vacant> findAllById(Iterable<Long> longs);

    List<vacant> findAll();
//    List<vacant> findByJobType(String jobType);
//    List<vacant> findByJobTypeContaining(String jobType);

    // Add more query methods as needed
}
