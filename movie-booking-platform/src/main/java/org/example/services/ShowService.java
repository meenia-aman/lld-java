package org.example.services;

import org.example.models.Cinema;
import org.example.models.Show;
import org.example.models.ShowSeat;

import java.nio.MappedByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowService {
    private Map<String, Show> shows = new HashMap<>();

    public ShowService(List<Show> shows) {
        for (Show show : shows) {
            this.shows.put(show.getId(), show);
        }
    }


    public List<Show> getAvailableShows() {
        return this.shows.values().stream().toList();
    }

    public List<ShowSeat> getAvailableShowSeats(String showId) {
        Show show = shows.getOrDefault(showId, null);
        if (show == null) return null;
        return show.getAvailableSeat();
    }

    public boolean reserveSeat(String showId, List<ShowSeat> showSeats) {
        Show show = shows.getOrDefault(showId, null);
        if (show == null) {
            System.out.println("Please eneter correct showId");
            return false;
        }

        show.reserveSeats(showSeats);
        System.out.println("Show seats reserved successfully");
        return true;
    }

    public boolean bookSeat(String showId, List<ShowSeat> showSeats) {
        Show show = shows.getOrDefault(showId, null);
        if (show == null) {
            System.out.println("Please enter correct showId");
            return false;
        }

        show.bookSeat(showSeats);
        System.out.println("Show seats Booked successfully");
        return true;
    }


}
