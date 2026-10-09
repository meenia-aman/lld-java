package org.example.services;

import java.awt.image.ShortLookupTable;
import java.util.List;
import org.example.enums.BookingStatusType;
import org.example.enums.PaymentType;
import org.example.models.Booking;
import org.example.models.Transaction;
import org.example.repository.BookingRepository;

/**
 * BookingService
 */
public class BookingService {

    private BookingRepository bookingRepository;
    private ShowService showService;
    private PaymentService paymentService;

    public BookingService(
        BookingRepository bookingRepository,
        ShowService showService,
        PaymentService paymentService
    ) {
        this.bookingRepository = bookingRepository;
        this.showService = showService;
        this.paymentService = paymentService;
    }

    public Booking CreateBooking(
        int userId,
        String showId,
        List<String> seats,
        PaymentType paymentType
    ) {
        double total_amount = showService.reserveShowSeats(showId, seats);
        System.out.println(" TOTAL AMOUNT " + total_amount);
        if (total_amount == 0) {
            System.out.println(" Seat reservation fails");
            return null;
        }
        Booking b = new Booking(userId, showId, seats);
        bookingRepository.create(b);

        Transaction t = paymentService.pay(
            total_amount,
            paymentType,
            b.getId(),
            userId
        );
        showService.bookShowSeats(showId, seats);
        b.updateBookinStatus(BookingStatusType.BOOKED);
        bookingRepository.update(b);

        return b;
    }
}
