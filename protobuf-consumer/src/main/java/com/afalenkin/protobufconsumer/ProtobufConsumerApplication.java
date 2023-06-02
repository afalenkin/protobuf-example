package com.afalenkin.protobufconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;

@SpringBootApplication
public class ProtobufConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProtobufConsumerApplication.class, args);
	}

}
