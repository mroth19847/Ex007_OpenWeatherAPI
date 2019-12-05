package BL.Models;

import BL.DataClasses.ForecastListObject;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class CompareModel extends AbstractTableModel{
    
    private ArrayList<ForecastListObject> filteredList1 = new ArrayList<>();
    private ArrayList<ForecastListObject> filteredList2 = new ArrayList<>();
    private String[] colNames = new String[]{"Date", "Time"};

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
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
