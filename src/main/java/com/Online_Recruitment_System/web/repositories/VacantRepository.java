package com.Online_Recruitment_System.web.repositories;

import com.Online_Recruitment_System.web.models.vacant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacantRepository extends JpaRepository<vacant, Long> {
    @Query("SELECT v FROM Vacant v WHERE (:companyName IS NULL OR v.company.nameCompany = :companyName) AND (:workPlace IS NULL OR v.workPlace = :workPlace) AND (:jobType IS NULL OR v.jobType = :jobType)")
    List<vacant> searchVacancies(@Param("companyName") String companyName, @Param("workPlace") String workPlace, @Param("jobType") String jobType);
}
