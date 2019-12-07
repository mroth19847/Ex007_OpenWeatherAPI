package BL.Sorting;

import BL.DataClasses.ForecastListObject;
import BL.Responses.ForecastResponse;
import java.util.Comparator;

public class SortByHum implements Comparator<ForecastResponse>{

    /**
     * The overridden compare method of the SortByHum-Comparator calculates the average humidity of two given ForecastResponses
     * and returns an integer for indicating the lower or higher average humidity
     * @param o1 The first ForecastRespone
     * @param o2 The second ForecastResponse
     * @return -1 when the average humidity of o1 is smaller than the average humidity of o2
     *          1 when the average humidity of o1 is bigger than the average humidity of o2
     *          0 when the average humidity of o1 is as high as the average humidity of o2
     */
    @Override
    public int compare(ForecastResponse o1, ForecastResponse o2) {
        double avgHum1 = 0, avgHum2 = 0;
        for (ForecastListObject flObj : o1.getListObjectsFromTravelDay()) {
            avgHum1 += flObj.getMain().getHumidity();
        }
        for (ForecastListObject flObj : o2.getListObjectsFromTravelDay()) {
            avgHum2 += flObj.getMain().getHumidity();
        }
        if(avgHum1<avgHum2) return -1;
        if(avgHum2<avgHum1) return 1;
        return 0;
    }
}
