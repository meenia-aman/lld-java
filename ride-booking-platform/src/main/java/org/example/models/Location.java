package org.example.models;

/**
 * Location
 */
public class Location {

    private double xCoordinates;
    private double yCoordinates;

    public Location(double xCoordinates, double yCoordinates) {
        this.xCoordinates = xCoordinates;
        this.yCoordinates = yCoordinates;
    }

    public void updateLocation(double xCoordinates, double yCoordinates) {
        this.xCoordinates = xCoordinates;
        this.yCoordinates = yCoordinates;
    }

    public double getxCoordinates() {
        return xCoordinates;
    }

    public double getyCoordinates() {
        return yCoordinates;
    }

    public boolean inRange(Location location, int range) {
        double dx = location.getxCoordinates() - this.xCoordinates;
        double dy = location.getyCoordinates() - this.yCoordinates;

        double distance = Math.sqrt(dx * dx + dy * dy);

        return distance <= range;
    }
}
