package BL;

public class Sys {

    private int type;
    private int id;
    private String country;
    private long sunrise;
    private long sunset;

    public Sys(int type, int id, String country, long sunrise, long sunset) {
        this.type = type;
        this.id = id;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public String getCountry() {
        return country;
    }

    public int getId() {
        return id;
    }

    public long getSunrise() {
        return sunrise;
    }

    public long getSunset() {
        return sunset;
    }

    public int getType() {
        return type;
    }
    
    
}
