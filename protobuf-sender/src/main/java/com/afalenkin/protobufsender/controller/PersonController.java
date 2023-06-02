package com.afalenkin.protobufsender.controller;

import com.afalenkin.protobufsender.dto.PersonDto;
import com.afalenkin.protobufsender.mapper.PersonMapper;
import com.afalenkin.protobufsender.service.ProtoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonMapper personMapper;
    private final ProtoClient protoClient;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createProtobufAndSend(@RequestBody PersonDto personDto) {
         return protoClient.send(personMapper.map(personDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getById(@PathVariable("id") Long id) {
        return protoClient.get(id)
                .map(personMapper::map)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}