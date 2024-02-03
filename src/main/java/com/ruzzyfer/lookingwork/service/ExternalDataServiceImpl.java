package com.ruzzyfer.lookingwork.service;

import com.ruzzyfer.lookingwork.entity.JobSearchResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalDataServiceImpl implements ExternalDataService{

    @Value("${github.api.url}")
    private String githubApiUrl;

    @Override
    public JobSearchResponse fetchDataFromExternalSource(String jobTitle, int experienceYears, String jobType) {
        String apiUrl = String.format("%s/positions.json?description=%s&experience=%d&full_time=%s",
                githubApiUrl, jobTitle, experienceYears, jobType);

        // GitHub Jobs API'ye bağlanma ve veri çekme
        RestTemplate restTemplate = new RestTemplate();
        JobSearchResponse response = restTemplate.getForObject(apiUrl, JobSearchResponse.class);

        return response;
    }


}
