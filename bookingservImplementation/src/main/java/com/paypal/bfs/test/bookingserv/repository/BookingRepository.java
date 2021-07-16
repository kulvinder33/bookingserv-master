package com.paypal.bfs.test.bookingserv.repository;

import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.bookingserv.entities.BookingEntity;

@Repository
public interface BookingRepository extends BaseRepository<BookingEntity, Integer> {

}
