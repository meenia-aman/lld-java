package org.example.models;

import org.example.enums.ShowSeatStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Show {
    private String id;
    private String movieId;
    private String screenId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Map<String, ShowSeat> seats = new HashMap<>();

    public Show(String id, String movieId, String screenId, LocalDateTime startTime, LocalDateTime endTime,
                List<ShowSeat> seatList) {
        this.id = id;
        this.movieId = movieId;
        this.screenId = screenId;
        this.startTime = startTime;
        this.endTime = endTime;
        for (ShowSeat seat : seatList) {
            seats.put(seat.getId(), seat);
        }
    }

    public List<ShowSeat> getAvailableSeat() {
        return seats.values().stream().filter(seat -> seat.getStatus() == ShowSeatStatus.AVAILABLE).toList();
    }

    public boolean reserveSeats(List<ShowSeat> showSeats) {
        for (ShowSeat showSeat : showSeats) {
            ShowSeat seat = seats.get(showSeat.getId());
            seat.setStatus(ShowSeatStatus.RESERVED);
        }
        return true;
    }

    public boolean bookSeat(List<ShowSeat> showSeats) {
        for (ShowSeat showSeat : showSeats) {
            ShowSeat seat = seats.get(showSeat.getId());
            seat.setStatus(ShowSeatStatus.BOOKED);
        }
        return true;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Map<String, ShowSeat> getSeats() {
        return seats;
    }

    public String getScreenId() {
        return screenId;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getId() {
        return id;
    }
}
