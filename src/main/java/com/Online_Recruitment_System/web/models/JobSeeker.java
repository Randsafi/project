package com.Online_Recruitment_System.web.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "job_seeker")
public class JobSeeker extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private int yearsOfExperience;
    private int age;
    private String country;
    private String workType;
    private String expOfWorkExperiences;
    private String phone;

    @ManyToMany
    @JoinTable(
            name = "job_seeker_vacants",
            joinColumns = @JoinColumn(name = "job_seeker_id"),
            inverseJoinColumns = @JoinColumn(name = "vacant_id")
    )
    private List<vacant> vacants;

    public JobSeeker() {
    }

    public JobSeeker(String username,String email, String password, Long id, String fullName, int yearsOfExperience, int age, String country, String workType, String expOfWorkExperiences, String phone, List<vacant> vacants) {
        super(username,email, password);
        this.id = id;
        this.fullName = fullName;
        this.yearsOfExperience = yearsOfExperience;
        this.age = age;
        this.country = country;
        this.workType = workType;
        this.expOfWorkExperiences = expOfWorkExperiences;
        this.phone = phone;
        this.vacants = vacants;
    }

    public JobSeeker(Long id, String fullName, int yearsOfExperience, int age, String country, String workType, String expOfWorkExperiences, String phone, List<vacant> vacants) {
        this.id = id;
        this.fullName = fullName;
        this.yearsOfExperience = yearsOfExperience;
        this.age = age;
        this.country = country;
        this.workType = workType;
        this.expOfWorkExperiences = expOfWorkExperiences;
        this.phone = phone;
        this.vacants = vacants;
    }

}
