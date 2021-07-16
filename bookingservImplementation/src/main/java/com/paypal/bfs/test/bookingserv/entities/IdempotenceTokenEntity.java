package com.paypal.bfs.test.bookingserv.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "idempotence_token")
@Getter
@Setter
public class IdempotenceTokenEntity {

	@Id
	private String uuid;

	private Integer bookingId;

}
