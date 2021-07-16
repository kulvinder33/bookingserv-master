package com.paypal.bfs.test.bookingserv.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class converts one object type to another. It maps the properties with
 * same name of one object to another and creates instance of new Object.
 * 
 * Typically, this is being used for mapping from Post request resource to
 * Entity and vice-versa.
 * 
 */
@Component
public class EntityRequestMapper {

	private ObjectMapper objectMapper;

	@Autowired
	public EntityRequestMapper(ObjectMapper objectMapper) {
		this.objectMapper = objectMapper;
	}

	/**
	 * @param <T> - Object Type to convert into
	 * @param <U> - Object Type to convert from
	 * @return - T Object instance after conversion
	 */
	public <T, U> T convertObject(U object, Class<T> className) {

		T value = objectMapper.convertValue(object, className);
		return value;
	}

}
