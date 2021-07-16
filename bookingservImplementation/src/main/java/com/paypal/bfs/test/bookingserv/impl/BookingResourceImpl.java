package com.paypal.bfs.test.bookingserv.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.bookingserv.api.BookingResource;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.entities.BookingEntity;
import com.paypal.bfs.test.bookingserv.entities.IdempotenceTokenEntity;
import com.paypal.bfs.test.bookingserv.mapper.EntityRequestMapper;
import com.paypal.bfs.test.bookingserv.service.BookingService;
import com.paypal.bfs.test.bookingserv.threadlocalcontext.ThreadLocalContext;

import lombok.extern.slf4j.Slf4j;

/**
 * Implementation of BookingResource. This class provides the implementation of
 * the controller mappings declared in {@link BookingResource}. All endpoints
 * exposed the wrap the response object in response entity and return the object
 * with HTTP status code
 */
@RestController
@Slf4j
public class BookingResourceImpl implements BookingResource {

	@Autowired
	private EntityRequestMapper mapper;

	@Autowired
	private BookingService bookingService;

	@Override
	public ResponseEntity<Booking> create(Booking booking) {

		// Reading Thread local context to check if any previous idempotence token with
		// booking id was stored or not
		IdempotenceTokenEntity idemEnt = ThreadLocalContext.getContext();
		BookingEntity responseEntity = null;
		if (Objects.nonNull(idemEnt.getBookingId())) {
			Integer bookingId = idemEnt.getBookingId();
			responseEntity = bookingService.findById(bookingId).get();
		} else {
			log.debug("Starting object conversion");
			BookingEntity entity = mapper.convertObject(booking, BookingEntity.class);
			responseEntity = bookingService.storeNewEntity(entity, idemEnt);
		}

		ThreadLocalContext.clearContext();
		return new ResponseEntity<>(mapper.convertObject(responseEntity, Booking.class), HttpStatus.CREATED);

	}

	@Override
	public ResponseEntity<List<Booking>> getAll() {

		log.info("Fetching all entities from DB");
		List<BookingEntity> entities = bookingService.findAll();
		log.debug("Entities Fetched. Creating Response : {}", entities.size());
		List<Booking> bookings = entities.stream().map(entity -> mapper.convertObject(entity, Booking.class))
				.collect(Collectors.toList());

		log.info("Returning Response of size : {}", bookings.size());

		return new ResponseEntity<>(bookings, HttpStatus.OK);

	}
}
