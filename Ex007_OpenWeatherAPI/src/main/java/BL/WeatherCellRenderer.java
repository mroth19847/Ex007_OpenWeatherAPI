package BL;

import java.awt.Component;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class WeatherCellRenderer implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        label.setOpaque(true);
        try {
            Weather w = (Weather) value;
            switch (column) {
                case 0:
                    label.setText(w.getMain());
                    break;
                case 1:
                    label.setText(w.getDescription());
                    break;
                case 2:
                    URL url = new URL("http://openweathermap.org/img/w/"+w.getIcon()+".png");
                    Image image = ImageIO.read(url);
                    label.setHorizontalAlignment(JLabel.CENTER);
                    label.setIcon(new ImageIcon(image));
                    break;

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            label.setText("ERROR");
        }
        return label;
    }

}
