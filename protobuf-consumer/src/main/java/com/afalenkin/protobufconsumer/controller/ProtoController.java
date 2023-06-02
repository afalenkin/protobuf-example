package com.afalenkin.protobufconsumer.controller;

import com.afalenkin.protobufconsumer.service.ProtoStorageService;
import com.afalenkin.protobufmodel.dto.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
@RestController
@RequestMapping("/proto")
@RequiredArgsConstructor
public class ProtoController {
    private final ProtoStorageService protoStorageService;

    @PostMapping(consumes = "application/x-protobuf")
    public ResponseEntity store(@RequestBody Person person) {
        protoStorageService.store(person);
        return ResponseEntity.ok().build();
    }

    @GetMapping(value = "/{id}", produces = "application/x-protobuf")
    public ResponseEntity<Person> get(@PathVariable Long id) {
        return ResponseEntity.ok(protoStorageService.findById(id));
    }
}
