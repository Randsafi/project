package com.Online_Recruitment_System.web.controllers;

import com.Online_Recruitment_System.web.models.Company;
import com.Online_Recruitment_System.web.services.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

//    @GetMapping
//    public String getAllCompanies(Model model) {
//        List<Company> companies = companyService.getAll();
//        model.addAttribute("companies", companies);
//        return "all-companies";
//    }

    @GetMapping("/create")
    public String createCompanyForm(Model model) {
        model.addAttribute("company", new Company());
        return "create-company";
    }

    @PostMapping("/create")
    public String createCompany(@ModelAttribute Company company) {
        companyService.save(company);
        return "redirect:/companies";
    }
}
