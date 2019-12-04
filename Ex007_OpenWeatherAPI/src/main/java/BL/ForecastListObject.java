package BL;

import java.util.List;

public class ForecastListObject {

    private float dt;
    private Main MainObject;
    private List<Weather> weather;
    Clouds CloudsObject;
    Wind WindObject;
    Sys SysObject;
    private String dt_txt;

    // Getter Methods 
    public float getDt() {
        return dt;
    }

    public Main getMain() {
        return MainObject;
    }

    public Clouds getClouds() {
        return CloudsObject;
    }

    public Wind getWind() {
        return WindObject;
    }

    public Sys getSys() {
        return SysObject;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    // Setter Methods 
    public void setDt(float dt) {
        this.dt = dt;
    }

    public void setMain(Main mainObject) {
        this.MainObject = mainObject;
    }

    public void setClouds(Clouds cloudsObject) {
        this.CloudsObject = cloudsObject;
    }

    public void setWind(Wind windObject) {
        this.WindObject = windObject;
    }

    public void setSys(Sys sysObject) {
        this.SysObject = sysObject;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }
}
