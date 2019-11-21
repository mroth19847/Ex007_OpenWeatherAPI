package BL;

public class WeatherObject {

    private Coordinates coordinates;
    private Weather weather;
    private String base;
    private Main main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private long dt;
    private Sys sys;
    private int timezone;
    private int id;
    private String name;
    private int cod;

    public WeatherObject(Coordinates coordinates, Weather weather, String base, Main main, int visibility, Wind wind, Clouds clouds, long dt, Sys sys, int timezone, int id, String name, int cod) {
        this.coordinates = coordinates;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public String getBase() {
        return base;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public int getCod() {
        return cod;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public long getDt() {
        return dt;
    }

    public int getId() {
        return id;
    }

    public Main getMain() {
        return main;
    }

    public String getName() {
        return name;
    }

    public Weather getWeather() {
        return weather;
    }

    public int getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public Sys getSys() {
        return sys;
    }

    public int getTimezone() {
        return timezone;
    }
    
}
