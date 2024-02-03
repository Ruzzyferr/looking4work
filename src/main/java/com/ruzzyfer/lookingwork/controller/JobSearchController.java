package com.ruzzyfer.lookingwork.controller;

import com.ruzzyfer.lookingwork.entity.JobSearchRequest;
import com.ruzzyfer.lookingwork.entity.JobSearchResponse;
import com.ruzzyfer.lookingwork.service.JobSearchService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job-search")
public class JobSearchController {

    private final JobSearchService jobSearchService;

    public JobSearchController(JobSearchService jobSearchService) {
        this.jobSearchService = jobSearchService;
    }

    @PostMapping("/search")
    public JobSearchResponse searchJob(@RequestBody JobSearchRequest request) {
        return jobSearchService.searchJob(request);
    }

}
