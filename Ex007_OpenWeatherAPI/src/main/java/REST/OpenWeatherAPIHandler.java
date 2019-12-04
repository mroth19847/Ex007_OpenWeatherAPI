package REST;

import BL.Destination;
import BL.OpenWeatherResponse;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class OpenWeatherAPIHandler {

    private static String URI = "http://api.openweathermap.org/data/2.5/";
    private static String APPID = "39629fbcd91b663dd49aa9bd55a92848";

    public static OpenWeatherResponse getCurrentInformation(Destination dest) {
        Client client = ClientBuilder.newClient();
        Response r = client.target(URI)
                .path("weather")
                .queryParam("APPID", APPID)
                .queryParam("q", dest.getName())
                .request(MediaType.APPLICATION_JSON)
                .get();
        Gson gson = new Gson();
        String json = r.readEntity(String.class);
        OpenWeatherResponse res = gson.fromJson(json, OpenWeatherResponse.class);
        res.setDate(LocalDateTime.now());
        res.getMain().setTemp(res.getMain().getTemp()-273.15f);
        res.getMain().setTemp_max(res.getMain().getTemp_max()-273.15f);
        res.getMain().setTemp_min(res.getMain().getTemp_min()-273.15f);
        return res;
    }
}
