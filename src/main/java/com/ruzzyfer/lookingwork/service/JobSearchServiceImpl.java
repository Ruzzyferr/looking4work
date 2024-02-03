package com.ruzzyfer.lookingwork.service;

import com.ruzzyfer.lookingwork.entity.JobSearchRequest;
import com.ruzzyfer.lookingwork.entity.JobSearchResponse;
import com.ruzzyfer.lookingwork.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobSearchServiceImpl implements JobSearchService{

    private final ExternalDataService externalDataService;

    private final KafkaProducer kafkaProducer;

    public JobSearchServiceImpl(ExternalDataService externalDataService, KafkaProducer kafkaProducer) {
        this.externalDataService = externalDataService;
        this.kafkaProducer = kafkaProducer;
    }

    @Override
    public JobSearchResponse searchJob(JobSearchRequest request) {
        JobSearchResponse response = externalDataService.fetchDataFromExternalSource(
                request.getJobTitle(), request.getExperienceYears(), request.getJobType());

        // Kafka üzerinden asenkron olarak kullanıcıya iletim
        kafkaProducer.sendMessage(response);

        return response;
    }
}
