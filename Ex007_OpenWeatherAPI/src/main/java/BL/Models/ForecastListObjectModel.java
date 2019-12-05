package BL.Models;

import BL.DataClasses.ForecastListObject;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ForecastListObjectModel extends AbstractTableModel{

    private ArrayList<ForecastListObject> filteredList = new ArrayList<>();
    private String[] colNames = new String[]{"Date", "Time"};

    public ForecastListObjectModel(ArrayList<ForecastListObject> flList) {
        for (ForecastListObject obj : flList) {
            if(obj.getDt_txt().contains("12:00:00")||obj.getDt_txt().contains("09:00:00")||obj.getDt_txt().contains("18:00:00")){
                filteredList.add(obj);
            }
        }
    }
    
    public ForecastListObjectModel(ArrayList<ForecastListObject> flList, String date) {
        for (ForecastListObject obj : flList) {
            if(obj.getDt_txt().contains(date)){
                filteredList.add(obj);
            }
        }
    }
    
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
