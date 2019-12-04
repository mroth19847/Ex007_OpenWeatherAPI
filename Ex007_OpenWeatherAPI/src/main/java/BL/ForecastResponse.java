package BL;

import java.util.ArrayList;

public class ForecastResponse {

    private String cod;
    private float message;
    private float cnt;
    ArrayList<ForecastListObject> list;
    private City city;

    public ArrayList<ForecastListObject> getList() {
        return list;
    }

    // Getter Methods 
    public String getCod() {
        return cod;
    }

    public float getMessage() {
        return message;
    }

    public float getCnt() {
        return cnt;
    }

    public City getCity() {
        return city;
    }

    // Setter Methods 
    public void setCod(String cod) {
        this.cod = cod;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    public void setCnt(float cnt) {
        this.cnt = cnt;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
