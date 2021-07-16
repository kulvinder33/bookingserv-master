package com.paypal.bfs.test.bookingserv.service;

import java.util.List;
import java.util.Optional;

import com.paypal.bfs.test.bookingserv.repository.BaseRepository;

/**
 * Base Service which is used as a base class for all services. It also provides
 * the default implementations for certain methods
 * 
 * @param <E> - Entity Type
 * @param <I> - Id Type of Entity
 */
public interface BaseService<E, I> {

	public BaseRepository<E, I> getRepository();

	default public List<E> findAll() {
		return getRepository().findAll();
	}

	default public E save(E entity) {
		return getRepository().save(entity);
	}

	default public Optional<E> findById(I id) {
		return getRepository().findById(id);
	}

}
