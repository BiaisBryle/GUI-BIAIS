package admin;

import config.config;
import javax.swing.JOptionPane;

public class addmasterlist extends javax.swing.JFrame {

    public addmasterlist() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        productname = new javax.swing.JTextField();
        quantity = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        save = new javax.swing.JButton();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 205, 208));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("MASTERLIST");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 150, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("PRODUCT NAME:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 110, -1, 50));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("QUANTITY:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("PRICE:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        productname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                productnameActionPerformed(evt);
            }
        });
        jPanel1.add(productname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 150, 20));

        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });
        jPanel1.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 150, -1));

        price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                priceActionPerformed(evt);
            }
        });
        jPanel1.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 150, -1));

        save.setBackground(new java.awt.Color(153, 153, 153));
        save.setText("SAVE");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, 80, 40));

        back.setBackground(new java.awt.Color(153, 153, 153));
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 330, 90, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void productnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_productnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_productnameActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
       String name = productname.getText().trim();
        String qty = quantity.getText().trim();
        String prc = price.getText().trim();

        if (name.isEmpty() || qty.isEmpty() || prc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please complete all fields!");
            return;
        }

        config conf = new config();

        // Check kung ang Label kay "UPDATE ITEM"
        if (jLabel1.getText().equals("UPDATE ITEM")) {
            // UPDATE LOGIC
            String sql = "UPDATE masterlist SET p_quantity = ?, p_price = ? WHERE p_item = ?";
            conf.updateRecord(sql, qty, prc, name);
            JOptionPane.showMessageDialog(this, "Successfully Updated!");
        } else {
            // INSERT LOGIC
            String sql = "INSERT INTO masterlist (p_item, p_quantity, p_price) VALUES (?, ?, ?)";
            conf.addRecord(sql, name, qty, prc);
            JOptionPane.showMessageDialog(this, "Successfully Added!");
        }

        // Balik sa Masterlist table human og save
        new masterlist().setVisible(true);
        this.dispose();
    
    }//GEN-LAST:event_saveActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
       new masterlist().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void priceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_priceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_priceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new addmasterlist().setVisible(true);
        });
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField price;
    public javax.swing.JTextField productname;
    public javax.swing.JTextField quantity;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}
