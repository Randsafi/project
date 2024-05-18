package com.Online_Recruitment_System.web.controllers;


import com.Online_Recruitment_System.web.dtos.CreateVacantDto;
import com.Online_Recruitment_System.web.dtos.FilterVacantDto;
import com.Online_Recruitment_System.web.models.vacant;
import com.Online_Recruitment_System.web.services.VacantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        List<vacant> vacant;
        vacant = this.vacantservices.getAll();

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

    @GetMapping("/create-vacancy")
    public String createVacancy() {

        return "create-vacancy";
    }

    @PostMapping("/create-vacancy")
    public String getcreateVacancy(@ModelAttribute CreateVacantDto createVacantDto, @RequestParam Long companyId) {
        vacantservices.create(createVacantDto);
        return "redirect:/all-vacants";
    }
    @GetMapping("/filter")
    public String filterVacant(FilterVacantDto filterV, Model model) {
        System.out.println(filterV);
        List<vacant> v = this.vacantservices.filter(filterV);
        model.addAttribute("vacants", v);  // Changed to "vacants" for consistency
        return "search-form";
    }

}
//.getName()