package BL;

public class Weather {

    private int id;
    private String main;
    private String description;
    private String icon;

    public Weather(int id, String main, String description, String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public String getIcon() {
        return icon;
    }

    public String getMain() {
        return main;
    }
}
