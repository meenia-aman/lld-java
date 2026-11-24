package org.example.services;

import org.example.enums.BookingStatus;
import org.example.models.Booking;
import org.example.models.ShowSeat;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class BookingService {
    private Map<String, Booking> bookings = new HashMap<>();
    private ShowService showService;

    public BookingService(ShowService showService) {
        this.showService = showService;
    }

    public Booking createBooking(String id, String showId,
                                 String userId, List<ShowSeat> showSeats) {
        double amount = 0;
        for (int i = 0; i < showSeats.size(); i++) {
            amount += showSeats.get(i).getAmount();
        }
        if (!showService.reserveSeat(showId, showSeats)) {
            return null;
        }
        Booking booking = new Booking(id, showId, userId, amount, BookingStatus.PENDING, showSeats);
        bookings.put(booking.getId(), booking);
        System.out.println("Seats reserved successfully");

        for (int i = 0; i < showSeats.size(); i++) {
            System.out.println("Reserving seat with Id " + showSeats.get(i).getId());
        }
        return booking;
    }

    public Booking updateBooking(String bookingId, BookingStatus bookingStatus) {
        Booking booking = this.bookings.getOrDefault(bookingId, null);
        if (booking == null) {
            System.out.println("Please enter the correct bookingId");
            return null;
        }
        booking.setBookingStatus(bookingStatus);
        System.out.println("Seats Booked successfully");

        List<ShowSeat> showSeats = booking.getShowSeats();

        for (int i = 0; i < showSeats.size(); i++) {
            System.out.println("Reserving seat with Id " + showSeats.get(i).getId());
        }

        return booking;
    }


}
