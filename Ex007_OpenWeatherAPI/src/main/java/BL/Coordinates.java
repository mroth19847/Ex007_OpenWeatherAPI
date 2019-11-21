package BL;

public class Coordinates {
    
    private double lon;
    private double lat;

    public Coordinates(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }
}
