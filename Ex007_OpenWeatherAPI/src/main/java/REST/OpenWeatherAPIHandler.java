package REST;

import BL.Destination;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class OpenWeatherAPIHandler {

    private static String URI = "http://api.openweathermap.org/data/2.5/";
    private static String APPID = "39629fbcd91b663dd49aa9bd55a92848";

    public static String getJSONString(Destination dest, boolean forecast) {
        Client client = ClientBuilder.newClient();
        String PATH = "weather", param1, param2;
        if (dest.getName().equals("")) {
            param1 = "zip";
            param2 = dest.getZip();
        } else {

            param1 = "q";
            param2 = dest.getName();
        }
        if (forecast) {
            PATH = "forecast";
        }
        Response r = client.target(URI)
                .path(PATH)
                .queryParam("APPID", APPID)
                .queryParam(param1, param2)
                .request(MediaType.APPLICATION_JSON)
                .get();
        return r.readEntity(String.class);
    }
}
