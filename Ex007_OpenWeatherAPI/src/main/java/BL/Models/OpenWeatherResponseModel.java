package BL.Models;

import BL.Responses.OpenWeatherResponse;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class OpenWeatherResponseModel extends AbstractTableModel{

    private ArrayList<OpenWeatherResponse> owrList = new ArrayList<>();
    private String[] colNames = new String[]{"Destination", "State", "Date"};

    @Override
    public int getRowCount() {
        return owrList.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }
    
    /**
     * Returns a specific OpenWeatherResponse at a given index from the list
     * @param idx The given index
     * @return The object at the index from the list
     */
    public OpenWeatherResponse getResponseAt(int idx){
        return owrList.get(idx);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DateTimeFormatter ldtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        switch(columnIndex){
            case 0: return owrList.get(rowIndex).getName();
            case 1: return owrList.get(rowIndex).getSys().getCountry();
            case 2: return owrList.get(rowIndex).getDate().format(ldtf);
        }
        return "ERROR";
    }
    
    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    /**
     * Adds a given OpenWeatherResponse at the end of the list and updates it
     * @param owr The given OpenWeatherResponse - Object
     */
    public void add(OpenWeatherResponse owr){
        owrList.add(owr);
        fireTableDataChanged();
    }

}
