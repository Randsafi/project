package com.Online_Recruitment_System.web.repositories;

import com.Online_Recruitment_System.web.models.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {
}
