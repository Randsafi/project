package com.Online_Recruitment_System.web.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


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
           inverseJoinColumns = @JoinColumn(name = "regular_user_id")
   )

    private String Job_type;
    @Column(nullable = true, columnDefinition="TEXT")
    private String Description;
    private  int Number_years_experience;
    private String Work_place;
    private  int Holidays;

    public vacant(Long id, String job_type, String description, int number_years_experience, int holidays, String work_place) {
        this.id = id;
        this.Job_type = job_type;
        this.Description = description;
        this.Number_years_experience = number_years_experience;
        this.Holidays = holidays;
        this.Work_place = work_place;
    }

    public vacant() {
    }

    public vacant(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }


    public String getJob_type() {
        return Job_type;
    }

    public void setJob_type(String job_type) {
        Job_type = job_type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getHolidays() {
        return Holidays;
    }

    public void setHolidays(int holidays) {
        Holidays = holidays;
    }

    public int getNumber_years_experience() {
        return Number_years_experience;
    }

    public void setNumber_years_experience(int number_years_experience) {
        Number_years_experience = number_years_experience;
    }

    public String getWork_place() {
        return Work_place;
    }

    public void setWork_place(String work_place) {
        Work_place = work_place;
    }
}
