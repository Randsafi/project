package com.Online_Recruitment_System.web.controllers;

import com.Online_Recruitment_System.web.dtos.JobSeekerDto;
import com.Online_Recruitment_System.web.models.JobSeeker;
import com.Online_Recruitment_System.web.services.JobSeekerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/jobseekers")
public class JobSeekerController {
   @Autowired
    private JobSeekerService jobSeekerService;

   @PostMapping("/register")
    public String saveJobSeeker(JobSeekerDto jobSeekerDto){
       JobSeeker jobSeeker=this.jobSeekerService.findByName(jobSeekerDto.Name);
       System.out.println(jobSeeker);
       if (jobSeeker != null)
           return "redirect:/user/register?fullnameError=true";
       return "creat-jobseeker";
   }


}
