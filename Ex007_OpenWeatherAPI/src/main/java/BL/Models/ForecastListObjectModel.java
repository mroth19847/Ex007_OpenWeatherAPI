package BL.Models;

import BL.DataClasses.ForecastListObject;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ForecastListObjectModel extends AbstractTableModel{

    private ArrayList<ForecastListObject> filteredList = new ArrayList<>();
    private String[] colNames = new String[]{"Date", "Time"};

    /**
     * The first constructor for the ForecastListObjectModel: In order to achieve a better overview, the constructor only saves the
     * objects taking place at 12:00:00, 09:00:00 and 18:00:00 into the filtered list
     * @param flList The original list to be shown
     */
    public ForecastListObjectModel(ArrayList<ForecastListObject> flList) {
        for (ForecastListObject obj : flList) {
            if(obj.getDt_txt().contains("12:00:00")||obj.getDt_txt().contains("09:00:00")||obj.getDt_txt().contains("18:00:00")){
                filteredList.add(obj);
            }
        }
    }
    
    /**
     * The second constructor is triggered by adding a date as a string as an additional parameter, it is used for showing the objects
     * on a specific date
     * @param flList The original list to be shown
     * @param date The selected date
     */
    public ForecastListObjectModel(ArrayList<ForecastListObject> flList, String date) {
        for (ForecastListObject obj : flList) {
            if(obj.getDt_txt().contains(date)){
                filteredList.add(obj);
            }
        }
    }
    
    /**
     * Returns a specific ForecastListObject at a given index from the list
     * @param idx The given index
     * @return The object at the index from the list
     */
    public ForecastListObject getObjectAt(int idx){
        return filteredList.get(idx);
    }

    @Override
    public int getRowCount() {
        return filteredList.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] datetime = filteredList.get(rowIndex).getDt_txt().split(" ");
        switch(columnIndex){
            case 0: return datetime[0];
            case 1: return datetime[1];
        }
        return "ERROR";
    }

    
    
}
