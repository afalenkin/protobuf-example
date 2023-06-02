package com.afalenkin.protobufsender.dto;

import lombok.Builder;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
@Builder
public record DocumentDto(
        Integer serial,
        Integer number,
        Boolean main
) {
}
