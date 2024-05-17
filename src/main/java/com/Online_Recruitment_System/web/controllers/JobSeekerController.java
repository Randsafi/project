package com.Online_Recruitment_System.web.controllers;

import com.Online_Recruitment_System.web.models.JobSeeker;
import com.Online_Recruitment_System.web.services.JobSeekerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/jobseekers")
public class JobSeekerController {
    private final JobSeekerService jobSeekerService;

    public JobSeekerController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping
    public String getAllJobSeekers(Model model) {
        List<JobSeeker> jobSeekers = jobSeekerService.getAll();
        model.addAttribute("jobSeekers", jobSeekers);
        return "all-jobseekers";
    }

    @GetMapping("/create")
    public String createJobSeekerForm(Model model) {
        model.addAttribute("jobSeeker", new JobSeeker());
        return "create-jobseeker";
    }

    @PostMapping("/create")
    public String createJobSeeker(@ModelAttribute JobSeeker jobSeeker) {
        jobSeekerService.save(jobSeeker);
        return "redirect:/jobseekers";
    }
}
