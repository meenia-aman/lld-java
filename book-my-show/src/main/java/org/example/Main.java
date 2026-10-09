package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.enums.PaymentType;
import org.example.enums.SeatType;
import org.example.models.Cinema;
import org.example.models.CinemaHall;
import org.example.models.Movie;
import org.example.models.Seat;
import org.example.models.Show;
import org.example.models.User;
import org.example.repository.*;
import org.example.services.*;

public class Main {

    static void main() {
        MovieRepository movieRepository = new InMemoryMovieRepository();
        MovieService movieService = new MovieService(movieRepository);

        Movie m1 = movieService.createMovie(
            "Drishyam",
            360000,
            "Nothing",
            true
        );
        Movie m2 = movieService.createMovie(
            "Drishyam 1",
            360000,
            "Nothing",
            true
        );
        Movie m3 = movieService.createMovie(
            "Drishyam 2",
            360000,
            "Nothing",
            true
        );

        Seat s1 = new Seat("S-1", SeatType.PREMIUM);
        Seat s2 = new Seat("S-1", SeatType.GOLD);
        Seat s3 = new Seat("S-1", SeatType.PREMIUM);
        Seat s4 = new Seat("S-1", SeatType.PREMIUM);

        List<Seat> seats = new ArrayList<>();
        seats.add(s1);
        seats.add(s2);
        seats.add(s3);
        seats.add(s4);

        CinemaHall cinemaHall = new CinemaHall(seats);
        cinemaHall.setMovie(m1);

        CinemaRepository cinemaRepository = new InMemoryCinemaRepository();
        CinemaService cinemaService = new CinemaService(cinemaRepository);

        List<CinemaHall> cinemaHalls = new ArrayList<>();
        cinemaHalls.add(cinemaHall);

        Cinema cinema = cinemaService.createCinema(
            "CINEMA-1",
            "Jammu",
            "Jammu",
            "India",
            cinemaHalls
        );

        ShowRepository showRepository = new InMemoryShowRepository();
        ShowService showService = new ShowService(
            showRepository,
            cinemaService
        );

        Map<SeatType, Double> priceMapping = new HashMap<>();
        priceMapping.put(SeatType.BASIC, 200.0);
        priceMapping.put(SeatType.GOLD, 500.0);
        priceMapping.put(SeatType.PREMIUM, 1000.0);
        // priceMapping.add({SeatType.BASIC,100});
        // priceMapping.add({SeatType.BASIC,100});

        Show show = showService.addShow(
            m1,
            cinema.getId(),
            cinemaHall.getId(),
            LocalDateTime.now(),
            LocalDateTime.now(),
            priceMapping
        );

        BookingRepository bookingRepository = new InMemoryBookingRepository();
        TransactionRepository transactionRepository = new InMemoryTransactionRepository();
        PaymentService paymentService = new PaymentService(transactionRepository);
        BookingService bookingService = new BookingService(
            bookingRepository,
            showService,
                paymentService
        );

        User user = new User(1, "Aman Meenia", "amanmeenia@gamil.com");
        List<String> booking_seats = new ArrayList<>();
        booking_seats.add(seats.getFirst().getId());
        bookingService.CreateBooking(
            user.getId(),
            show.getId(),
            booking_seats,
            PaymentType.UPI
        );
    }
}
