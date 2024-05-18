package com.Online_Recruitment_System.web.services;

import com.Online_Recruitment_System.web.dtos.CompanyDto;
import com.Online_Recruitment_System.web.models.Company;
import com.Online_Recruitment_System.web.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    public void saveCompany(CompanyDto companyDto){
        Company company=new Company();
        this.companyRepository.save(company);
    }

    public  Company findByNamec(String nameCompany){
        Optional<Company> company=this.companyRepository.findByNamec(nameCompany);
        if (company.isPresent())
            return company.get();
        return null;
    }

    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    public void save(Company company) {
        companyRepository.save(company);
    }
}
