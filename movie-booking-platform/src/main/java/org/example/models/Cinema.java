package org.example.models;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Cinema {
    private final String id;
    private String name;
    private String location;
    private Map<String, Screen> screens = new HashMap<>();

    public Cinema(String id, String name, String location, List<Screen> screens) {
        this.id = id;
        this.name = name;
        this.location = location;
        for (Screen screen : screens) {
            this.screens.put(screen.getId(), screen);
        }
    }

    public List<Screen> getScreens() {
        return screens.values().stream().toList();
    }

    public Screen getScrenById(String screenId) {
        return screens.getOrDefault(screenId, null);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }
}
