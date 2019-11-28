package BL;

import com.google.gson.Gson;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class TestMain {

    private static String URI = "http://api.openweathermap.org/data/2.5/";
    private static String PATH = "weather"; //forecast
    private static String APPID = "39629fbcd91b663dd49aa9bd55a92848";
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        String zip = "94040,us";
        Response r = client.target(URI)
                .path(PATH)
                .queryParam("APPID", APPID)
                .queryParam("q","Bad Mitterndorf")
                .request(MediaType.APPLICATION_JSON)
                .get();
        String jsonString = r.readEntity(String.class);
        
        System.out.println(jsonString);
        Gson gson = new Gson();
        OpenWeatherResponse res = gson.fromJson(jsonString, OpenWeatherResponse.class);
        System.out.println(res);
    }

}
