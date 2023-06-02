package com.afalenkin.protobufsender.dto;

import lombok.Builder;

import java.util.List;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
@Builder
public record PersonDto(String firstName,
                        String lastName,
                        Integer age,
                        String gender,
                        Double weight,
                        List<DocumentDto> documents,
                        List<PersonDto> childs,
                        List<PetDto> pets) {
}
