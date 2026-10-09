package org.example.services;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.example.enums.SeatType;
import org.example.models.Cinema;
import org.example.models.CinemaHall;
import org.example.models.Movie;
import org.example.models.Seat;
import org.example.models.Show;
import org.example.repository.ShowRepository;

/**
 * ShowService
 */
public class ShowService {

    private ShowRepository showRepository;
    private CinemaService cinemaService;

    public ShowService(
        ShowRepository showRepository,
        CinemaService cinemaService
    ) {
        this.showRepository = showRepository;
        this.cinemaService = cinemaService;
    }

    public List<Show> getShowsByMovieId(String id) {
        return showRepository.getByMovieId(id);
    }

    public List<Show> getShowByCinemaId(String id) {
        return showRepository.getShowByCinemaId(id);
    }

    public List<Show> getShowByCity(String city) {
        return showRepository.getShowByCity(city);
    }

    public Show getShowById(String id) {
        return showRepository.getById(id);
    }

    public Show addShow(
        Movie movie,
        String cinemaId,
        String cinemaHallId,
        LocalDateTime startTime,
        LocalDateTime endTime,
        Map<SeatType, Double> priceMapping
    ) {
        Cinema cinema = cinemaService.getCinemaById(cinemaId);
        CinemaHall cinemaHall = cinema.getCinemaHallById(cinemaHallId);
        List<Seat> seatsList = cinemaHall.getSeats();

        Map<String, Seat> seats = new HashMap<>();

        for (Seat it : seatsList) {
            seats.put(it.getId(), it);
        }

        Show show = new Show(
            movie.getName(),
            cinemaId,
            cinemaHallId,
            movie,
            startTime,
            endTime,
            priceMapping,
            seats,
            cinema.getLocation()
        );

        return showRepository.add(show);
    }

    public double reserveShowSeats(String showId, List<String> ids) {
        Show show = showRepository.getById(showId);
        if (show == null) {
            System.out.println(" Invalid showId ");
            return 0;
        }
        boolean reserve = show.reserveSeat(ids);

        if (reserve) {
            double total_amount = 0;
            System.out.print(" Seats with ids ");
            for (String id : ids) {
                System.out.print(id + ", ");
                total_amount += show.getPriceBySeatId(id);
            }
            System.out.println(" Reserverd Successfully");
            return total_amount;
        }

        return 0;
    }

    public boolean bookShowSeats(String showId, List<String> ids) {
        Show show = showRepository.getById(showId);

        if (show == null) {
            System.out.println(" Invalide showId");
            return false;
        }

        boolean bookTicket = show.bookSeat(ids);

        if (bookTicket) {
            System.out.print(" Seats with ids ");
            for (String id : ids) {
                System.out.print(id + ", ");
            }
            System.out.println(" Booked Successfully");
            return true;
        }
        return false;
    }

    public void showSeatsByShowId(String id) {
        Show show = showRepository.getById(id);
        show.displayAllSeats();
    }
}
