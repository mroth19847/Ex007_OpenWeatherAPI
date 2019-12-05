package BL.Sorting;

import BL.DataClasses.ForecastListObject;
import BL.Responses.ForecastResponse;
import java.util.Comparator;

public class SortByHum implements Comparator<ForecastResponse>{

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
