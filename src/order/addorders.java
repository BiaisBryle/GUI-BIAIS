package order;

import config.config;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import java.text.SimpleDateFormat;
import java.util.Date;

// Helper class para sa Worker Dropdown
class WorkerItem {
    int id;
    String name;

    public WorkerItem(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " - " + name; 
    }

    public int getId() {
        return id;
    }
}

public class addorders extends javax.swing.JFrame {
    public int currentOrderId = 0; // 0 means NEW order, >0 means EDITing existing order
    private String selectedItemsList = "";
    private items itemsFrame; 
    
    public addorders() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        loadWorkers(); 
        
        // Setup defaults
        totalammount.setEditable(false);
        orderstatus.setText("Pending");
        orderstatus.setEditable(false);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        date.setText(sdf.format(new Date()));
        date.setEditable(false);
        
        // Siguroha nga inig close sa window, dili ma-exit ang tibuok program
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void loadWorkers() {
        config conf = new config();
        try {
            // Siguroha nga husto ang table name ug column names sa imong DB
            String sql = "SELECT u_id, u_name FROM user WHERE u_status = 'approved' AND u_role = 'worker'";
            ResultSet rs = conf.getData(sql);
            
            DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>();
            model.addElement("-- Select Worker --");
            
            while (rs.next()) {
                model.addElement(new WorkerItem(rs.getInt("u_id"), rs.getString("u_name")));
            }
            assignworker.setModel(model);
            
        } catch (SQLException e) {
            System.out.println("Error Loading Workers: " + e.getMessage());
        }
    }

    // Method tawgon gikan sa items.java
    public void setSelectedItems(String itemsName, double total) {
        this.selectedItemsList = itemsName;
        jButton1.setText("Items Selected (" + String.format("%.2f", total) + ")"); 
        totalammount.setText(String.format("%.2f", total));
        this.setEnabled(true); // I-re-enable ang main frame
        this.toFront();        // Ibalhin sa atubangan ang addorders
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
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        customername = new javax.swing.JTextField();
        phonenumber = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        totalammount = new javax.swing.JTextField();
        orderstatus = new javax.swing.JTextField();
        assignworker = new javax.swing.JComboBox<>();
        save = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        date = new javax.swing.JTextField();
        back = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

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

        assignworker.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        assignworker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignworkerActionPerformed(evt);
            }
        });

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

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SELECT ITEMS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel10)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(jLabel9)
                                .addComponent(jLabel7)
                                .addComponent(jLabel4))
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(customername)
                            .addComponent(phonenumber)
                            .addComponent(address)
                            .addComponent(totalammount)
                            .addComponent(orderstatus, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                            .addComponent(assignworker, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(date)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                            .addComponent(jLabel4)))
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(assignworker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalammount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(orderstatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        String total = totalammount.getText().trim();
        String d = date.getText().trim();
        String status = orderstatus.getText().trim();
        
        Object selectedObj = assignworker.getSelectedItem();
        String workerIdToSave = "0"; 
        
        if (selectedObj instanceof WorkerItem) {
            workerIdToSave = String.valueOf(((WorkerItem) selectedObj).getId());
        }

        // Validation - Importante!
        if (name.isEmpty() || selectedItemsList.isEmpty() || workerIdToSave.equals("0")) {
            JOptionPane.showMessageDialog(this, "Please fill out all required fields (Name, Worker, and Items)!");
            return;
        }

        try {
            if (this.currentOrderId == 0) { 
                // Siguroha nga husto ang table name `OrdersTable` sa imong DB
                String insertSql = "INSERT INTO OrdersTable (customer_name, phone_number, address, item, worker_id, total_amount, order_date, order_status) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                conf.addRecord(insertSql, name, phone, addr, selectedItemsList, workerIdToSave, total, d, status);
                JOptionPane.showMessageDialog(this, "Order Added Successfully!");
            } else {
                String updateSql = "UPDATE OrdersTable SET customer_name = ?, phone_number = ?, address = ?, item = ?, worker_id = ?, total_amount = ?, order_status = ? WHERE o_id = ?";
                conf.updateRecord(updateSql, name, phone, addr, selectedItemsList, workerIdToSave, total, status, String.valueOf(this.currentOrderId));
                JOptionPane.showMessageDialog(this, "Order Updated Successfully!");
            }

            // Human og save, balik sa orders list
            new orders().setVisible(true);
            if(itemsFrame != null) itemsFrame.dispose();
            this.dispose();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Database Error: " + e.getMessage());
        }
    
    }//GEN-LAST:event_saveActionPerformed

    private void dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
     new orders().setVisible(true);
        if(itemsFrame != null) itemsFrame.dispose(); 
        this.dispose();
    

    }//GEN-LAST:event_backActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      itemsFrame = new items(this, selectedItemsList); 
    itemsFrame.setVisible(true); 

    }//GEN-LAST:event_jButton1ActionPerformed

    private void assignworkerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignworkerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_assignworkerActionPerformed


    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new addorders().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField address;
    public javax.swing.JComboBox<Object> assignworker;
    public javax.swing.JButton back;
    public javax.swing.JTextField customername;
    public javax.swing.JTextField date;
    public javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField orderstatus;
    public javax.swing.JTextField phonenumber;
    public javax.swing.JButton save;
    public javax.swing.JTextField totalammount;
    // End of variables declaration//GEN-END:variables
}
