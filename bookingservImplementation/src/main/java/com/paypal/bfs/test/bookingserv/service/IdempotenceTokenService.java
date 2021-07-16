package com.paypal.bfs.test.bookingserv.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.bfs.test.bookingserv.entities.IdempotenceTokenEntity;
import com.paypal.bfs.test.bookingserv.repository.BaseRepository;
import com.paypal.bfs.test.bookingserv.repository.IdempotenceTokenRepository;

/**
 * This service extends {@link BaseService} and provides the implementation
 * specific to {@link IdempotenceTokenEntity}
 */
@Service
public class IdempotenceTokenService implements BaseService<IdempotenceTokenEntity, String> {

	@Autowired
	private IdempotenceTokenRepository idempotenceTokenRepository;

	@Override
	public BaseRepository<IdempotenceTokenEntity, String> getRepository() {
		return idempotenceTokenRepository;
	}

	/**
	 * This token method can be used to generate the token for new request before
	 * any POST request so that idempotency can be achieved
	 */
	public IdempotenceTokenEntity generateToken() {
		// Appending the time in millis to current UUID random token so that hash
		// collision does not occur
		String token = UUID.randomUUID().toString() + System.currentTimeMillis();
		IdempotenceTokenEntity entity = new IdempotenceTokenEntity();
		entity.setUuid(token);
		return entity;
	}

	public IdempotenceTokenEntity getEntity(String uuid) {
		Optional<IdempotenceTokenEntity> entity = getRepository().findById(uuid);
		if (entity.isPresent())
			return entity.get();
		else
			return null;
	}

}
