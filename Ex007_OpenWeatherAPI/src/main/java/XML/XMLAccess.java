package XML;

import BL.Destination;
import BL.DestinationBL;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class XMLAccess {

    public static void exportXML(DestinationBL bl) throws IOException {
        ArrayList<Destination> destList = bl.getDestList();
        Element rootElement = new Element("DestinationList");
        Document doc = new Document(rootElement);

        for (Destination destination : destList) {
            Element elem = new Element("Destination");
            rootElement.addContent(elem);
            Element nameElem = new Element("Name");
            Element zipElem = new Element("Zip");
            elem.addContent(nameElem);
            nameElem.setText(destination.getName());
            elem.addContent(zipElem);
            zipElem.setText(destination.getZip());
        }

        XMLOutputter xmlOutput = new XMLOutputter();
        xmlOutput.setFormat(Format.getPrettyFormat());

        File file = new File("xml/destinations.xml");
        FileWriter fw = new FileWriter(file);
        xmlOutput.output(doc, fw);
        xmlOutput.output(doc, System.out);
    }
    
    public static DestinationBL importXML() throws JDOMException, IOException {
        ArrayList<Destination> destList = new ArrayList<>();
        File f = new File("xml/destinations.xml");
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(f);
        Element root = doc.getRootElement();
        for (Element elem : root.getChildren()) {
            destList.add(new Destination(elem.getChildText("Name"), elem.getChildText("Zip")));
        }
        DestinationBL bl = new DestinationBL();
        bl.setDestList(destList);
        return bl;
    }
}
