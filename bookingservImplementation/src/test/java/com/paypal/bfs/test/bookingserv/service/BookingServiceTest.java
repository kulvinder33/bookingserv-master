package com.paypal.bfs.test.bookingserv.service;

import static org.mockito.Mockito.times;

import java.text.ParseException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.paypal.bfs.test.bookingserv.entities.BookingEntity;
import com.paypal.bfs.test.bookingserv.entities.IdempotenceTokenEntity;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;
import com.paypal.bfs.test.bookingserv.utils.MockDataGeneratorUtility;

@RunWith(MockitoJUnitRunner.class)
public class BookingServiceTest {

	@InjectMocks
	private BookingService bookingService;

	@Mock
	private BookingRepository bookingRepository;

	@Mock
	private IdempotenceTokenService idempotenceTokenService;

	@Test
	public void testStoreNewEntity() throws ParseException {

		IdempotenceTokenEntity idmEntity = new IdempotenceTokenEntity();
		idmEntity.setUuid("12345");
		BookingEntity entity = MockDataGeneratorUtility.generateBookingEntity();
		Mockito.when(bookingRepository.save(entity)).thenReturn(entity);
		Mockito.when(idempotenceTokenService.save(idmEntity)).thenReturn(idmEntity);

		bookingService.storeNewEntity(entity, idmEntity);

		Mockito.verify(idempotenceTokenService, times(1)).save(idmEntity);
		Mockito.verify(bookingRepository, times(1)).save(entity);

	}

}
