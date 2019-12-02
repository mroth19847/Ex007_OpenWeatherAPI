package BL;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class OpenWeatherResponseModel extends AbstractTableModel{

    private ArrayList<OpenWeatherResponse> owrList = new ArrayList<>();
    private String[] colNames = new String[]{"Destination", "Date"};
    
    @Override
    public int getRowCount() {
        return owrList.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }
    
    public OpenWeatherResponse getResponseAt(int idx){
        return owrList.get(idx);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DateTimeFormatter ldtf = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        switch(columnIndex){
            case 0: return owrList.get(rowIndex).getName();
            case 1: return owrList.get(rowIndex).getDate().format(ldtf);
        }
        return "ERROR";
    }
    
    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }
    
    public void add(OpenWeatherResponse res){
        owrList.add(res);
        fireTableDataChanged();
    }

    

}
