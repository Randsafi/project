package com.Online_Recruitment_System.web.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;



@Entity
@Table(name = "company")
public class Company extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameCompany;
    private String location;
    private String workType;

   @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
   private List<vacant> vacants;

    public Company(String username,String email,String password, String nameCompany, String location, String workType, List<vacant> vacants) {
        super(username,email ,password);
        this.nameCompany = nameCompany;
        this.location = location;
        this.workType = workType;
        this.vacants = vacants;
    }


    public Company() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public List<vacant> getVacants() {
        return vacants;
    }

    public void setVacants(List<vacant> vacants) {
        this.vacants = vacants;
    }
}
