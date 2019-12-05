package BL.Models;

import BL.Responses.ForecastResponse;
import BL.Sorting.SortByHum;
import BL.Sorting.SortByPres;
import BL.Sorting.SortByTemp;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class ForecastModel extends AbstractTableModel{

    private ArrayList<ForecastResponse> fList;
    private String[] colNames = new String[]{"Destination", "State"};

    public ForecastModel(ArrayList<ForecastResponse> fList) {
        this.fList = fList;
    }
    
    @Override
    public int getRowCount() {
        return fList.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0: return fList.get(rowIndex).getCity().getName();
            case 1: return fList.get(rowIndex).getCity().getCountry();
        }
        return "ERROR";
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }
    
    public ForecastResponse getResponseAt(int idx){
        return fList.get(idx);
    }
    
    public void sortByTemp() {
        Collections.sort(fList, new SortByTemp());
        fireTableDataChanged();
    }
    
    public void sortByHum() {
        Collections.sort(fList, new SortByHum());
        fireTableDataChanged();
    }
        
    public void sortByPres() {
        Collections.sort(fList, new SortByPres());
        fireTableDataChanged();
    }
    
    

}
