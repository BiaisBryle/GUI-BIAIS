package order;

import admin.admindashboard;
import admin.masterlist;
import admin.profile;
import admin.usertable;
import config.config;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class orders extends javax.swing.JFrame {

    public orders() {
        initComponents();
        displayTable(); 
        this.setLocationRelativeTo(null);
    }
    
    public void displayTable() {
        String searchTerm = jTextField1.getText(); 
        String sql = "SELECT o_id, customer_name, phone_number, address, item, total_amount, order_status, worker_id, order_date FROM OrdersTable "
               + "WHERE customer_name LIKE '%" + searchTerm + "%' "
               + "OR address LIKE '%" + searchTerm + "%' "
               + "OR o_id LIKE '%" + searchTerm + "%' ";

        try {
            config conf = new config(); 
            conf.displayData(sql, OrdersTable); 
            
            // --- KINI NGA PART ANG MO-LOCK SA TABLE ---
            TableModel model = OrdersTable.getModel();
            DefaultTableModel nonEditableModel = new DefaultTableModel() {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Dili ma-edit ang cells
                }
            };

            // I-copy ang headers
            for (int i = 0; i < model.getColumnCount(); i++) {
                nonEditableModel.addColumn(model.getColumnName(i));
            }

            // I-copy ang data
            for (int i = 0; i < model.getRowCount(); i++) {
                Object[] rowData = new Object[model.getColumnCount()];
                for (int j = 0; j < model.getColumnCount(); j++) {
                    rowData[j] = model.getValueAt(i, j);
                }
                nonEditableModel.addRow(rowData);
            }

            OrdersTable.setModel(nonEditableModel);

        } catch (Exception e) {
            System.out.println("Error displaying data: " + e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        search = new javax.swing.JPanel();
        home = new javax.swing.JButton();
        userstable = new javax.swing.JButton();
        profile = new javax.swing.JButton();
        orders = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        OrdersTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        search.setBackground(new java.awt.Color(245, 205, 208));
        search.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home.setBackground(new java.awt.Color(153, 153, 153));
        home.setText("HOME");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        search.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 120, 40));

        userstable.setBackground(new java.awt.Color(153, 153, 153));
        userstable.setText("USERS");
        userstable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userstableActionPerformed(evt);
            }
        });
        search.add(userstable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 120, 40));

        profile.setBackground(new java.awt.Color(153, 153, 153));
        profile.setText("PROFILE");
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });
        search.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 120, 40));

        orders.setBackground(new java.awt.Color(153, 153, 153));
        orders.setText("ORDERS");
        orders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersActionPerformed(evt);
            }
        });
        search.add(orders, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 120, 40));

        logout.setBackground(new java.awt.Color(153, 153, 153));
        logout.setText("LOG OUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        search.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 120, 40));

        add.setBackground(new java.awt.Color(153, 153, 153));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        search.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 80, 30));

        update.setBackground(new java.awt.Color(153, 153, 153));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        search.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 80, 30));

        delete.setBackground(new java.awt.Color(153, 153, 153));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        search.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 80, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("ORDERS");
        search.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        search.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 80, 20));

        OrdersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        OrdersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OrdersTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(OrdersTable);

        search.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 350, 270));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setText("MASTER LIST");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        search.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 120, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ordersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ordersActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
       addorders addFrame = new addorders(); // 1. Create the new frame
    addFrame.setVisible(true);            // 2. Make it show up
    this.dispose();
    }//GEN-LAST:event_addActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
      displayTable();
    
    }//GEN-LAST:event_jTextField1KeyReleased

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
       int rowIndex = OrdersTable.getSelectedRow();
    if(rowIndex < 0){
        JOptionPane.showMessageDialog(null, "Please select a row from the table!");
    } else {
        try {
            config conf = new config();
            TableModel model = OrdersTable.getModel();
            String id = model.getValueAt(rowIndex, 0).toString();
            
            // Atong i-check ang status (Note: Na-move ang index sa status kay nagdugang tag column sa SELECT)
            // Sa bag-ong SELECT sa ibabaw, ang status naa na sa index 6
            String status = model.getValueAt(rowIndex, 6).toString(); 

            if(status.equalsIgnoreCase("Delivered")){
                JOptionPane.showMessageDialog(null, "This order cannot be updated because it has already been DELIVERED!", "Warning", JOptionPane.WARNING_MESSAGE);
                return; 
            }

            ResultSet rs = conf.getData("SELECT * FROM OrdersTable WHERE o_id = '" + id + "'");
            if(rs.next()){
                addorders addFrame = new addorders();
                
                // KINI ANG IMPORTANTE: I-set ang phone number field
                addFrame.customername.setText(rs.getString("customer_name"));
                addFrame.phonenumber.setText(rs.getString("phone_number")); // Siguroha nga 'phonenumber' ang name sa field sa addorders
                addFrame.address.setText(rs.getString("address"));
                addFrame.totalammount.setText(rs.getString("total_amount"));
                addFrame.orderstatus.setText(rs.getString("order_status"));
                addFrame.date.setText(rs.getString("order_date"));
                
                // I-save ang current ID para UPDATE ang mahitabo, dili INSERT
                addFrame.currentOrderId = Integer.parseInt(id); 
                
                addFrame.setSelectedItems(rs.getString("item"), rs.getDouble("total_amount"));
                
                addFrame.save.setText("Update");
                addFrame.setVisible(true);
                this.dispose();
            }
        } catch(SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }


    
    }//GEN-LAST:event_updateActionPerformed
    
    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
     int rowIndex = OrdersTable.getSelectedRow();
        if(rowIndex < 0){
            JOptionPane.showMessageDialog(null, "Please select a row to delete!");
        } else {
            try {
                config conf = new config();
                TableModel model = OrdersTable.getModel();
                String id = model.getValueAt(rowIndex, 0).toString();
                
                int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this?", "Confirm", JOptionPane.YES_NO_OPTION);
                if(response == JOptionPane.YES_OPTION){
                    conf.deleteRecord("DELETE FROM OrdersTable WHERE o_id = ?", id);
                    displayTable(); 
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    
    
    }//GEN-LAST:event_deleteActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
       new admindashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeActionPerformed

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
       new profile().setVisible(true); // No arguments needed
        this.dispose();
    }//GEN-LAST:event_profileActionPerformed

    private void userstableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userstableActionPerformed
        new usertable().setVisible(true); // No arguments needed
        this.dispose();
    }//GEN-LAST:event_userstableActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
       int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            new main.login().setVisible(true); 
            this.dispose(); 
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        masterlist ml = new masterlist();
        ml.setVisible(true);

        // Mo-close ang Dashboard para dili daghan og windows nga abli
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void OrdersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OrdersTableMouseClicked
                                     
   if (evt.getClickCount() == 2) { 
            int rowIndex = OrdersTable.getSelectedRow();
            if (rowIndex >= 0) {
                TableModel model = OrdersTable.getModel();
                
                String id = model.getValueAt(rowIndex, 0).toString();      
                String name = model.getValueAt(rowIndex, 1).toString();    
                String item = model.getValueAt(rowIndex, 4).toString();    
                String total = model.getValueAt(rowIndex, 5).toString();   
                String status = model.getValueAt(rowIndex, 6).toString();  
                
                String unitPrice = "0.00";

                try {
                    config conf = new config();
                    String cleanItemName = item.split(" ")[0]; 
                    
                    // --- KANI NGA LINE ANG USBA ---
                    // Giusab nako gikan sa p_name ngadto sa p_item
                    String query = "SELECT p_price FROM masterlist WHERE p_item LIKE '" + cleanItemName + "%'";
                    ResultSet rs = conf.getData(query);
                    
                    if (rs.next()) {
                        unitPrice = rs.getString("p_price");
                    } else {
                        unitPrice = total; // Fallback kung walay nakit-an
                    }
                } catch (Exception e) {
                    System.out.println("Error fetching unit price: " + e.getMessage());
                    unitPrice = total;
                }

                // I-pasa ang 8 parameters sa Receipt
                Worker.Receipt rec = new Worker.Receipt(id, name, item, total, "0.00", "0.00", status, unitPrice);
                rec.setVisible(true);
            }
        }
    
    
    }//GEN-LAST:event_OrdersTableMouseClicked

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(orders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> {
            new orders().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable OrdersTable;
    private javax.swing.JButton add;
    private javax.swing.JButton delete;
    private javax.swing.JButton home;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton logout;
    private javax.swing.JButton orders;
    private javax.swing.JButton profile;
    private javax.swing.JPanel search;
    private javax.swing.JButton update;
    private javax.swing.JButton userstable;
    // End of variables declaration//GEN-END:variables
}
