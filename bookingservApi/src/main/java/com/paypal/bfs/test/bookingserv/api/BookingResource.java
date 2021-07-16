package com.paypal.bfs.test.bookingserv.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.paypal.bfs.test.bookingserv.api.model.Booking;

public interface BookingResource {
	/**
	 * Create {@link Booking} resource
	 *
	 * @param booking the booking object
	 * @return the created booking
	 */
	@PostMapping("/v1/bfs/booking")
	ResponseEntity<Booking> create(@Valid @RequestBody Booking booking);

	// ----------------------------------------------------------
	// TODO - add a new operation for Get All the bookings resource.
	// ----------------------------------------------------------

	/**
	 * Get all {@link Booking} resources Stored in database
	 * 
	 * @return List of {@link Booking} elements
	 */
	@GetMapping("/v1/bfs/booking")
	ResponseEntity<List<Booking>> getAll();
}
