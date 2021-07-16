package com.paypal.bfs.test.bookingserv.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.times;

import java.text.ParseException;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.paypal.bfs.test.bookingserv.entities.IdempotenceTokenEntity;
import com.paypal.bfs.test.bookingserv.repository.IdempotenceTokenRepository;

@RunWith(MockitoJUnitRunner.class)
public class IdempotenceTokenServiceTest {

	@InjectMocks
	private IdempotenceTokenService idempotenceTokenService;

	@Mock
	private IdempotenceTokenRepository idempotenceTokenRepository;

	@Test
	public void testGetEntity() throws ParseException {

		IdempotenceTokenEntity idmEntity = new IdempotenceTokenEntity();
		idmEntity.setUuid("12345");
		idmEntity.setBookingId(1);
		Mockito.when(idempotenceTokenRepository.findById("12345")).thenReturn(Optional.of(idmEntity));

		IdempotenceTokenEntity response = idempotenceTokenService.getEntity("12345");

		assertNotNull(response);

		Mockito.verify(idempotenceTokenRepository, times(1)).findById("12345");

	}

	@Test
	public void testGetEntityOfNull() throws ParseException {

		Mockito.when(idempotenceTokenRepository.findById("12345")).thenReturn(Optional.ofNullable(null));

		IdempotenceTokenEntity idmEntity = idempotenceTokenService.getEntity("12345");

		assertNull(idmEntity);
		Mockito.verify(idempotenceTokenRepository, times(1)).findById("12345");

	}

}
