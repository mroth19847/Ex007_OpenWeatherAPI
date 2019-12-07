package BL.Models;

import BL.DataClasses.Weather;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class WeatherModel extends AbstractTableModel{

    private List<Weather> wList;
    private String[] colNames = new String[]{"Main", "Description", "Icon"};

    /**
     * In order to create a new WeatherModel, you have to commit an already existing wheater list as a paramter
     * @param wList The given Weather-List
     */
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
        return wList.get(rowIndex);
    }

}
