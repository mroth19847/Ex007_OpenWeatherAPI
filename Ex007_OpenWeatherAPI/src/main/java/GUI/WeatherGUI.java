package GUI;

import BL.DataClasses.Destination;
import BL.Models.DestinationModel;
import BL.DataClasses.ForecastListObject;
import BL.Models.ForecastListObjectModel;
import BL.Models.ForecastModel;
import BL.Responses.ForecastResponse;
import BL.DataClasses.Main;
import BL.Responses.OpenWeatherResponse;
import BL.Models.OpenWeatherResponseModel;
import BL.Models.WeatherModel;
import BL.DataClasses.Wind;
import GUI.Renderer.WeatherCellRenderer;
import REST.OpenWeatherAPIHandler;
import XML.XMLAccess;
import java.awt.Color;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class WeatherGUI extends javax.swing.JFrame {

    private DestinationModel bl;
    public static String travelDay;
    private OpenWeatherResponseModel tableM;
    private ForecastModel forecastM;
    private ForecastListObjectModel floM;
    private boolean forecastMode;
    private boolean travelDayUsed;

    /**
     * The default WeatherGUI constructor sets imports the saved destinations from a xml file and adds selection-changed events
     * to the ResponseTable and to the ForecastTable
     */
    public WeatherGUI() {
        initComponents();
        ForecastPanel.setVisible(false);
        WeatherTable.setRowHeight(35);
        WeatherTable.setDefaultRenderer(Object.class, new WeatherCellRenderer());
        try {
            bl = XMLAccess.importXML();
        } catch (Exception ex) {
            bl = new DestinationModel();
        }
        DestinationList.setModel(bl);

        ResponseTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {
                    if (ResponseTable.getSelectedRow() > -1) {
                        if (forecastMode) {
                            updateGUI2(floM.getObjectAt(ResponseTable.getSelectedRow()));
                        } else {
                            updateGUI1(tableM.getResponseAt(ResponseTable.getSelectedRow()));
                        }
                    }
                }
            }
        });

        ForecastTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting()) {
                    if (ForecastTable.getSelectedRow() > -1) {
                        if (!travelDay.equals("")) {
                            floM = new ForecastListObjectModel(forecastM.getResponseAt(ForecastTable.getSelectedRow()).getList(), travelDay);
                        } else {
                            floM = new ForecastListObjectModel(forecastM.getResponseAt(ForecastTable.getSelectedRow()).getList());
                        }
                        ResponseTable.setModel(floM);
                    }
                }
            }
        });
        tableM = new OpenWeatherResponseModel();
        ResponseTable.setModel(tableM);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ForecastContextMenu = new javax.swing.JPopupMenu();
        sortTemp = new javax.swing.JMenuItem();
        sortHum = new javax.swing.JMenuItem();
        sortPres = new javax.swing.JMenuItem();
        compateDest = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfTemperature = new javax.swing.JTextField();
        tfPressure = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        tfHumidity = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        tfWind = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        ResponseTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        WeatherTable = new javax.swing.JTable();
        ForecastPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ForecastTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lbZip = new javax.swing.JLabel();
        tfZip = new javax.swing.JTextField();
        lbDest = new javax.swing.JLabel();
        tfDest = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        DestinationList = new javax.swing.JList<>();
        jLabel4 = new javax.swing.JLabel();
        btRun = new javax.swing.JButton();
        btRundSave = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        btAdd = new javax.swing.JButton();
        btEdit = new javax.swing.JButton();
        btDelete = new javax.swing.JButton();
        btRunAll = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btChangeMode = new javax.swing.JButton();

        sortTemp.setText("Sort by temperature");
        sortTemp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortTempActionPerformed(evt);
            }
        });
        ForecastContextMenu.add(sortTemp);

        sortHum.setText("Sort by humidity");
        sortHum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortHumActionPerformed(evt);
            }
        });
        ForecastContextMenu.add(sortHum);

        sortPres.setText("Sort by pressure");
        sortPres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortPresActionPerformed(evt);
            }
        });
        ForecastContextMenu.add(sortPres);

        compateDest.setText("Compare destinations");
        compateDest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compateDestActionPerformed(evt);
            }
        });
        ForecastContextMenu.add(compateDest);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Current Weather", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

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
                    .addComponent(tfTemperature, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
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

        ResponseTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(ResponseTable);

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
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        ForecastTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        ForecastTable.setComponentPopupMenu(ForecastContextMenu);
        jScrollPane5.setViewportView(ForecastTable);

        javax.swing.GroupLayout ForecastPanelLayout = new javax.swing.GroupLayout(ForecastPanel);
        ForecastPanel.setLayout(ForecastPanelLayout);
        ForecastPanelLayout.setHorizontalGroup(
            ForecastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        ForecastPanelLayout.setVerticalGroup(
            ForecastPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4)
                    .addComponent(ForecastPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ForecastPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Input", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        lbZip.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbZip.setText("Zip");

        tfZip.setName("tfZip"); // NOI18N

        lbDest.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbDest.setText("Destination Name");

        tfDest.setName("tfZip"); // NOI18N

        DestinationList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        DestinationList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                DestinationListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(DestinationList);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Saved Destinations");

        btRun.setText("Run");
        btRun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRunActionPerformed(evt);
            }
        });

        btRundSave.setText("Run & Save Destination");
        btRundSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRundSaveActionPerformed(evt);
            }
        });

        jPanel4.setLayout(new java.awt.GridLayout(1, 3, 5, 0));

        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btEdit.setText("Change");
        btEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditActionPerformed(evt);
            }
        });

        btDelete.setText("Delete");
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });

        btRunAll.setText("Run All Destinations");
        btRunAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRunAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfZip, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btRun, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btRundSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tfDest, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btDelete))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbDest)
                            .addComponent(lbZip)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btRunAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(lbZip)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbDest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btRun)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btRundSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btRunAll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btDelete)
                        .addComponent(btEdit)
                        .addComponent(btAdd)))
                .addGap(1277, 1277, 1277))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Weather App");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btChangeMode.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btChangeMode.setText("Change to Forecast Mode");
        btChangeMode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btChangeModeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btChangeMode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btChangeMode, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * The actionperformed event for btAdd opens the DestinationDialog for adding a new Destination Object to the WeatherBL
     * @param evt 
     */
    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        DestinationDialog dlg = new DestinationDialog(this, true, null);
        dlg.setVisible(true);
        if (dlg.isOk()) {
            try {
                bl.add(dlg.getNewDest());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btAddActionPerformed

    /**
     * The actionperformed event for btEdit opens the the DestinationDialog with a specific selected destination in order to change
     * it in the WeatherBL, as long as a destination is selected in the list
     * @param evt 
     */
    private void btEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditActionPerformed
        if (DestinationList.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "Select an entry!");
        } else {
            Destination selected = (Destination) bl.getElementAt(DestinationList.getSelectedIndex());
            DestinationDialog dlg = new DestinationDialog(this, true, selected);
            dlg.setVisible(true);
            if (dlg.isOk()) {
                try {
                    bl.edit(DestinationList.getSelectedIndex(), dlg.getNewDest());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btEditActionPerformed

    /**
     * The actionperformed event for btDelete checks if a destination is selected in the list, and if yes, removes it using the delete
     * method in the WheaterBL
     * @param evt 
     */
    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        if (DestinationList.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "Select an entry!");
        } else {
            Destination selected = (Destination) bl.getElementAt(DestinationList.getSelectedIndex());
            int reply = JOptionPane.showConfirmDialog(null, "Do you really want to delete the following entry: " + selected.toString(), "Confirm", JOptionPane.YES_NO_OPTION);
            if (reply == JOptionPane.YES_OPTION) {
                bl.delete(DestinationList.getSelectedIndex());
            }
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    /**
     * The formWindowClosing event will save the destinations to a xml file before closing the GUI
     * @param evt 
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            XMLAccess.exportXML(bl);
        } catch (IOException ex) {
            Logger.getLogger(WeatherGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * The DestinationListValueChanged event is for displaying the values of the selected entry in the destnation-name and zip 
     * textfields
     * @param evt 
     */
    private void DestinationListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_DestinationListValueChanged
        if (DestinationList.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "Select an entry!");
        } else {
            Destination selected = (Destination) bl.getElementAt(DestinationList.getSelectedIndex());
            tfDest.setText(selected.getName());
            tfZip.setText(selected.getZip());
        }
    }//GEN-LAST:event_DestinationListValueChanged

    /**
     * The actionperformed event of btRun has two functions:
     * 1 - ForecastMode is enabled:
     *      The method checks if the inputted date is in the correct format, than it will save it into the travelDay variable
     *      Then it will get a ForecastResponse for each destination using the OpenWeatherAPIHandler method getForecast() in order to
     *      display them in the ForecastList - the travelDayUsed boolean is set to true
     * 2 - ForecastMode is disabled:
     *      The method will call the OpenWeatherAPIHandler method getCurrentInformation() using the current values in the 
     *      destination-name and zip textfields
     * @param evt 
     */
    private void btRunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRunActionPerformed
        if (forecastMode) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            try {
                String dateStr = tfDest.getText();
                LocalDate date = LocalDate.parse(dateStr, dtf);
                travelDay = date.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                ArrayList<ForecastResponse> list = new ArrayList<>();
                for (Destination dest : bl.getDestList()) {
                    try {
                        list.add(OpenWeatherAPIHandler.getForecast(dest));
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
                forecastM = new ForecastModel(list);
                ForecastTable.setModel(forecastM);
                ResponseTable.setModel(new DefaultTableModel());
                travelDayUsed = true;
            } catch (DateTimeParseException dtpe) {
                JOptionPane.showMessageDialog(null, "Wrong date format!");
            }
        } else {
            if (tfDest.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "You cannot leave the destination field empty!");
            } else {
                try {
                    Destination dest = new Destination(tfDest.getText(), tfZip.getText());
                    OpenWeatherResponse res = OpenWeatherAPIHandler.getCurrentInformation(dest);
                    tableM.add(res);
                    updateGUI1(res);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
    }//GEN-LAST:event_btRunActionPerformed
   
    /**
     * The actionperformed event of btRundSave has two functions:
     * 1 - ForecastMode is enabled:
     *      The will get a ForecastResponse for each destination using the OpenWeatherAPIHandler method getForecast() in order to
     *      display them in the ForecastList - the travelDayUsed boolean is set to false
     * 2 - ForecastMode is disabled:
     *      The method will call the OpenWeatherAPIHandler method getCurrentInformation() using the current values in the 
     *      destination-name and zip textfields and wil try to add them to the WeatherBL
     * @param evt 
     */
    private void btRundSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRundSaveActionPerformed
        if (forecastMode) {
            ArrayList<ForecastResponse> list = new ArrayList<>();
            for (Destination dest : bl.getDestList()) {
                try {
                    list.add(OpenWeatherAPIHandler.getForecast(dest));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
            forecastM = new ForecastModel(list);
            ForecastTable.setModel(forecastM);
            travelDay = "";
            travelDayUsed = false;
        } else {
            Destination newDest = new Destination(tfDest.getText(), tfZip.getText());
            try {
                OpenWeatherResponse res = OpenWeatherAPIHandler.getCurrentInformation(newDest);
                bl.add(newDest);
                tableM.add(res);
                updateGUI1(res);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btRundSaveActionPerformed

    /**
     * The actionperformed event of btChangeMode is for changing from the forecast mode to normal mode or the other way around
     * Every time the event is triggered, the GUI is cleared 
     * @param evt 
     */
    private void btChangeModeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btChangeModeActionPerformed
        if (!forecastMode) {
            forecastMode = true;
            btChangeMode.setText("Change to Normal Mode");
            lbZip.setVisible(false);
            tfZip.setVisible(false);
            btRunAll.setVisible(false);
            ForecastPanel.setVisible(true);
            lbDest.setText("Travel Day (dd.MM.yyyy)");
            btRun.setText("travel day forecast");
            btRundSave.setText("5 day forecast");
            jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Forecast", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14)));
            ResponseTable.setModel(new DefaultTableModel());
        } else {
            forecastMode = false;
            btChangeMode.setText("Change to Forecast Mode");
            lbZip.setVisible(true);
            tfZip.setVisible(true);
            btRunAll.setVisible(true);
            ForecastPanel.setVisible(false);
            lbDest.setText("Destination Name");
            btRun.setText("Run");
            btRundSave.setText("Run & Save Destination");
            jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Current Weather", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14)));
            tableM = new OpenWeatherResponseModel();
            ResponseTable.setModel(tableM);
        }
        tfDest.setText("");
        tfTemperature.setBackground(new Color(240, 240, 240));
        tfTemperature.setForeground(Color.BLACK);
        tfTemperature.setText("");
        tfHumidity.setBackground(new Color(240, 240, 240));
        tfHumidity.setForeground(Color.BLACK);
        tfHumidity.setText("");
        tfWind.setBackground(new Color(240, 240, 240));
        tfWind.setForeground(Color.BLACK);
        tfWind.setText("");
        tfPressure.setText("");
        ForecastTable.setModel(new DefaultTableModel());
        WeatherTable.setModel(new DefaultTableModel());
    }//GEN-LAST:event_btChangeModeActionPerformed

    /**
     * The method will call the OpenWeatherAPIHandler method getCurrentInformation() for all destinations in the WeatherBL in order
     * to show them in the ResponseTable
     * @param evt 
     */
    private void btRunAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRunAllActionPerformed
        for (Destination dest : bl.getDestList()) {
            OpenWeatherResponse res;
            try {
                res = OpenWeatherAPIHandler.getCurrentInformation(dest);
                tableM.add(res);
                updateGUI1(res);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_btRunAllActionPerformed

    /**
     * The actionperformed event of the sortTemp menuItem is for calling the sortByTemp method in the current ForecastModel
     * @param evt 
     */
    private void sortTempActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortTempActionPerformed
        forecastM.sortByTemp();
    }//GEN-LAST:event_sortTempActionPerformed

    /**
     * The actionperformed event of the sortHum menuItem is for calling the sortByHum method in the current ForecastModel
     * @param evt 
     */
    private void sortHumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortHumActionPerformed
        forecastM.sortByHum();
    }//GEN-LAST:event_sortHumActionPerformed

    /**
     * The actionperformed event of the sortPres menuItem is for calling the sortByPres method in the current ForecastModel
     * @param evt 
     */
    private void sortPresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortPresActionPerformed
        forecastM.sortByPres();
    }//GEN-LAST:event_sortPresActionPerformed

    /**
     * If the travelDayUsed variable is true, the method will check if two ForecastResponses are selected and will open the
     * CompareDestGUI with the two selected Responses as paramters
     * @param evt 
     */
    private void compateDestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compateDestActionPerformed
        if(travelDayUsed){
            if(ForecastTable.getSelectedRows().length == 2){
                ForecastResponse f1 = forecastM.getResponseAt(ForecastTable.getSelectedRows()[0]);
                ForecastResponse f2 = forecastM.getResponseAt(ForecastTable.getSelectedRows()[1]);
                CompareDestGUI form = new CompareDestGUI(f1, f2);
                form.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "You have to select 2 destinations for this feature!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "You have to use a travel day for this feature!");
        }
    }//GEN-LAST:event_compateDestActionPerformed

    /**
     * The updateGUI1 method is used in normal mode for displaying the Weather Information for a OpenWeatherResponse
     * It will also cal lthe manageColors method for coloring the textfields
     * @param res 
     */
    private void updateGUI1(OpenWeatherResponse res) {
        tfTemperature.setText(String.format("%.2f °C", res.getMain().getTemp()));
        tfPressure.setText(res.getMain().getPressure() + " hpa");
        tfHumidity.setText(res.getMain().getHumidity() + "%");
        tfWind.setText(res.getWind().getDeg() + "° @ " + res.getWind().getSpeed() + "m/s");
        WeatherTable.setModel(new WeatherModel(res.getWeather()));
        manageColors(res.getMain(), res.getWind());
    }

    /**
     * The updateGUI2 method is used in forecast mode for displaying the Weather Information for a ForecastListObject
     * It will also cal lthe manageColors method for coloring the textfields
     * @param res 
     */
    private void updateGUI2(ForecastListObject res) {
        tfTemperature.setText(String.format("%.2f °C", res.getMain().getTemp()));
        tfPressure.setText(res.getMain().getPressure() + " hpa");
        tfHumidity.setText(res.getMain().getHumidity() + "%");
        tfWind.setText(res.getWind().getDeg() + "° @ " + res.getWind().getSpeed() + "m/s");
        WeatherTable.setModel(new WeatherModel(res.getWeather()));
        manageColors(res.getMain(), res.getWind());
    }

    /**
     * The updateGUI method is for coloring the weather information textfields by using the main and the wind parameter
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
     * @param main The given Main Object
     * @param wind The given Wind Object
     */
    private void manageColors(Main main, Wind wind) {
        if (main.getTemp() < 10) {
            tfTemperature.setBackground(Color.BLUE);
            tfTemperature.setForeground(Color.WHITE);
        } else if (main.getTemp() < 18) {
            tfTemperature.setBackground(Color.CYAN);
            tfTemperature.setForeground(Color.BLACK);
        } else if (main.getTemp() > 35) {
            tfTemperature.setBackground(Color.RED);
            tfTemperature.setForeground(Color.WHITE);
        } else if (main.getTemp() > 25) {
            tfTemperature.setBackground(Color.ORANGE);
            tfTemperature.setForeground(Color.BLACK);
        } else {
            tfTemperature.setBackground(Color.GREEN);
            tfTemperature.setForeground(Color.BLACK);
        }
        if (main.getHumidity() > 75) {
            tfHumidity.setBackground(Color.BLUE);
            tfHumidity.setForeground(Color.WHITE);
        } else if (main.getHumidity() > 65) {
            tfHumidity.setBackground(Color.CYAN);
            tfHumidity.setForeground(Color.BLACK);
        } else {
            tfHumidity.setBackground(Color.ORANGE);
            tfHumidity.setForeground(Color.BLACK);
        }
        if (wind.getSpeed() <= 5) {
            tfWind.setBackground(Color.GREEN);
            tfWind.setForeground(Color.BLACK);
        } else if (wind.getSpeed() <= 13) {
            tfWind.setBackground(Color.ORANGE);
            tfWind.setForeground(Color.BLACK);
        } else {
            tfWind.setBackground(Color.RED);
            tfWind.setForeground(Color.WHITE);
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WeatherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WeatherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WeatherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WeatherGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WeatherGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> DestinationList;
    private javax.swing.JPopupMenu ForecastContextMenu;
    private javax.swing.JPanel ForecastPanel;
    private javax.swing.JTable ForecastTable;
    private javax.swing.JTable ResponseTable;
    private javax.swing.JTable WeatherTable;
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btChangeMode;
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btEdit;
    private javax.swing.JButton btRun;
    private javax.swing.JButton btRunAll;
    private javax.swing.JButton btRundSave;
    private javax.swing.JMenuItem compateDest;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lbDest;
    private javax.swing.JLabel lbZip;
    private javax.swing.JMenuItem sortHum;
    private javax.swing.JMenuItem sortPres;
    private javax.swing.JMenuItem sortTemp;
    private javax.swing.JTextField tfDest;
    private javax.swing.JTextField tfHumidity;
    private javax.swing.JTextField tfPressure;
    private javax.swing.JTextField tfTemperature;
    private javax.swing.JTextField tfWind;
    private javax.swing.JTextField tfZip;
    // End of variables declaration//GEN-END:variables

}
