package com.paypal.bfs.test.bookingserv.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class BookingAppConfigurationTest {

	@InjectMocks
	private BookingAppConfiguration config;
	
	@Test
	public void testObjectMapperBean() {
		ObjectMapper mapper = config.objectMapper();
		assertNotNull(mapper);
		assertEquals(ObjectMapper.class, mapper.getClass());
	}
	
}
