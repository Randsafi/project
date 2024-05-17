package com.Online_Recruitment_System.web.models;
import jakarta.persistence.*;
import lombok.*;


@Builder
@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="JobSeeker")


public class JobSeeker extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String fullName;
    private int YearsOfExperience;
    private int age;
    private String country;
    private String workType;
    private String ExpOFWorkExperiences;
    private String Phone;

    public JobSeeker(Long id, String username, String password, String fullName, int yearsOfExperience, int age, String country, String workType, String expOFWorkExperiences, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        YearsOfExperience = yearsOfExperience;
        this.age = age;
        this.country = country;
        this.workType = workType;
        ExpOFWorkExperiences = expOFWorkExperiences;
        Phone = phone;
    }

    public JobSeeker() {
    }
}
