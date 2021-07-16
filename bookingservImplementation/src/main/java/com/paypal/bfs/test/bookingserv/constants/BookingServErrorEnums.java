package com.paypal.bfs.test.bookingserv.constants;

/**
 * Error messages to be shown in response are stored in this enum
 *
 */
public enum BookingServErrorEnums {

	CONSTRAINT_VIOLATION_MESSAGE("Constraint Violation Has Occurred"),

	ILLEGAL_ARGUMENT_EXCEPTION("Error occurred while serializing/de-serializing an object."),

	INPUT_VALIDATION_FAILED_MESSAGE("Input Parameters Provided are invalid. Please check them."),

	GENERIC_EXCEPTION_MESSAGE("Error occurred while processing request. Please try again after some time.");

	private String message;

	BookingServErrorEnums(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}
