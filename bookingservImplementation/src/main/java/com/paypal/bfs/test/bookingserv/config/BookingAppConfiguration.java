package com.paypal.bfs.test.bookingserv.config;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Configuration class to initialize various singleton beans required throughout
 * the application
 *
 */
@Configuration
public class BookingAppConfiguration {

	/**
	 * ObjectMapper Bean to be re-used with custom date configuration
	 * 
	 * @return {@link ObjectMapper} instance
	 */
	@Bean
	public ObjectMapper objectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
		return mapper;
	}

}
