package com.afalenkin.protobufsender.dto;

import lombok.Builder;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
@Builder
public record PetDto(
        String name,
        Integer age,
        String type
) {
}
