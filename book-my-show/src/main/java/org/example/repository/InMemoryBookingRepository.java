package org.example.repository;

import java.util.HashMap;
import java.util.Map;
import org.example.models.Booking;

/**
 * InMemoryBookingRepository
 */
public class InMemoryBookingRepository implements BookingRepository {

    private Map<String, Booking> bookings = new HashMap<>();

    @Override
    public Booking create(Booking b) {
        bookings.put(b.getId(), b);
        return b;
    }

    @Override
    public Booking update(Booking b) {
        bookings.put(b.getId(), b);
        return b;
    }
}
