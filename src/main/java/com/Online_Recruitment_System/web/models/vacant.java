package com.Online_Recruitment_System.web.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jdk.jfr.Enabled;

@Enabled
@Table(name="vacant")
public class vacant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String Job_type;
    private String Description;
    private  int Number_years_experience;
    private String Work_place;
    private  int Holidays;

}
