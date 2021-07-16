package com.paypal.bfs.test.bookingserv.threadlocalcontext;

import com.paypal.bfs.test.bookingserv.entities.IdempotenceTokenEntity;

public class ThreadLocalContext {

	protected static ThreadLocal<IdempotenceTokenEntity> idempotencyContext = new ThreadLocal<>();

	public static void setContext(IdempotenceTokenEntity entity) {
		idempotencyContext.set(entity);
	}

	public static IdempotenceTokenEntity getContext() {
		return idempotencyContext.get();
	}

	public static void clearContext() {
		idempotencyContext.remove();
	}

}
