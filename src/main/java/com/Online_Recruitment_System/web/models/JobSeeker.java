package com.Online_Recruitment_System.web.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}
