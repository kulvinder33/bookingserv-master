package com.paypal.bfs.test.bookingserv.repository;

import org.springframework.stereotype.Repository;

import com.paypal.bfs.test.bookingserv.entities.IdempotenceTokenEntity;

@Repository
public interface IdempotenceTokenRepository extends BaseRepository<IdempotenceTokenEntity, String> {

}
