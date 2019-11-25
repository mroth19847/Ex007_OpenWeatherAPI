package BL;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

public class DestinationBL extends AbstractListModel{

    private ArrayList<Destination> destList = new ArrayList<>();

    @Override
    public int getSize() {
        return destList.size();
    }

    @Override
    public Object getElementAt(int index) {
        return destList.get(index);
    }
    
    /**
     * The method adds a new destination to the ArrayList and the jList.
     * @param dest - The object of the new destination
     * @throws - Exception if both zip and name of the destination are empty, a exception is thrown
     */
    public void add(Destination dest) throws Exception{
        if(dest.getZip().equals("") && dest.getName().equals("")){
            throw new Exception("Both Fields are empty!");
        }
        
        destList.add(dest);
        
        fireIntervalAdded(this, destList.size()-1, destList.size()-1);
    }
    
    /**
     * The method replaces a destination on a specific index with a new destination (for the user it represents the edit function).
     * @param idx - The index of the original destination
     * @param dest - The new destination
     * @throws Exception - if both zip and name of the destination are empty, a exception is thrown
     */
    public void edit(int idx, Destination dest) throws Exception{
        if(dest.getZip().equals("") && dest.getName().equals("")){
            throw new Exception("Both Fields are empty!");
        }
        
        destList.set(idx, dest);
        
        fireContentsChanged(this, 0, destList.size()-1);
    }
    
    /**
     * The method deletes a destination on a specific index.
     * @param idx - The index of the object which should be deleted.
     * @throws Exception - If the index is not found, an Exception is thrown.
     */
    public void delete(int idx){

        destList.remove(idx);
        
        fireContentsChanged(this, 0, destList.size()-1);
    }
}
