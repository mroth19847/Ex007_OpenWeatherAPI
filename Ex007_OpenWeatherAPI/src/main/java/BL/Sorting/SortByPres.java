package BL.Sorting;

import BL.DataClasses.ForecastListObject;
import BL.Responses.ForecastResponse;
import java.util.Comparator;

public class SortByPres implements Comparator<ForecastResponse>{

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
