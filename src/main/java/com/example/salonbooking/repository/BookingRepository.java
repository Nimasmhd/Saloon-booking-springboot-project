package com.example.salonbooking.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.salonbooking.entity.Booking;
import com.example.salonbooking.entity.Booking.BookingStatus;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
	List<Booking> findByCustomerCustomerId(Long customerId);
    List<Booking> findByStatus(BookingStatus status);
    List<Booking> findByBookingDateTimeBetween(LocalDateTime start, LocalDateTime end);
}
