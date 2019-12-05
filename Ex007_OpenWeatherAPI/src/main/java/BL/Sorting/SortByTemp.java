package BL.Sorting;

import BL.DataClasses.ForecastListObject;
import BL.Responses.ForecastResponse;
import java.util.Comparator;

public class SortByTemp implements Comparator<ForecastResponse>{

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
