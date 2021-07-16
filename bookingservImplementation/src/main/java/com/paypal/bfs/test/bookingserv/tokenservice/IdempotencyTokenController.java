package com.paypal.bfs.test.bookingserv.tokenservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.bfs.test.bookingserv.entities.IdempotenceTokenEntity;
import com.paypal.bfs.test.bookingserv.service.IdempotenceTokenService;

@RestController
public class IdempotencyTokenController {

	@Autowired
	private IdempotenceTokenService idempotenceTokenService;

	/**
	 * Get Idempotent token generator controller method This method invokes
	 * {@link IdempotenceTokenService} and generates new token to return in web
	 * response
	 * 
	 * @return {@link IdempotenceTokenEntity}
	 */
	@GetMapping("/v1/bfs/idempotencytoken")
	ResponseEntity<IdempotenceTokenEntity> getToken() {
		return new ResponseEntity<>(idempotenceTokenService.generateToken(), HttpStatus.CREATED);
	}

}
