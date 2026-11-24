package org.example;

import org.example.enums.BookingStatus;
import org.example.enums.SeatType;
import org.example.models.*;
import org.example.services.BookingService;
import org.example.services.CinemaService;
import org.example.services.ShowService;
import org.example.services.TicketService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static void main() {

        System.out.println("=============== TICKET BOOKING SYSTEM =====================");

        User user = new User("user-1", "Aman Meenia");
        Movie movie = new Movie("movie-1", "movie", 120);

        Seat seat1 = new Seat("row-1", "col-1", SeatType.BASIC);
        Seat seat2 = new Seat("row-1", "col-2", SeatType.RECLINER);
        Seat seat3 = new Seat("row-2", "col-1", SeatType.PREMIUM);
        Seat seat4 = new Seat("row-2", "col-2", SeatType.PREMIUM);
        Seat seat5 = new Seat("row-3", "col-1", SeatType.PREMIUM);

        List<Seat> seats = List.of(seat1, seat2, seat3, seat4, seat5);
        Screen screen = new Screen("screen-1", seats);
        List<Screen> screens = List.of(screen);
        Cinema cinema = new Cinema("cinema-1", "Cinema", "Jammu", screens);

        CinemaService cinemaService = new CinemaService(List.of(cinema));

        LocalDateTime startTime = LocalDateTime.now().plusDays(1);
        LocalDateTime endTime = LocalDateTime.now().plusDays(1).plusMinutes(movie.getDuration());

        List<ShowSeat> showSeats = new ArrayList<>();

        for (int i = 0; i < seats.size(); i++) {
            Seat seat = seats.get(i);
            ShowSeat showSeat = new ShowSeat(seat.getRowId(),
                    seat.getRowId(), seat.getColId(), seat.getType(), 100);
            showSeats.add(showSeat);
        }

        Show show = new Show("show-1", movie.getId(), screen.getId(), startTime, endTime, showSeats);

        List<ShowSeat> bookingsSeats = showSeats;
        // List.of(showSeats.get(0), showSeats.get(4), showSeats.get(3));

        for (ShowSeat showSeat : bookingsSeats) {
            System.out.println("BOoking seatId " + showSeat.getId());
        }

        ShowService showService = new ShowService(List.of(show));

        BookingService bookingService = new BookingService(showService);

        Booking booking = bookingService.createBooking("bookingId-1", show.getId(), user.getId(), bookingsSeats);

        bookingService.updateBooking(booking.getId(), BookingStatus.BOOKED);
        TicketService ticketService = new TicketService();
        ticketService.generatTicket(booking);


    }
}
