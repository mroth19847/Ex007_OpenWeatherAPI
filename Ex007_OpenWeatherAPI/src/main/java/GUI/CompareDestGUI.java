package GUI;

import BL.DataClasses.ForecastListObject;
import BL.Models.CompareModel;
import BL.Models.WeatherModel;
import BL.Responses.ForecastResponse;
import GUI.Renderer.WeatherCellRenderer;
import java.awt.Color;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CompareDestGUI extends javax.swing.JFrame {

    private CompareModel cModel;
    private WeatherModel wm1;
    private WeatherModel wm2;
    
    /**
     * The constructor of the CompareDestGUI fills the TimeTable with the time of the in the WeatherGUI selected travelDay, it also
     * adds an event for the TimeTable, so that when the selection changes, the weather information of is updated for both responses
     * @param f1 first selected ForecastResponse 
     * @param f2 second selected ForecastResponse
     */
    public CompareDestGUI(ForecastResponse f1, ForecastResponse f2) {
        initComponents();
        cModel = new CompareModel(f1.getList(), f2.getList(), WeatherGUI.travelDay);
        lbForecast.setText("Forecast for Day: "+WeatherGUI.travelDay);
        lbDest1.setText(f1.getCity().getName());
        lbDest2.setText(f2.getCity().getName());
        TimeTable.setModel(cModel);
        TimeTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {
                    if (TimeTable.getSelectedRow() > -1) {
                        updateGUI(cModel.getObject1At(TimeTable.getSelectedRow()),
                                  cModel.getObject2At(TimeTable.getSelectedRow()));
                    }
                }
            }
        });
        
        WeatherTable.setDefaultRenderer(Object.class, new WeatherCellRenderer());
        WeatherTable1.setDefaultRenderer(Object.class, new WeatherCellRenderer());
        WeatherTable.setRowHeight(35);
        WeatherTable1.setRowHeight(35);

    }
    
    /**
     * The updateGUI method is for displaying the weather information of two ForecastListObjects in following aspects:
     *      WeatherTable containing icons and text
     *      Information values concerning humidity, pressure and temperature
     *      Coloring the information values:
     *          Temperature: 
     *              below 10°C => dark blue
     *              10°C - 17°C => light blue
     *              18°C - 25°C => green
     *              26°C - 35°C => orange
     *              over 35°C => red
     *          Humidity:
     *              over 75% => dark blue
     *              66% to 75% => light blue
     *              65% and lower => orange
     *          Wind Speed:
     *              5m/s and lower => green
     *              6m/s - 13m/s => orange
     *              over 13m/s => red
     * @param res1 The first ForecastListObject
     * @param res2 The second ForecastListObject
     */
    private void updateGUI(ForecastListObject res1, ForecastListObject res2) {
        wm1 = new WeatherModel(res1.getWeather());
        wm2 = new WeatherModel(res2.getWeather());
        WeatherTable.setModel(wm1);
        WeatherTable1.setModel(wm2);
        tfTemperature.setText(String.format("%.2f °C", res1.getMain().getTemp()));
        tfPressure.setText(res1.getMain().getPressure() + " hpa");
        tfHumidity.setText(res1.getMain().getHumidity() + "%");
        tfWind.setText(res1.getWind().getDeg() + "° @ " + res1.getWind().getSpeed() + "m/s");
        WeatherTable.setModel(new WeatherModel(res1.getWeather()));
        
        tfTemperature1.setText(String.format("%.2f °C", res2.getMain().getTemp()));
        tfPressure1.setText(res2.getMain().getPressure() + " hpa");
        tfHumidity1.setText(res2.getMain().getHumidity() + "%");
        tfWind1.setText(res2.getWind().getDeg() + "° @ " + res2.getWind().getSpeed() + "m/s");
        WeatherTable1.setModel(new WeatherModel(res2.getWeather()));
        
        if (res1.getMain().getTemp() < 10) {
            tfTemperature.setBackground(Color.BLUE);
            tfTemperature.setForeground(Color.WHITE);
        } else if (res1.getMain().getTemp() < 18) {
            tfTemperature.setBackground(Color.CYAN);
            tfTemperature.setForeground(Color.BLACK);
        } else if (res1.getMain().getTemp() > 35) {
            tfTemperature.setBackground(Color.RED);
            tfTemperature.setForeground(Color.WHITE);
        } else if (res1.getMain().getTemp() > 25) {
            tfTemperature.setBackground(Color.ORANGE);
            tfTemperature.setForeground(Color.BLACK);
        } else {
            tfTemperature.setBackground(Color.GREEN);
            tfTemperature.setForeground(Color.BLACK);
        }
        if (res1.getMain().getHumidity() > 75) {
            tfHumidity.setBackground(Color.BLUE);
            tfHumidity.setForeground(Color.WHITE);
        } else if (res1.getMain().getHumidity() > 65) {
            tfHumidity.setBackground(Color.CYAN);
            tfHumidity.setForeground(Color.BLACK);
        } else {
            tfHumidity.setBackground(Color.ORANGE);
            tfHumidity.setForeground(Color.BLACK);
        }
        if (res1.getWind().getSpeed()<= 5) {
            tfWind.setBackground(Color.GREEN);
            tfWind.setForeground(Color.BLACK);
        } else if (res1.getWind().getSpeed() <= 13) {
            tfWind.setBackground(Color.ORANGE);
            tfWind.setForeground(Color.BLACK);
        } else {
            tfWind.setBackground(Color.RED);
            tfWind.setForeground(Color.WHITE);
        }
        
        if (res2.getMain().getTemp() < 10) {
            tfTemperature1.setBackground(Color.BLUE);
            tfTemperature1.setForeground(Color.WHITE);
        } else if (res2.getMain().getTemp() < 18) {
            tfTemperature1.setBackground(Color.CYAN);
            tfTemperature1.setForeground(Color.BLACK);
        } else if (res2.getMain().getTemp() > 35) {
            tfTemperature1.setBackground(Color.RED);
            tfTemperature1.setForeground(Color.WHITE);
        } else if (res2.getMain().getTemp() > 25) {
            tfTemperature1.setBackground(Color.ORANGE);
            tfTemperature1.setForeground(Color.BLACK);
        } else {
            tfTemperature1.setBackground(Color.GREEN);
            tfTemperature1.setForeground(Color.BLACK);
        }
        if (res2.getMain().getHumidity() > 75) {
            tfHumidity1.setBackground(Color.BLUE);
            tfHumidity1.setForeground(Color.WHITE);
        } else if (res2.getMain().getHumidity() > 65) {
            tfHumidity1.setBackground(Color.CYAN);
            tfHumidity1.setForeground(Color.BLACK);
        } else {
            tfHumidity1.setBackground(Color.ORANGE);
            tfHumidity1.setForeground(Color.BLACK);
        }
        if (res2.getWind().getSpeed()<= 5) {
            tfWind1.setBackground(Color.GREEN);
            tfWind1.setForeground(Color.BLACK);
        } else if (res2.getWind().getSpeed() <= 13) {
            tfWind1.setBackground(Color.ORANGE);
            tfWind1.setForeground(Color.BLACK);
        } else {
            tfWind1.setBackground(Color.RED);
            tfWind1.setForeground(Color.WHITE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        WeatherTable = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfTemperature = new javax.swing.JTextField();
        tfPressure = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfHumidity = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfWind = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        WeatherTable1 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tfTemperature1 = new javax.swing.JTextField();
        tfPressure1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tfHumidity1 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tfWind1 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        TimeTable = new javax.swing.JTable();
        lbForecast = new javax.swing.JLabel();
        lbDest1 = new javax.swing.JLabel();
        lbDest2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Weather", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        WeatherTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(WeatherTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel7.setText("Temperature:");

        jLabel8.setText("Pressure:");

        tfTemperature.setEditable(false);

        tfPressure.setEditable(false);

        jLabel9.setText("Humidity:");

        tfHumidity.setEditable(false);

        jLabel10.setText("Wind:");

        tfWind.setEditable(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTemperature, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(tfPressure)
                    .addComponent(tfHumidity)
                    .addComponent(tfWind, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfTemperature, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(tfHumidity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tfWind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(tfPressure, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Weather", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        WeatherTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(WeatherTable1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel11.setText("Temperature:");

        jLabel12.setText("Pressure:");

        tfTemperature1.setEditable(false);

        tfPressure1.setEditable(false);

        jLabel13.setText("Humidity:");

        tfHumidity1.setEditable(false);

        jLabel14.setText("Wind:");

        tfWind1.setEditable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTemperature1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                    .addComponent(tfPressure1)
                    .addComponent(tfHumidity1)
                    .addComponent(tfWind1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfTemperature1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tfHumidity1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(tfWind1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tfPressure1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TimeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(TimeTable);

        lbForecast.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbForecast.setText("Forecast for Day: ");

        lbDest1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbDest1.setText("Dest1");

        lbDest2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbDest2.setText("Dest2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbForecast)
                            .addComponent(lbDest1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDest2)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lbForecast)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(lbDest1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbDest2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TimeTable;
    private javax.swing.JTable WeatherTable;
    private javax.swing.JTable WeatherTable1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lbDest1;
    private javax.swing.JLabel lbDest2;
    private javax.swing.JLabel lbForecast;
    private javax.swing.JTextField tfHumidity;
    private javax.swing.JTextField tfHumidity1;
    private javax.swing.JTextField tfPressure;
    private javax.swing.JTextField tfPressure1;
    private javax.swing.JTextField tfTemperature;
    private javax.swing.JTextField tfTemperature1;
    private javax.swing.JTextField tfWind;
    private javax.swing.JTextField tfWind1;
    // End of variables declaration//GEN-END:variables

}
