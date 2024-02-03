package com.ruzzyfer.lookingwork.service;

import com.ruzzyfer.lookingwork.entity.JobSearchRequest;
import com.ruzzyfer.lookingwork.entity.JobSearchResponse;
import org.springframework.stereotype.Service;

@Service
public interface JobSearchService {
    JobSearchResponse searchJob(JobSearchRequest request);

}
