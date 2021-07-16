package com.paypal.bfs.test.bookingserv.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.entities.BookingEntity;
import com.paypal.bfs.test.bookingserv.entities.IdempotenceTokenEntity;
import com.paypal.bfs.test.bookingserv.mapper.EntityRequestMapper;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import com.paypal.bfs.test.bookingserv.threadlocalcontext.ThreadLocalContext;
import com.paypal.bfs.test.bookingserv.utils.MockDataGeneratorUtility;

@RunWith(MockitoJUnitRunner.class)
public class BookingResourceImplTest {

	@InjectMocks
	private BookingResourceImpl bookingResource;

	@Mock
	private EntityRequestMapper mapper;

	@Mock
	private BookingService bookingService;

	@Test
	public void createTest() throws ParseException {

		Booking bookingInput = MockDataGeneratorUtility.generateInputData();
		BookingEntity entity = MockDataGeneratorUtility.generateBookingEntity();
		Booking bookingResponse = MockDataGeneratorUtility.generateResponse();
		IdempotenceTokenEntity idmEntity = new IdempotenceTokenEntity();
		idmEntity.setUuid("12345");
		ThreadLocalContext.setContext(idmEntity);
		Mockito.when(mapper.convertObject(bookingInput, BookingEntity.class)).thenReturn(entity);
		Mockito.when(bookingService.storeNewEntity(entity, idmEntity)).thenReturn(entity);
		Mockito.when(mapper.convertObject(entity, Booking.class)).thenReturn(bookingResponse);
		ResponseEntity<Booking> response = bookingResource.create(bookingInput);

		Mockito.verify(mapper, times(1)).convertObject(bookingInput, BookingEntity.class);
		Mockito.verify(mapper, times(1)).convertObject(entity, Booking.class);
		Mockito.verify(bookingService, times(1)).storeNewEntity(entity, idmEntity);

		assertEquals(201, response.getStatusCodeValue());
		assertEquals(bookingResponse, response.getBody());

		ThreadLocalContext.clearContext();

	}

	@Test
	public void createTestWithoutContext() throws ParseException {

		Booking bookingInput = MockDataGeneratorUtility.generateInputData();
		BookingEntity entity = MockDataGeneratorUtility.generateBookingEntity();
		Booking bookingResponse = MockDataGeneratorUtility.generateResponse();
		IdempotenceTokenEntity idmEntity = new IdempotenceTokenEntity();
		idmEntity.setUuid("12345");
		idmEntity.setBookingId(1);
		ThreadLocalContext.setContext(idmEntity);
		Mockito.when(bookingService.findById(1)).thenReturn(Optional.of(entity));
		Mockito.when(mapper.convertObject(entity, Booking.class)).thenReturn(bookingResponse);
		ResponseEntity<Booking> response = bookingResource.create(bookingInput);

		Mockito.verify(mapper, times(1)).convertObject(entity, Booking.class);
		Mockito.verify(bookingService, times(1)).findById(1);

		assertEquals(201, response.getStatusCodeValue());
		assertEquals(bookingResponse, response.getBody());

		ThreadLocalContext.clearContext();

	}

	@Test
	public void getAllTest() throws ParseException {
		BookingEntity entity = MockDataGeneratorUtility.generateBookingEntity();
		List<BookingEntity> entities = new ArrayList<>();
		entities.add(entity);

		Booking bookingResponse = MockDataGeneratorUtility.generateResponse();
		Mockito.when(bookingService.findAll()).thenReturn(entities);
		Mockito.when(mapper.convertObject(entity, Booking.class)).thenReturn(bookingResponse);
		ResponseEntity<List<Booking>> response = bookingResource.getAll();

		Mockito.verify(mapper, times(1)).convertObject(entity, Booking.class);
		Mockito.verify(bookingService, times(1)).findAll();

		assertEquals(200, response.getStatusCodeValue());
		assertEquals(bookingResponse, response.getBody().get(0));

	}

}
