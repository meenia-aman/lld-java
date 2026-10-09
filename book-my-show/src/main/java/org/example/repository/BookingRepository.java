package org.example.repository;

import org.example.models.Booking;

/**
 * BookingRepository
 */
public interface BookingRepository {
    Booking create(Booking b);
    Booking update(Booking b);
}
