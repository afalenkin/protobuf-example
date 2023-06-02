package com.afalenkin.protobufsender.mapper;

import com.afalenkin.protobufmodel.dto.Pet;
import com.afalenkin.protobufsender.dto.PetDto;
import org.springframework.stereotype.Service;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
@Service
public class PetMapper {
    public Pet map(PetDto petDto) {
        return Pet.newBuilder()
                .setName(petDto.name())
                .setAge(petDto.age())
                .setType(Pet.Type.valueOf(petDto.type()))
                .build();
    }

    public PetDto map(Pet pet) {
        return PetDto.builder()
                .age(pet.getAge())
                .name(pet.getName())
                .type(pet.getType().name())
                .build();
    }
}
