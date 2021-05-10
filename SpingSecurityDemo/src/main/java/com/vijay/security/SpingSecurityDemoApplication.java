package com.vijay.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpingSecurityDemoApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
		return applicationBuilder.sources(SpingSecurityDemoApplication.class);
	}

	private static final Logger LOGGER = LoggerFactory.getLogger(SpingSecurityDemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpingSecurityDemoApplication.class, args);
		LOGGER.info("info");
		LOGGER.debug("debug");
		LOGGER.warn("warn");

		LOGGER.error("mainMethod is Started");
		
	}

	

}
