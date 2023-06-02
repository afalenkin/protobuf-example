package com.afalenkin.protobufsender.mapper;

import com.afalenkin.protobufmodel.dto.Document;
import com.afalenkin.protobufsender.dto.DocumentDto;
import org.springframework.stereotype.Service;

/**
 * @author Alenkin Andrew
 * oxqq@ya.ru
 */
@Service
public class DocumentMapper {
    public Document map(DocumentDto documentDto) {
        return Document.newBuilder()
                .setSerial(documentDto.number())
                .setNumber(documentDto.number())
                .setMain(documentDto.main())
                .build();
    }

    public DocumentDto map(Document document) {
        return DocumentDto.builder()
                .serial(document.getSerial())
                .number(document.getNumber())
                .main(document.getMain())
                .build();
    }
}
