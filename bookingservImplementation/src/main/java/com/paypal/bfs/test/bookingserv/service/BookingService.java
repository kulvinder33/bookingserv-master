package com.paypal.bfs.test.bookingserv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.paypal.bfs.test.bookingserv.entities.BookingEntity;
import com.paypal.bfs.test.bookingserv.entities.IdempotenceTokenEntity;
import com.paypal.bfs.test.bookingserv.repository.BaseRepository;
import com.paypal.bfs.test.bookingserv.repository.BookingRepository;

/**
 * BookingService extends {@link BaseService}. It provides implementation to
 * BaseService specific to {@link BookingEntity}
 */
@Service
public class BookingService implements BaseService<BookingEntity, Integer> {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private IdempotenceTokenService idempotenceTokenService;

	@Override
	public BaseRepository<BookingEntity, Integer> getRepository() {
		return bookingRepository;
	}

	/**
	 * This method stores the new {@link BookingEntity} in database and also stores
	 * the related {@link IdempotenceTokenEntity} after the {@link BookingEntity}
	 * has been stored.
	 * 
	 * @param entity    - {@link BookingEntity}
	 * @param idmEntity - {@link IdempotenceTokenEntity}
	 * @return {@link BookingEntity}
	 */
	@Transactional(propagation = Propagation.REQUIRED)
	public BookingEntity storeNewEntity(BookingEntity entity, IdempotenceTokenEntity idmEntity) {
		entity = this.save(entity);
		idmEntity.setBookingId(entity.getId());
		idempotenceTokenService.save(idmEntity);
		return entity;
	}

}
