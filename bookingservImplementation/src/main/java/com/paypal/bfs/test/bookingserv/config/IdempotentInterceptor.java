package com.paypal.bfs.test.bookingserv.config;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.servlet.HandlerInterceptor;

import com.paypal.bfs.test.bookingserv.entities.IdempotenceTokenEntity;
import com.paypal.bfs.test.bookingserv.service.IdempotenceTokenService;
import com.paypal.bfs.test.bookingserv.threadlocalcontext.ThreadLocalContext;

/**
 * Custom IdempotentInterceptor which intercepts any request and if the request
 * matches the POST method then tries to find the TokenEntity stored for
 * "Idempotency-Key" (in request headers) in the database. If an entity is found
 * then the entity is set in thread local context and accessed in the controller
 * layer
 */
@Component
public class IdempotentInterceptor implements HandlerInterceptor {

	@Autowired
	private IdempotenceTokenService idempotenceTokenService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (request.getMethod().equals("POST")) {
			String token = request.getHeader("Idempotency-Key");
			if (Objects.nonNull(token)) {
				IdempotenceTokenEntity entity = idempotenceTokenService.getEntity(token);
				if (Objects.nonNull(entity)) {
					// Using thread local to store the current idempotency entity if found
					ThreadLocalContext.setContext(entity);
				} else {
					IdempotenceTokenEntity newIdempotencyEntity = new IdempotenceTokenEntity();
					newIdempotencyEntity.setUuid(token);
					ThreadLocalContext.setContext(newIdempotencyEntity);
				}
			} else {
				throw new ServletRequestBindingException(
						"'Idempotency-Key' is not present in request headers for POST request.");
			}

		}
		return true;
	}
}
