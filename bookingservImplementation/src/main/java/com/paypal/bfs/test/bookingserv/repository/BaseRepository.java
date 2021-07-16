package com.paypal.bfs.test.bookingserv.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Base Repository for all entity types
 * 
 * @param <E> represents Entity Type
 * @param <I> represents Id Type
 */
@NoRepositoryBean
public interface BaseRepository<E, I> extends JpaRepository<E, I> {

}
