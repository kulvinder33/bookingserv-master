package com.paypal.bfs.test.bookingserv.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.paypal.bfs.test.bookingserv.api.model.Address;
import com.paypal.bfs.test.bookingserv.api.model.Booking;
import com.paypal.bfs.test.bookingserv.entities.AddressEntity;
import com.paypal.bfs.test.bookingserv.entities.BookingEntity;

public class MockDataGeneratorUtility {

	public static Booking generateInputData() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Booking input = new Booking();
		input.setFirstName("kulvinder");
		input.setLastName("singh");
		input.setTotalPrice(1000);
		input.setDeposit(500);
		input.setDateOfBirth(format.parse("1994-10-10"));
		input.setCheckin(format.parse("2020-12-20"));
		input.setCheckout(format.parse("2020-12-21"));

		Address address = new Address();
		address.setCity("karnal");
		address.setState("Haryana");
		address.setCountry("India");
		address.setLine1("H. no. 16");
		address.setZipCode(132001);
		input.setAddress(address);

		return input;
	}

	public static BookingEntity generateBookingEntity() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		BookingEntity bookingEntity = new BookingEntity();
		bookingEntity.setFirstName("kulvinder");
		bookingEntity.setLastName("singh");
		bookingEntity.setTotalPrice(1000);
		bookingEntity.setDeposit(500);
		bookingEntity.setDateOfBirth(format.parse("1994-10-10"));
		bookingEntity.setCheckin(format.parse("2020-12-20"));
		bookingEntity.setCheckout(format.parse("2020-12-21"));
		bookingEntity.setId(1);

		AddressEntity address = new AddressEntity();
		address.setId(1);
		address.setCity("karnal");
		address.setState("Haryana");
		address.setCountry("India");
		address.setLine1("H. no. 16");
		address.setZipCode(132001);
		bookingEntity.setAddress(address);

		return bookingEntity;
	}

	public static Booking generateResponse() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

		Booking input = new Booking();
		input.setFirstName("kulvinder");
		input.setLastName("singh");
		input.setTotalPrice(1000);
		input.setDeposit(500);
		input.setDateOfBirth(format.parse("1994-10-10"));
		input.setCheckin(format.parse("2020-12-20"));
		input.setCheckout(format.parse("2020-12-21"));
		input.setId(1);

		Address address = new Address();
		address.setCity("karnal");
		address.setState("Haryana");
		address.setCountry("India");
		address.setLine1("H. no. 16");
		address.setZipCode(132001);
		input.setAddress(address);

		return input;
	}

}
