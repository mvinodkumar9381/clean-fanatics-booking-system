package com.cleanfanatics.service;

import com.cleanfanatics.model.*;
import com.cleanfanatics.repository.BookingRepository;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class BookingService {

    private final BookingRepository repository = new BookingRepository();
    private final AtomicLong idGenerator = new AtomicLong(1);

    public Booking createBooking(String customer, String serviceType) {
        Booking booking = new Booking(
                idGenerator.getAndIncrement(),
                customer,
                serviceType
        );
        return repository.save(booking);
    }

    public Booking assignProvider(Long id, String provider) {
        Booking booking = getBooking(id);
        if (booking.getStatus() != BookingStatus.PENDING) {
            throw new IllegalStateException("Booking must be PENDING");
        }
        booking.setProviderName(provider);
        booking.setStatus(BookingStatus.ASSIGNED);
        return booking;
    }

    public Booking startService(Long id) {
        Booking booking = getBooking(id);
        if (booking.getStatus() != BookingStatus.ASSIGNED) {
            throw new IllegalStateException("Booking must be ASSIGNED");
        }
        booking.setStatus(BookingStatus.IN_PROGRESS);
        return booking;
    }

    public Booking completeService(Long id) {
        Booking booking = getBooking(id);
        if (booking.getStatus() != BookingStatus.IN_PROGRESS) {
            throw new IllegalStateException("Booking must be IN_PROGRESS");
        }
        booking.setStatus(BookingStatus.COMPLETED);
        return booking;
    }

    public Booking cancelBooking(Long id) {
        Booking booking = getBooking(id);
        booking.setStatus(BookingStatus.CANCELLED_BY_CUSTOMER);
        return booking;
    }

    public List<Booking> getAllBookings() {
        return repository.findAll();
    }

    private Booking getBooking(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }
}
