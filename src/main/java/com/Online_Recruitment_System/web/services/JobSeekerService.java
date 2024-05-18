package com.Online_Recruitment_System.web.services;

import com.Online_Recruitment_System.web.models.JobSeeker;
import com.Online_Recruitment_System.web.repositories.JobSeekerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerService {
    private JobSeekerRepository jobSeekerRepository;

    public JobSeeker saveJobSeeker(JobSeeker jobSeeker){
        return jobSeekerRepository.save(jobSeeker);
    }


    public List<JobSeeker> getAll() {
        return jobSeekerRepository.findAll();
    }

    public void save(JobSeeker jobSeeker) {
        jobSeekerRepository.save(jobSeeker);
    }
}
