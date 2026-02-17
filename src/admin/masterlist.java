
package admin;
import config.config; // Siguraduha nga sakto ang path sa imong config class
import java.sql.SQLException;
import javax.swing.JOptionPane;



public class masterlist extends javax.swing.JFrame {

public masterlist() {
  
        initComponents();
           this.setLocationRelativeTo(null);
        // Gi-set nato ang ComboBox models para sure nga naay sulod ang listahan
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Item", "US", "P1", "P2", "P3", "P4", "OS" }));
        // I-set ang Total Amount field as non-editable para dili ma-manual change
        jTextField3.setEditable(false);
    }

  private void calculateTotal() {
        try {
            if (jTextField1.getText().isEmpty() || jTextField2.getText().isEmpty()) {
                jTextField3.setText("0.00");
                return;
            }
            double price = Double.parseDouble(jTextField1.getText());
            int qty = Integer.parseInt(jTextField2.getText());
            double total = price * qty;
            jTextField3.setText(String.valueOf(total));
        } catch (NumberFormatException e) {
            jTextField3.setText("0.00");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        save = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 205, 208));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Item Code:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 120, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Price:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 60, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Quantity:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Total Amount:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Assign Rider:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, -1, -1));

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 90, 30));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 90, 30));

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 90, 30));

        add.setBackground(new java.awt.Color(153, 153, 153));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, 60, -1));

        update.setBackground(new java.awt.Color(153, 153, 153));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 80, -1, -1));

        delete.setBackground(new java.awt.Color(153, 153, 153));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel1.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, -1, -1));

        save.setBackground(new java.awt.Color(153, 153, 153));
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 90, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setText("Master List");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 132, 90, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 90, 30));

        back.setBackground(new java.awt.Color(153, 153, 153));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 335, 90, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
      config conf = new config();
        
        String itemCode = jComboBox1.getSelectedItem().toString();
        String price = jTextField1.getText();
        String qty = jTextField2.getText();
        String total = jTextField3.getText();
        String rider = jComboBox2.getSelectedItem().toString();

        if (itemCode.equals("Select Item") || qty.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Palihog butangi og Item Code ug Quantity!");
            return;
        }

        // INSERT SQL Query (Siguraduha nga ang table name nimo sakto sa database)
        String sql = "INSERT INTO deliveries (item_code, price, quantity, total_amount, rider_name) VALUES (?, ?, ?, ?, ?)";
        
        // Gamiton ang addRecord gikan sa imong config class
        conf.addRecord(sql, itemCode, price, qty, total, rider);
        
        JOptionPane.showMessageDialog(this, "Successfully Saved!");
        
        // Clear fields human ma-save
        jTextField2.setText("");
        jTextField3.setText("");
        jComboBox1.setSelectedIndex(0);
    
    }//GEN-LAST:event_saveActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
     String item = jComboBox1.getSelectedItem().toString();
        switch(item) {
            case "US": jTextField1.setText("2000"); break;
            case "P1": jTextField1.setText("2200"); break;
            case "P2": jTextField1.setText("2500"); break;
            case "P3": jTextField1.setText("2800"); break;
            case "P4": jTextField1.setText("3400"); break;
            case "OS": jTextField1.setText("3700"); break;
            default: jTextField1.setText("0"); break;
        }
        calculateTotal(); // Re-calculate total if code changes
    
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        calculateTotal();
    }//GEN-LAST:event_jTextField2KeyReleased

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        admindashboard ord = new admindashboard(); 
    ord.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_backActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new masterlist().setVisible(true);
        });
       
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton back;
    private javax.swing.JButton delete;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JButton save;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
