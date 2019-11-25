
package GUI;

import BL.Destination;
import javax.swing.JOptionPane;

public class DestinationDialog extends javax.swing.JDialog {

    private Destination newDest;
    private boolean ok;
    
    public DestinationDialog(java.awt.Frame parent, boolean modal, Destination dest) {
        super(parent, modal);
        initComponents();
        
        if(dest != null){
            tfZip.setText(dest.getZip());
            tfDest.setText(dest.getName());
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tfDest = new javax.swing.JTextField();
        tfZip = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btSave = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add / Edit Destination");

        tfDest.setName("tfZip"); // NOI18N

        tfZip.setName("tfZip"); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Zip");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Name");

        btSave.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btSave.setText("Save");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        btCancel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btCancel.setText("Cancel");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(btCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfZip, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                                .addComponent(tfDest))
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfZip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSave)
                    .addComponent(btCancel))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        if(tfZip.getText().equals("")&&tfDest.getText().equals("")){
            JOptionPane.showMessageDialog(null, "You can't leave both fields empty!");
        }
        newDest = new Destination(tfDest.getText(), tfZip.getText());
        ok = true;
        
        dispose();
    }//GEN-LAST:event_btSaveActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        ok = false;
        
        dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    public boolean isOk() {
        return ok;
    }

    public Destination getNewDest() {
        return newDest;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btSave;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tfDest;
    private javax.swing.JTextField tfZip;
    // End of variables declaration//GEN-END:variables
}
