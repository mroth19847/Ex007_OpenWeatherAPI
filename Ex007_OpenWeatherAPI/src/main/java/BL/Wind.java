package BL;

public class Wind {

    private double speed;
    private double deg;

    public Wind(double speed, double deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public double getDeg() {
        return deg;
    }

    public double getSpeed() {
        return speed;
    }
}
