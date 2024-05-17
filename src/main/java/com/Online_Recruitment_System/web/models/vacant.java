package com.Online_Recruitment_System.web.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vacant")
public class vacant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany
    @JoinTable(
            name = "vacant_applicants",
            joinColumns = @JoinColumn(name = "vacant_id"),
            inverseJoinColumns = @JoinColumn(name = "job_seeker_id")
    )
    private List<JobSeeker> jobSeekers;

    private String jobType;
    @Column(nullable = true, columnDefinition = "TEXT")
    private String description;
    private int numberYearsExperience;
    private String workPlace;
    private int holidays;

    public vacant(Long id, Company company, List<JobSeeker> jobSeekers, String jobType, String description, int numberYearsExperience, String workPlace, int holidays) {
        this.id = id;
        this.company = company;
        this.jobSeekers = jobSeekers;
        this.jobType = jobType;
        this.description = description;
        this.numberYearsExperience = numberYearsExperience;
        this.workPlace = workPlace;
        this.holidays = holidays;
    }

    public vacant() {
    }

    public vacant(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<JobSeeker> getJobSeekers() {
        return jobSeekers;
    }

    public void setJobSeekers(List<JobSeeker> jobSeekers) {
        this.jobSeekers = jobSeekers;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberYearsExperience() {
        return numberYearsExperience;
    }

    public void setNumberYearsExperience(int numberYearsExperience) {
        this.numberYearsExperience = numberYearsExperience;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public int getHolidays() {
        return holidays;
    }

    public void setHolidays(int holidays) {
        this.holidays = holidays;
    }
}
