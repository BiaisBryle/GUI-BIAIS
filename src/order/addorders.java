
package order;

import config.config;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;

public class addorders extends javax.swing.JFrame {

 public addorders() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        // 1. I-load ang workers gikan sa database
        loadWorkers();
        
        // 2. I-load ang mga items gikan sa imong Master List table
        loadItemsFromMasterlist();
        
        // 3. I-set ang automatic fields
        totalammount.setEditable(false);
        orderstatus.setText("Pending");
        orderstatus.setEditable(false);
        id_field.setVisible(false);
    }

    // KUHAON ANG ITEMS GIKAN SA MASTERLIST TABLE PARA SA COMBOBOX
    private void loadItemsFromMasterlist() {
        config conf = new config();
        try {
            String sql = "SELECT p_item FROM masterlist";
            ResultSet rs = conf.getData(sql);
            item.removeAllItems();
            item.addItem("Select Item");
            while (rs.next()) {
                item.addItem(rs.getString("p_item"));
            }
        } catch (SQLException e) {
            System.out.println("Error Loading Items: " + e.getMessage());
        }
    }

    // KUHAON ANG APPROVED WORKERS
    private void loadWorkers() {
        config conf = new config();
        try {
            String sql = "SELECT u_id, u_name FROM user WHERE u_status = 'approved' AND u_role = 'worker'";
            ResultSet rs = conf.getData(sql);
            assignworker.removeAllItems();
            assignworker.addItem("Select worker");
            while (rs.next()) {
                String workerDisplay = rs.getString("u_id") + " - " + rs.getString("u_name");
                assignworker.addItem(workerDisplay);
            }
        } catch (SQLException e) {
            System.out.println("Error Loading Workers: " + e.getMessage());
        }
    }

    // AUTOMATIC NGA PRESYO GIKAN SA MASTERLIST DILI NA HARDCODED
    private void updateFinalTotal() {
        // 1. I-check kung null ba ang napili (Kini ang fix sa NullPointerException)
    if (item.getSelectedItem() == null) {
        return; 
    }

    String selectedItem = item.getSelectedItem().toString();

    // 2. Ayaw ipadayon kung "Select Item" ang napili
    if (selectedItem.equals("Select Item") || selectedItem.isEmpty()) {
        totalammount.setText("0.00");
        return;
    }

    config conf = new config();
    try {
        String sql = "SELECT p_price FROM masterlist WHERE p_item = '" + selectedItem + "'";
        ResultSet rs = conf.getData(sql);
        
        if (rs.next()) {
            // Siguraduha nga ang "p_price" dili null sa DB
            double price = rs.getDouble("p_price");
            
            if (!quantity.getText().isEmpty()) {
                int qty = Integer.parseInt(quantity.getText());
                double total = price * qty;
                totalammount.setText(String.valueOf(total));
            } else {
                totalammount.setText("0.00");
            }
        }
    } catch (SQLException | NumberFormatException e) {
        totalammount.setText("0.00");
    }
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
        id_field = new javax.swing.JTextField();

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

        save.setBackground(new java.awt.Color(153, 153, 153));
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

        back.setBackground(new java.awt.Color(153, 153, 153));
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addComponent(id_field, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(id_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    
    String name = customername.getText().trim();
    String phone = phonenumber.getText().trim();
    String addr = address.getText().trim();
    String selectedItem = (item.getSelectedItem() != null) ? item.getSelectedItem().toString() : "";
    String qtyText = quantity.getText().trim();
    String total = totalammount.getText().trim();
    String d = date.getText().trim();
    String status = orderstatus.getText().trim();
    String id = id_field.getText(); // Importante kini para sa Update

    Object selectedWorker = assignworker.getSelectedItem();
    String workerNameOnly = (selectedWorker != null && !selectedWorker.toString().equals("Select worker")) 
                            ? selectedWorker.toString().split(" - ")[1] : "";

    if (name.isEmpty() || qtyText.isEmpty() || selectedItem.equals("Select Item")) {
        JOptionPane.showMessageDialog(this, "Please fill out all the fields!");
        return;
    }

    try {
        int newOrderQty = Integer.parseInt(qtyText);
        
        // 1. KUHAON ANG CURRENT STOCK SA MASTERLIST
        String checkStockSql = "SELECT p_quantity FROM masterlist WHERE p_item = '" + selectedItem + "'";
        ResultSet rsStock = conf.getData(checkStockSql);
        
        if (rsStock.next()) {
            int currentMasterStock = rsStock.getInt("p_quantity");

            // KUNG "UPDATE" ANG BUTTON (Nag-edit og existing order)
            if (save.getText().equals("Update")) {
                // A. Kuhaon ang DAAN nga quantity gikan sa OrdersTable sa wala pa gi-edit
                String oldQtySql = "SELECT quantity FROM OrdersTable WHERE o_id = '" + id + "'";
                ResultSet rsOld = conf.getData(oldQtySql);
                
                if (rsOld.next()) {
                    int oldOrderQty = rsOld.getInt("quantity");
                    
                    // B. I-calculate ang adjustment
                    // Pananglitan: Daang Order = 50, Bag-ong Order = 2. 
                    // Adjustment = 50 - 2 = +48 (i-balik sa stock)
                    int stockAdjustment = oldOrderQty - newOrderQty;

                    if (currentMasterStock + stockAdjustment < 0) {
                        JOptionPane.showMessageDialog(this, "Cannot update! Not enough stock.");
                        return;
                    }

                    // C. UPDATE ORDERSTABLE
                    String updateOrderSql = "UPDATE OrdersTable SET customer_name=?, phone_number=?, address=?, item=?, quantity=?, worker=?, total_amount=?, order_date=? WHERE o_id=?";
                    conf.updateRecord(updateOrderSql, name, phone, addr, selectedItem, String.valueOf(newOrderQty), workerNameOnly, total, d, id);

                    // D. UPDATE MASTERLIST STOCK (Adjustment)
                    int updatedMasterStock = currentMasterStock + stockAdjustment;
                    String updateMasterSql = "UPDATE masterlist SET p_quantity = ? WHERE p_item = ?";
                    conf.updateRecord(updateMasterSql, String.valueOf(updatedMasterStock), selectedItem);

                    JOptionPane.showMessageDialog(this, "Order Updated & Stock Adjusted!");
                }
            } 
            // KUNG "SAVE" ANG BUTTON (Bag-ong order)
            else {
                if (currentMasterStock < newOrderQty) {
                    JOptionPane.showMessageDialog(this, "Insufficient stock!: " + currentMasterStock);
                    return;
                }

                String insertSql = "INSERT INTO OrdersTable (customer_name, phone_number, address, item, quantity, worker, total_amount, order_date, order_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                conf.addRecord(insertSql, name, phone, addr, selectedItem, qtyText, workerNameOnly, total, d, status);

                int updatedMasterStock = currentMasterStock - newOrderQty;
                String updateMasterSql = "UPDATE masterlist SET p_quantity = ? WHERE p_item = ?";
                conf.updateRecord(updateMasterSql, String.valueOf(updatedMasterStock), selectedItem);

                JOptionPane.showMessageDialog(this, "Order Saved & Stock Deducted!");
            }

            new orders().setVisible(true);
            this.dispose();
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }

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
     new orders().setVisible(true);
        this.dispose();


    }//GEN-LAST:event_backActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new addorders().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField address;
    public javax.swing.JComboBox<String> assignworker;
    public javax.swing.JButton back;
    public javax.swing.JTextField customername;
    public javax.swing.JTextField date;
    public javax.swing.JTextField id_field;
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
