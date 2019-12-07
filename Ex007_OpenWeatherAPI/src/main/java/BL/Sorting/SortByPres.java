package BL.Sorting;

import BL.DataClasses.ForecastListObject;
import BL.Responses.ForecastResponse;
import java.util.Comparator;

public class SortByPres implements Comparator<ForecastResponse>{

    /**
     * The overridden compare method of the SortByPres-Comparator calculates the average pressure of two given ForecastResponses
     * and returns an integer for indicating the lower or higher average pressure
     * @param o1 The first ForecastRespone
     * @param o2 The second ForecastResponse
     * @return -1 when the average pressure of o1 is smaller than the average pressure of o2
     *          1 when the average pressure of o1 is bigger than the average pressure of o2
     *          0 when the average pressure of o1 is as high as the average pressure of o2
     */
    @Override
    public int compare(ForecastResponse o1, ForecastResponse o2) {
        double avgPres1 = 0, avgPres2 = 0;
        for (ForecastListObject flObj : o1.getListObjectsFromTravelDay()) {
            avgPres1 += flObj.getMain().getPressure();
        }
        for (ForecastListObject flObj : o2.getListObjectsFromTravelDay()) {
            avgPres2 += flObj.getMain().getPressure();
        }
        if(avgPres1<avgPres2) return -1;
        if(avgPres2<avgPres1) return 1;
        return 0;
    }
}
