package com.paypal.bfs.test.bookingserv.mapper;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.entities.BookingEntity;
import com.paypal.bfs.test.bookingserv.utils.MockDataGeneratorUtility;

@RunWith(MockitoJUnitRunner.class)
public class EntityRequestMapperTest {

	@InjectMocks
	private EntityRequestMapper requestMapper;

	private ObjectMapper mapper;

	@Test
	public void mapperTest() throws ParseException {

		mapper = new ObjectMapper();
		mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));

		requestMapper = new EntityRequestMapper(mapper);

		Booking bookingInput = MockDataGeneratorUtility.generateInputData();
		BookingEntity entity = MockDataGeneratorUtility.generateBookingEntity();
		BookingEntity output = requestMapper.convertObject(bookingInput, BookingEntity.class);

		assertEquals(entity.getFirstName(), output.getFirstName());
		assertEquals(entity.getLastName(), output.getLastName());
		assertEquals(entity.getDeposit(), output.getDeposit());
		assertEquals(entity.getTotalPrice(), output.getTotalPrice());
	}

}
