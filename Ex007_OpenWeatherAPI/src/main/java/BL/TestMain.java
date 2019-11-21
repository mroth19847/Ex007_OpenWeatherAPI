package BL;

import com.google.gson.Gson;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class TestMain {

    private static String URI = "http://api.openweathermap.org/data/2.5/";
    private static String PATH = "weather";
    private static String APPID = "39629fbcd91b663dd49aa9bd55a92848";
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        String zip = "94040,us";
        Response r = client.target(URI)
                .path(PATH)
                .queryParam("APPID", APPID)
                .queryParam("zip",zip)
                .request(MediaType.APPLICATION_JSON)
                .get();
        String jsonString = r.readEntity(String.class);
        
        Gson gson = new Gson();
        WeatherObject wo = gson.fromJson(jsonString, WeatherObject.class);
        System.out.println(wo);
    }

}
