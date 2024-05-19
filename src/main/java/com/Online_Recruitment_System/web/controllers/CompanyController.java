package com.Online_Recruitment_System.web.controllers;

import com.Online_Recruitment_System.web.dtos.CompanyDto;
import com.Online_Recruitment_System.web.models.Company;
import com.Online_Recruitment_System.web.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @PostMapping("/register")
    public String saveCompany(CompanyDto companyDto) {
        Company company=this.companyService.findByName(CompanyDto.name);
        System.out.println(company);
        if (company != null)
            return "redirect:/user/register?nameCompanyError=true";
        this.companyService.saveCompany(companyDto);
        return "create-company";
    }

//    @GetMapping
//    public String getAllCompanies(Model model) {
//        List<Company> companies = companyService.getAll();
//        model.addAttribute("companies", companies);
//        return "all-companies";
//    }


}
