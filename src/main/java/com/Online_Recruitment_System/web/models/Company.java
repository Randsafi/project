package com.Online_Recruitment_System.web.models;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="company")

public class Company extends User{

    private String nameCompany;
    private String username;
    private String password;
    private String location;
    private String workType ;

    public Company(String nameCompany, String username, String password, String location, String workType) {
        this.nameCompany = nameCompany;
        this.username = username;
        this.password = password;
        this.location = location;
        this.workType = workType;
    }

    public Company() {
    }
}
