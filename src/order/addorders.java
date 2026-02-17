
package order;

import config.config;
import javax.swing.JOptionPane;
import java.sql.ResultSet;    // Kinahanglan para sa pag-read sa data
import java.sql.SQLException;


public class addorders extends javax.swing.JFrame {

  public addorders() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        // 1. I-load ang Approved Workers sa ComboBox
        loadWorkers();
        
        // 2. I-set ang ComboBox para sa Items
        item.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { 
            "Select Item", "US", "P1", "P2", "P3", "P4", "OS" 
        }));
        
        // 3. I-set ang automatic fields
        totalammount.setEditable(false);
        orderstatus.setText("Pending");
        orderstatus.setEditable(false);
    }

   private void loadWorkers() {
    config conf = new config();
    try {
        // Gigamit na nato ang 'u_role' imbes 'u_type'
        String sql = "SELECT u_id, u_name FROM user WHERE u_status = 'approved' AND u_role = 'worker'";
        java.sql.ResultSet rs = conf.getData(sql);
        
        assignworker.removeAllItems();
        assignworker.addItem("Select Worker");
        
        while (rs.next()) {
            // "1 - Juan" ang format nga isulod sa ComboBox
            String workerDisplay = rs.getString("u_id") + " - " + rs.getString("u_name");
            assignworker.addItem(workerDisplay);
        }
    } catch (java.sql.SQLException e) {
        System.out.println("Error Loading Workers: " + e.getMessage());
    }
    }

    private void updateFinalTotal() {
        String selectedItem = item.getSelectedItem().toString();
        double price = 0;

        switch(selectedItem) {
            case "US": price = 2000; break;
            case "P1": price = 2200; break;
            case "P2": price = 2500; break;
            case "P3": price = 2800; break;
            case "P4": price = 3400; break;
            case "OS": price = 3700; break;
            default: price = 0; break;
        }

        try {
            if (!quantity.getText().isEmpty()) {
                int qty = Integer.parseInt(quantity.getText());
                double total = price * qty;
                totalammount.setText(String.valueOf(total));
            } else {
                totalammount.setText("0.00");
            }
        } catch (NumberFormatException e) {
            totalammount.setText("0.00");
        }
    }
    
    private void clearFields() {
        customername.setText("");
        phonenumber.setText("");
        address.setText("");
        quantity.setText("");
        totalammount.setText("0.00");
        date.setText("");
        item.setSelectedIndex(0);
        assignworker.setSelectedIndex(0);
        orderstatus.setText("Pending");
    }



   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        customername = new javax.swing.JTextField();
        phonenumber = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        quantity = new javax.swing.JTextField();
        totalammount = new javax.swing.JTextField();
        orderstatus = new javax.swing.JTextField();
        item = new javax.swing.JComboBox<>();
        assignworker = new javax.swing.JComboBox<>();
        save = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 205, 208));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("ADD ORDER");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Customer Name:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Phone Number:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText(" Address:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Item:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Quantity:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Assign to Worker:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Total ammount:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Order Status:");

        customername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customernameActionPerformed(evt);
            }
        });

        phonenumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phonenumberActionPerformed(evt);
            }
        });

        address.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressActionPerformed(evt);
            }
        });

        quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityActionPerformed(evt);
            }
        });
        quantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                quantityKeyReleased(evt);
            }
        });

        totalammount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalammountActionPerformed(evt);
            }
        });

        orderstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                orderstatusActionPerformed(evt);
            }
        });

        item.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemActionPerformed(evt);
            }
        });

        assignworker.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Date:");

        date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateActionPerformed(evt);
            }
        });

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel1)
                        .addGap(0, 177, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(customername)
                            .addComponent(phonenumber)
                            .addComponent(address)
                            .addComponent(quantity)
                            .addComponent(totalammount)
                            .addComponent(orderstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(item, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(assignworker, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(date))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(save, javax.swing.GroupLayout.DEFAULT_SIZE, 71, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(customername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(phonenumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(item, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)))
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(assignworker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(totalammount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(orderstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void customernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_customernameActionPerformed

    private void phonenumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phonenumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phonenumberActionPerformed

    private void addressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressActionPerformed

    private void quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityActionPerformed

    private void totalammountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalammountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalammountActionPerformed

    private void orderstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderstatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_orderstatusActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
  config conf = new config();
    
    // 1. KUHAON ANG MGA INPUTS
    String name = customername.getText();
    String phone = phonenumber.getText();
    String addr = address.getText();
    String selectedItem = item.getSelectedItem().toString();
    String qty = quantity.getText();
    String d = date.getText();
    String status = orderstatus.getText();
    String total = totalammount.getText();

    // 2. KANI ANG IMONG PANGUTANA (Ang pagkuha sa ngalan lang)
    // Kuhaon ang text sa JComboBox (pananglitan: "1 - Juan")
    String fullWorkerInfo = assignworker.getSelectedItem().toString();
    String workerNameOnly = "";

    // Atong i-check kon dili ba "Select Worker" ang napili
    if (!fullWorkerInfo.equals("Select Worker")) {
        // I-split ang string gamit ang " - "
        // Ang [0] kay ang ID, ang [1] kay ang Ngalan
        String[] parts = fullWorkerInfo.split(" - ");
        if (parts.length > 1) {
            workerNameOnly = parts[1]; // Kani ang "Juan"
        } else {
            workerNameOnly = fullWorkerInfo;
        }
    }

    // 3. VALIDATION
    if(name.isEmpty() || workerNameOnly.isEmpty()){
        JOptionPane.showMessageDialog(this, "Palihog pili og Worker!");
        return;
    }

    // 4. I-SAVE SA DATABASE
    // Gamiton nato ang 'workerNameOnly' para mo-match sa worder frame
    String sql = "INSERT INTO OrdersTable (customer_name, phone_number, address, item, quantity, worker, total_amount, order_date, order_status) "
               + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    
    conf.addRecord(sql, name, phone, addr, selectedItem, qty, workerNameOnly, total, d, status);
    
    JOptionPane.showMessageDialog(this, "Successfully Saved!");
    
    // Balik sa Dashboard
    orders ord = new orders(); 
    ord.setVisible(true);
    this.dispose();

    }//GEN-LAST:event_saveActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemActionPerformed
        updateFinalTotal();

    }//GEN-LAST:event_itemActionPerformed

    private void quantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantityKeyReleased
       updateFinalTotal();
    }//GEN-LAST:event_quantityKeyReleased

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
      // USBA ang 'OrderDash' kung unsay saktong ngalan sa imong main order frame
    orders ord = new orders(); 
    ord.setVisible(true);
    this.dispose(); // I-close kining 'addorders' nga frame


    }//GEN-LAST:event_backActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(addorders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addorders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addorders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addorders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addorders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField address;
    public javax.swing.JComboBox<String> assignworker;
    public javax.swing.JButton back;
    public javax.swing.JTextField customername;
    public javax.swing.JTextField date;
    public javax.swing.JComboBox<String> item;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField orderstatus;
    public javax.swing.JTextField phonenumber;
    public javax.swing.JTextField quantity;
    public javax.swing.JButton save;
    public javax.swing.JTextField totalammount;
    // End of variables declaration//GEN-END:variables
}
