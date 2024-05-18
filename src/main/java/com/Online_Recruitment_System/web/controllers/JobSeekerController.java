package com.Online_Recruitment_System.web.controllers;

import com.Online_Recruitment_System.web.models.JobSeeker;
import com.Online_Recruitment_System.web.services.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/jobseekers")
public class JobSeekerController {
   @Autowired
    private JobSeekerService jobSeekerService;

   @PostMapping("/register")
    @ResponseBody
    public JobSeeker saveJobSeeker(@RequestBody JobSeeker jobSeeker){
       return jobSeekerService.saveJobSeeker(jobSeeker);
   }


}
