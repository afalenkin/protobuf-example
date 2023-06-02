package com.afalenkin.protobufsender.mapper;

import com.afalenkin.protobufmodel.dto.Gender;
import com.afalenkin.protobufmodel.dto.Person;
import com.afalenkin.protobufmodel.dto.Pet;
import com.afalenkin.protobufsender.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
@Service
@RequiredArgsConstructor
public class PersonMapper {
    private final PetMapper petMapper;
    private final DocumentMapper documentMapper;

    public Person map(PersonDto personDto) {
        return Person.newBuilder()
                .setFirstName(personDto.firstName())
                .setLastName(personDto.lastName())
                .setAge(personDto.age())
                .setGender(Gender.valueOf(personDto.gender()))
                .setWeight(personDto.weight())
                .addAllDocuments(personDto.documents().stream()
                        .map(documentMapper::map)
                        .toList())
                .addAllChilds(personDto.childs().stream().map(this::map).toList())
                .putAllPets(personDto.pets().stream()
                        .map(petMapper::map)
                        .collect(Collectors.toMap(Pet::getName, Function.identity())))
                .build();
    }

    public PersonDto map(Person person) {
        return PersonDto.builder()
                .age(person.getAge())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .gender(person.getGender().name())
                .weight(person.getWeight())
                .documents(person.getDocumentsList().stream().map(documentMapper::map).toList())
                .childs(person.getChildsList().stream().map(this::map).toList())
                .pets(person.getPetsMap().values().stream().map(petMapper::map).toList())
                .build();
    }
}
