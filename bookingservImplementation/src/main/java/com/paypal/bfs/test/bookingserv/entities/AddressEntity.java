package com.paypal.bfs.test.bookingserv.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * {@link AddressEntity} entity for storing in DB in relation to BookingEntity
 *
 */
@Entity
@Table(name = "address")
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class AddressEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id", updatable = false, nullable = false)
	private Integer id;

	@Column(nullable = false)
	@NotNull
	private String line1;

	private String line2;

	@Column(nullable = false)
	@NotNull
	private String city;

	@Column(nullable = false)
	@NotNull
	private String state;

	@Column(nullable = false)
	@NotNull
	private String country;

	@Column(nullable = false)
	@NotNull
	private Integer zipCode;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLine1() {
		return line1;
	}

	public void setLine1(String line1) {
		this.line1 = line1;
	}

	public String getLine2() {
		return line2;
	}

	public void setLine2(String line2) {
		this.line2 = line2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

}
