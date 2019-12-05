package BL.DataClasses;

import java.util.List;

public class ForecastListObject {

    private float dt;
    private Main main;
    private List<Weather> weather;
    private Clouds clouds;
    private Wind wind;
    private Sys sys;
    private String dt_txt;

    public List<Weather> getWeather() {
        return weather;
    }
    // Getter Methods 
    public float getDt() {
        return dt;
    }

    public Main getMain() {
        return main;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public Sys getSys() {
        return sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    // Setter Methods 
    public void setDt(float dt) {
        this.dt = dt;
    }

    public void setMain(Main mainObject) {
        this.main = mainObject;
    }

    public void setClouds(Clouds cloudsObject) {
        this.clouds = cloudsObject;
    }

    public void setWind(Wind windObject) {
        this.wind = windObject;
    }

    public void setSys(Sys sysObject) {
        this.sys = sysObject;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}
