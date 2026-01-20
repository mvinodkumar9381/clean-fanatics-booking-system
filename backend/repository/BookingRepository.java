package com.cleanfanatics.repository;

import com.cleanfanatics.model.Booking;
import java.util.*;

public class BookingRepository {

    private final Map<Long, Booking> store = new HashMap<>();

    public Booking save(Booking booking) {
        store.put(booking.getId(), booking);
        return booking;
    }

    public Optional<Booking> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public List<Booking> findAll() {
        return new ArrayList<>(store.values());
    }
}
