package com.paypal.bfs.test.bookingserv.models;

import lombok.Data;

/**
 * Error Message Model to be used to return Error Responses
 */
@Data
public class ErrorMessage {

	private String message;

	private String errorDetails;

}
