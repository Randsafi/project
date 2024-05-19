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
    @Column(name = "name")
    private String name;
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

    public JobSeeker(String username,String email, String password, Long id, String name, int yearsOfExperience, int age, String country, String workType, String expOfWorkExperiences, String phone, List<vacant> vacants) {
        super(username,email, password);
        this.id = id;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.age = age;
        this.country = country;
        this.workType = workType;
        this.expOfWorkExperiences = expOfWorkExperiences;
        this.phone = phone;
        this.vacants = vacants;
    }

    public JobSeeker(Long id, String name,String lastName, int age, String country, String workType, String expOfWorkExperiences, String phone, List<vacant> vacants) {
        this.id = id;
        this.name = name;
        this.yearsOfExperience = yearsOfExperience;
        this.age = age;
        this.country = country;
        this.workType = workType;
        this.expOfWorkExperiences = expOfWorkExperiences;
        this.phone = phone;
        this.vacants = vacants;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getExpOfWorkExperiences() {
        return expOfWorkExperiences;
    }

    public void setExpOfWorkExperiences(String expOfWorkExperiences) {
        this.expOfWorkExperiences = expOfWorkExperiences;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<vacant> getVacants() {
        return vacants;
    }

    public void setVacants(List<vacant> vacants) {
        this.vacants = vacants;
    }
}
