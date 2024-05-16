package com.Online_Recruitment_System.web.controllers;


import com.Online_Recruitment_System.web.models.vacant;
import com.Online_Recruitment_System.web.services.VacantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.model.IAttribute;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/vacants")
public class VacantController {

    private VacantService vacantservices;

    public VacantController(VacantService vacantservices) {
        this.vacantservices = vacantservices;
    }

    @GetMapping("/all")
    public String getAllVacants(Model model){
        List<vacant> vacant = this.vacantservices.getAll() ;

        model.addAttribute("vacant",vacant);

       return "all-vacants";
    }

    @GetMapping("/{id}")
    public String getOneVacant(Model model,@PathVariable("id") Long id){
        vacant vacans = this.vacantservices.getOne(id) ;

        if (vacans == null){

            return "not-found";
        }
        model.addAttribute("vacant",vacans);
        return "vacant";
    }
}
//.getName()