package com.afalenkin.protobufconsumer.service;

import com.afalenkin.protobufmodel.dto.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
@Service
@Slf4j
public class ProtoStorageService {
    private final Map<Long, Person> storage = new ConcurrentHashMap<>();
    private final AtomicLong dummyIdGenerator = new AtomicLong(0);

    public void store(Person person) {
        log.info("CREATING {}", person);
        storage.put(dummyIdGenerator.incrementAndGet(), person);
    }

    public Person findById(Long id) {
        log.info("GET {}", id);
        return storage.get(id);
    }
}
