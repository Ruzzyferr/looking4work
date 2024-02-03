package com.ruzzyfer.lookingwork.kafka;

import com.ruzzyfer.lookingwork.entity.JobSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private static final String TOPIC = "job-search-topic";

    @Autowired
    private KafkaTemplate<String, JobSearchResponse> kafkaTemplate;

    public void sendMessage(JobSearchResponse response) {
        kafkaTemplate.send(TOPIC, response);
    }

}
