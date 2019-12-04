package BL;

import java.util.ArrayList;

public class ForecastResponse {

    private String cod;
    private float message;
    private float cnt;
    ArrayList<ForecastListObject> list = new ArrayList<>();
    private City CityObject;

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
        return CityObject;
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

    public void setCity(City cityObject) {
        this.CityObject = cityObject;
    }
}
