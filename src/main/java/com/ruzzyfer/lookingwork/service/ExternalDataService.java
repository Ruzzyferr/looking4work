package com.ruzzyfer.lookingwork.service;

import com.ruzzyfer.lookingwork.entity.JobSearchResponse;
import org.springframework.stereotype.Service;

@Service
public interface ExternalDataService {
    JobSearchResponse fetchDataFromExternalSource(String jobTitle, int experienceYears, String jobType);
}
