package BL.Models;

import BL.DataClasses.ForecastListObject;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class CompareModel extends AbstractTableModel{
    
    private ArrayList<ForecastListObject> filteredList1 = new ArrayList<>();
    private ArrayList<ForecastListObject> filteredList2 = new ArrayList<>();
    private String[] colNames = new String[]{"Date", "Time"};

    /**
     * The constructor of the CompareModel goes through the two ForecastListObject - Lists and saves the objects, which
     * take place on the selected date, in the filtered-lists
     * @param flList1 List of the first ForecastResponse
     * @param flList2 List of the second ForecastResponse
     * @param date Selected Date given as String
     */
    public CompareModel(ArrayList<ForecastListObject> flList1, ArrayList<ForecastListObject> flList2, String date) {
        for (ForecastListObject obj : flList1) {
            if(obj.getDt_txt().contains(date)){
                filteredList1.add(obj);
            }
        }
        for (ForecastListObject obj : flList2) {
            if(obj.getDt_txt().contains(date)){
                filteredList2.add(obj);
            }
        }
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    
    
    @Override
    public int getRowCount() {
        return filteredList1.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] datetime = filteredList1.get(rowIndex).getDt_txt().split(" ");
        switch(columnIndex){
            case 0: return datetime[0];
            case 1: return datetime[1];
        }
        return "ERROR";
    }
    
    /**
     * Returns a specific ForecastListObject at a given index from list1
     * @param idx The given index
     * @return The object at the index from list1
     */
    public ForecastListObject getObject1At(int idx){
        return filteredList1.get(idx);
    }
    /**
     * Returns a specific ForecastListObject at a given index from list2
     * @param idx The given index
     * @return The object at the index from list2
     */
    public ForecastListObject getObject2At(int idx){
        return filteredList2.get(idx);
    }
}
