package BL.DataClasses;

public class Destination {
    
    private String name;
    private String zip;

    public Destination(String name, String zip) {
        this.name = name;
        this.zip = zip;
    }

    public String getName() {
        return name;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public String toString() {
        if(name.equals("")){
            return zip;
        }
        else if (zip.equals("")){
            return name;
        }
        return zip + " " + name;
    }
    
    
    
}
