package com.ruzzyfer.lookingwork.entity;

import lombok.Data;

@Data
public class JobSearchRequest {

    private String jobTitle;

    private int experienceYears;

    private String jobType; // Intern, Bootcamp, work etc.

}
