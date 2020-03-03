package com.sohrab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;

@SpringBootApplication
public class Microservice4Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice4Application.class, args);
	}

	@RestController
	class Microservice4Controller {

		private final Logger LOG = LoggerFactory.getLogger(this.getClass());

		@Autowired
		RestTemplate restTemplate;

		@Bean
		public RestTemplate getRestTemplate() {
			return new RestTemplate();
		}

		@Bean
		public Sampler defaultSampler() {
			return Sampler.ALWAYS_SAMPLE;
		}

		@GetMapping(value = "/microservice4")
		public String method1() {

			LOG.info("Inside method4");
			return "hello from microservices 4 :)";
		}
	}
}