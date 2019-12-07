package BL.Sorting;

import BL.DataClasses.ForecastListObject;
import BL.Responses.ForecastResponse;
import java.util.Comparator;

public class SortByTemp implements Comparator<ForecastResponse>{

    /**
     * The overridden compare method of the SortByTemp-Comparator calculates the average temperature of two given ForecastResponses
     * and returns an integer for indicating the lower or higher average temperature
     * @param o1 The first ForecastRespone
     * @param o2 The second ForecastResponse
     * @return -1 when the average temperature of o1 is smaller than the average temperature of o2
     *          1 when the average temperature of o1 is bigger than the average temperature of o2
     *          0 when the average temperature of o1 is as high as the average temperature of o2
     */
    @Override
    public int compare(ForecastResponse o1, ForecastResponse o2) {
        double avgTemp1 = 0, avgTemp2 = 0;
        for (ForecastListObject flObj : o1.getListObjectsFromTravelDay()) {
            avgTemp1 += flObj.getMain().getTemp();
        }
        for (ForecastListObject flObj : o2.getListObjectsFromTravelDay()) {
            avgTemp2 += flObj.getMain().getTemp();
        }
        if(avgTemp1<avgTemp2) return -1;
        if(avgTemp2<avgTemp1) return 1;
        return 0;
    }

}
