package com.paypal.bfs.test.bookingserv.exceptionhandler;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.context.request.WebRequest;

import com.paypal.bfs.test.bookingserv.models.ErrorMessage;

@RunWith(MockitoJUnitRunner.class)
public class GlobalExceptionHandlerTest {

	@InjectMocks
	private GlobalExceptionHandler exceptionHandler;

	@Mock
	private WebRequest request;

	@Test
	public void testConstraintViolationException() {

		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setMessage("Error occurred while serializing/de-serializing an object.");
		errorMessage.setErrorDetails("No Serializer found for this type.");

		IllegalArgumentException illegalArgumentException = new IllegalArgumentException(
				"No Serializer found for this type.");
		ErrorMessage output = exceptionHandler.illegalArgumentException(illegalArgumentException, request);

		assertEquals(errorMessage.getMessage(), output.getMessage());
		assertEquals(errorMessage.getErrorDetails(), output.getErrorDetails());
	}

	@Test
	public void testGenericException() {

		ErrorMessage errorMessage = new ErrorMessage();
		errorMessage.setMessage("Error occurred while processing request. Please try again after some time.");
		errorMessage.setErrorDetails("IO Resource not found");

		IOException ioException = new IOException("IO Resource not found");
		ErrorMessage output = exceptionHandler.genericException(ioException, request);

		assertEquals(errorMessage.getMessage(), output.getMessage());
		assertEquals(errorMessage.getErrorDetails(), output.getErrorDetails());
	}

}
