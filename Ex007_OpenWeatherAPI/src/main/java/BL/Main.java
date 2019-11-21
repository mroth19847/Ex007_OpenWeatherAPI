package BL;

public class Main {

    private double temp;
    private double pressure;
    private double humidity;
    private double temp_min;
    private double temp_max;

    public Main(double temp, double pressure, double humidity, double temp_min, double temp_max) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public double getTemp() {
        return temp;
    }

    public double getTemp_max() {
        return temp_max;
    }

    public double getTemp_min() {
        return temp_min;
    }
    
    
}
