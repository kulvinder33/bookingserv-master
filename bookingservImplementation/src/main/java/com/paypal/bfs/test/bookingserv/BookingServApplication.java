package com.paypal.bfs.test.bookingserv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.paypal.bfs.test.bookingserv.entities")
public class BookingServApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookingServApplication.class, args);
    }
}