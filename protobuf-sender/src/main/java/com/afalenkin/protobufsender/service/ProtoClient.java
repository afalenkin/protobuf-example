package com.afalenkin.protobufsender.service;

import com.afalenkin.protobufmodel.dto.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
@RequiredArgsConstructor
@Service
public class ProtoClient {
    private final RestTemplate restTemplate;

    @Value("${consumer.url}")
    private String consumerUrl;

    public ResponseEntity send(Person person) {
        return restTemplate.postForEntity(consumerUrl, person, ResponseEntity.class);
    }


    public Optional<Person> get(Long id) {
        String url = consumerUrl + "/" + id;
        return Optional.ofNullable(restTemplate.getForEntity(url, Person.class).getBody());
    }
}
