
package order;

import admin.admindashboard;
import admin.masterlist;
import admin.profile;
import admin.usertable;
import config.config;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.TableModel;


public class orders extends javax.swing.JFrame {

public orders() {
        initComponents();
        displayTable(); 
        this.setLocationRelativeTo(null);
    }
    
    public void displayTable() {
        String searchTerm = jTextField1.getText(); 
        // SQL Query para sa search functionality
        String sql = "SELECT o_id, customer_name, address, order_status FROM OrdersTable "
                   + "WHERE customer_name LIKE '%" + searchTerm + "%' "
                   + "OR address LIKE '%" + searchTerm + "%' "
                   + "OR o_id LIKE '%" + searchTerm + "%'";

        try {
            config conf = new config(); 
            conf.displayData(sql, OrdersTable); 
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
      displayTable(); // Calls the search logic every time you type
    
    }//GEN-LAST:event_jTextField1KeyReleased

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
       int rowIndex = OrdersTable.getSelectedRow();

        if(rowIndex < 0){
            JOptionPane.showMessageDialog(null, "Palihog pili og row sa table!");
        } else {
            try {
                config conf = new config();
                TableModel model = OrdersTable.getModel();
                String id = model.getValueAt(rowIndex, 0).toString();
                
                ResultSet rs = conf.getData("SELECT * FROM OrdersTable WHERE o_id = '" + id + "'");
                
                if(rs.next()){
                    addorders addFrame = new addorders();
                    
                    // I-load ang mga text fields
                    addFrame.id_field.setText(rs.getString("o_id")); 
                    addFrame.customername.setText(rs.getString("customer_name"));
                    addFrame.phonenumber.setText(rs.getString("phone_number"));
                    addFrame.address.setText(rs.getString("address"));
                    addFrame.quantity.setText(rs.getString("quantity"));
                    addFrame.totalammount.setText(rs.getString("total_amount"));
                    addFrame.date.setText(rs.getString("order_date"));
                    addFrame.orderstatus.setText(rs.getString("order_status"));
                    
                    // --- COMBO BOX LOGIC PARA SA UPDATE ---
                    String currentItem = rs.getString("item").trim();
                    String currentWorkerName = rs.getString("worker").trim();

                    addFrame.item.setSelectedItem(currentItem);

                    // Para sa worker, kay "ID - Name" man ang format sa ComboBox:
                    for (int i = 0; i < addFrame.assignworker.getItemCount(); i++) {
                        String itemText = addFrame.assignworker.getItemAt(i).toString();
                        if (itemText.contains(currentWorkerName)) {
                            addFrame.assignworker.setSelectedIndex(i);
                            break;
                        }
                    }
                    
                    addFrame.save.setText("Update"); // Usba ang button text
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
            JOptionPane.showMessageDialog(null, "Palihog pili og row nga papason!");
        } else {
            int response = JOptionPane.showConfirmDialog(null, "Sigurado ka nga papason kini?", "Confirm", JOptionPane.YES_NO_OPTION);
            
            if(response == JOptionPane.YES_OPTION){
                config conf = new config();
                TableModel model = OrdersTable.getModel();
                String id = model.getValueAt(rowIndex, 0).toString();
                conf.deleteRecord("DELETE FROM OrdersTable WHERE o_id = ?", id);
                displayTable(); 
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

    /**
     * @param args the command line arguments
     */
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new orders().setVisible(true);
            }
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
