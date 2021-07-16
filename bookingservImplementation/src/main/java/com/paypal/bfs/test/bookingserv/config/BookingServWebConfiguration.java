package com.paypal.bfs.test.bookingserv.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Custom Web Configuration for registering IdempotentInterceptor
 */
@Configuration
public class BookingServWebConfiguration implements WebMvcConfigurer {

	@Resource
	private IdempotentInterceptor idempotentInterceptor;

	/**
	 * Add interceptor
	 * 
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(idempotentInterceptor);
	}

}
