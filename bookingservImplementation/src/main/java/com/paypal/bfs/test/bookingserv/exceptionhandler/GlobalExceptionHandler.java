package com.paypal.bfs.test.bookingserv.exceptionhandler;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.paypal.bfs.test.bookingserv.constants.BookingServErrorEnums;
import com.paypal.bfs.test.bookingserv.models.ErrorMessage;

import lombok.extern.slf4j.Slf4j;

/**
 * Global Exception Handler which is invoked whenever an exception occurs in the
 * application. This class maps the exceptions occurred and maps the relevant
 * information to the {@link ErrorMessage} model and returns the error messages
 * with appropriate HTTP response code.
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	@ExceptionHandler(value = { ConstraintViolationException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorMessage constraintViolationException(ConstraintViolationException ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage();
		message.setMessage(BookingServErrorEnums.CONSTRAINT_VIOLATION_MESSAGE.getMessage());
		message.setErrorDetails(ex.getMessage());

		log.error("Constraint Violation Error ocurred :: ", ex);

		return message;
	}

	@ExceptionHandler(value = { ServletRequestBindingException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorMessage servletRequestBindingException(ServletRequestBindingException ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage();
		message.setMessage(BookingServErrorEnums.INPUT_VALIDATION_FAILED_MESSAGE.getMessage());
		message.setErrorDetails(ex.getMessage());

		log.error("Servlet Request Binding Exception ocurred :: ", ex);

		return message;
	}

	@ExceptionHandler(value = { IllegalArgumentException.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage illegalArgumentException(IllegalArgumentException ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage();
		message.setMessage(BookingServErrorEnums.ILLEGAL_ARGUMENT_EXCEPTION.getMessage());
		message.setErrorDetails(ex.getMessage());

		log.error("Illegal argument exception has occurred :: ", ex);

		return message;
	}

	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorMessage inputValidationException(MethodArgumentNotValidException ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage();
		message.setMessage(BookingServErrorEnums.INPUT_VALIDATION_FAILED_MESSAGE.getMessage());
		message.setErrorDetails(ex.getMessage());

		log.error("Input Validation Error ocurred :: ", ex);

		return message;
	}

	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage genericException(Exception ex, WebRequest request) {
		ErrorMessage message = new ErrorMessage();
		message.setMessage(BookingServErrorEnums.GENERIC_EXCEPTION_MESSAGE.getMessage());
		message.setErrorDetails(ex.getMessage());

		log.error("Error ocurred :: ", ex);

		return message;
	}

}
