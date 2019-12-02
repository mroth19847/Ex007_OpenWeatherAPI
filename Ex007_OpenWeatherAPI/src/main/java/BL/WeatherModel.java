package BL;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class WeatherModel extends AbstractTableModel{

    private List<Weather> wList;
    private String[] colNames = new String[]{"Main", "Description", "Icon"};

    public WeatherModel(List<Weather> wList) {
        this.wList = wList;
    }
    
    @Override
    public int getRowCount() {
        return wList.size();
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
