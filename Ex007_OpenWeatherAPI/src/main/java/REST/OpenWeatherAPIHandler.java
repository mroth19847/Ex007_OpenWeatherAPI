package REST;

import BL.Destination;
import BL.ForecastListObject;
import BL.ForecastResponse;
import BL.OpenWeatherResponse;
import BL.Weather;
import com.google.gson.Gson;
import java.time.LocalDateTime;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class OpenWeatherAPIHandler {

    private static String URI = "http://api.openweathermap.org/data/2.5/";
    private static String APPID = "39629fbcd91b663dd49aa9bd55a92848";

    public static OpenWeatherResponse getCurrentInformation(Destination dest) throws Exception {
        Client client = ClientBuilder.newClient();
        Response r = client.target(URI)
                .path("weather")
                .queryParam("APPID", APPID)
                .queryParam("q", dest.getName())
                .queryParam("units", "metric")
                .request(MediaType.APPLICATION_JSON)
                .get();
        Gson gson = new Gson();
        String json = r.readEntity(String.class);
        OpenWeatherResponse res = gson.fromJson(json, OpenWeatherResponse.class);
        res.setDate(LocalDateTime.now());
        if(json.contains("\"cod\":\"404\"")){
            throw new Exception("City not found!");
        }
        return res;
    }
    
    public static ForecastResponse getForecast(Destination dest) throws Exception{
        Client client = ClientBuilder.newClient();
        Response r = client.target(URI)
                .path("forecast")
                .queryParam("APPID", APPID)
                .queryParam("q", dest.getName())
                .queryParam("units", "metric")
                .request(MediaType.APPLICATION_JSON)
                .get();
        Gson gson = new Gson();
        String json = r.readEntity(String.class);
        ForecastResponse res = gson.fromJson(json, ForecastResponse.class);
        if(json.contains("\"cod\":\"404\"")){
            throw new Exception("City not found!");
        }
        return res;        
    }
}
