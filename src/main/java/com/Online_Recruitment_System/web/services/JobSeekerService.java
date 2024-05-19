package com.Online_Recruitment_System.web.services;

import com.Online_Recruitment_System.web.dtos.JobSeekerDto;
import com.Online_Recruitment_System.web.models.JobSeeker;
import com.Online_Recruitment_System.web.repositories.JobSeekerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobSeekerService {
    private JobSeekerRepository jobSeekerRepository;

    public void saveJobSeeker(JobSeekerDto jobSeekerDto){
        JobSeeker jobSeeker = new JobSeeker();
        this.jobSeekerRepository.save(jobSeeker);
    }
    public JobSeeker findByName(String name){
        Optional<JobSeeker> jobSeeker=this.jobSeekerRepository.findByName(name);
        if (jobSeeker.isPresent())
            return jobSeeker.get();
        return null;
    }

    public List<JobSeeker> getAll() {
        return jobSeekerRepository.findAll();
    }

    public void save(JobSeeker jobSeeker) {
        jobSeekerRepository.save(jobSeeker);
    }
}
