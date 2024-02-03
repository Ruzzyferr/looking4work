package com.ruzzyfer.lookingwork.entity;

import lombok.Data;

@Data
public class JobSearchResponse {

    private String jobTitle;
    private String companyName;
    private String jobDescription;
    private String jobWebsite;

}
