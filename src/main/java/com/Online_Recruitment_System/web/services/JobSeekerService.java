package com.Online_Recruitment_System.web.services;

import com.Online_Recruitment_System.web.models.JobSeeker;
import com.Online_Recruitment_System.web.repositories.JobSeekerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerService {
    private final JobSeekerRepository jobSeekerRepository;

    public JobSeekerService(JobSeekerRepository jobSeekerRepository) {
        this.jobSeekerRepository = jobSeekerRepository;
    }

    public List<JobSeeker> getAll() {
        return jobSeekerRepository.findAll();
    }

    public void save(JobSeeker jobSeeker) {
        jobSeekerRepository.save(jobSeeker);
    }
}