package org.example.service;

import org.example.enums.BookingStatus;
import org.example.models.Booking;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class BookingService {
    private Map<String, Booking> bookings = new HashMap<>();


    public Booking createBooking(String userId, String carId, String
                                         pickupBranchId, String dropBranchId,
                                 LocalDate pickupDate,
                                 LocalDate returnDate,
                                 double amount) {

        LocalDateTime currentTime = LocalDateTime.now();
        LocalDateTime reservation_expiry_time = currentTime.plusMinutes(5);

        Booking booking = new Booking(userId, carId, pickupBranchId, dropBranchId, pickupDate, returnDate, amount, reservation_expiry_time);
        bookings.put(booking.getId(), booking);
        System.out.println("Car with reg_no " + carId + " reserved for user " + userId + " for 5 minutes");
        return booking;
    }

    public Booking getBookingById(String bookingId) {
        return bookings.getOrDefault(bookingId, null);
    }

    public void updateStatus(String bookingId, BookingStatus status) {
        Booking booking = this.getBookingById(bookingId);
        if (booking == null) {
            System.out.println("No record found for provided bookingId " + bookingId);
            return;
        }

        booking.updateStatus(status);

    }

}
