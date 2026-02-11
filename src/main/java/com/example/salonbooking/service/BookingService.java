package com.example.salonbooking.service;

import com.example.salonbooking.entity.Booking;
import com.example.salonbooking.entity.Booking.BookingStatus;
import com.example.salonbooking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Long id) {
        return bookingRepository.findById(id);
    }

    public List<Booking> getBookingsByCustomerId(Long customerId) {
        return bookingRepository.findByCustomerCustomerId(customerId);
    }

    public List<Booking> getBookingsByStatus(BookingStatus status) {
        return bookingRepository.findByStatus(status);
    }

    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Long id, Booking booking) {
        Booking existing = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        existing.setCustomer(booking.getCustomer());
        existing.setService(booking.getService());
        existing.setBookingDateTime(booking.getBookingDateTime());
        existing.setNotes(booking.getNotes());
        existing.setStatus(booking.getStatus());
        return bookingRepository.save(existing);
    }

    public Booking updateBookingStatus(Long id, BookingStatus status) {
        Booking existing = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
        existing.setStatus(status);
        return bookingRepository.save(existing);
    }

    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}
