package com.example.reactive.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveApplication {

	static final String REMOTE_API_URL = "https://jsonplaceholder.typicode.com";

	public static void main(String[] args) {
		SpringApplication.run(ReactiveApplication.class, args);
	}

}
