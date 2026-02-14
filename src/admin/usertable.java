
package admin;

import config.config;
import net.proteanit.sql.DbUtils;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import config.Session;
import admin.admindashboard;

public class usertable extends javax.swing.JFrame {
    
  public usertable() { 
  
    
       initComponents();
    this.setLocationRelativeTo(null);
    
    displayUser(""); 
   
   
    }
    
   void displayUser(String searchTerm) {

   
        try {
        // Gidugangan nato ang u_role ug u_status sa WHERE clause
        String sql = "SELECT u_id, u_name, u_lname, u_email, u_role, u_status, u_address, u_gender FROM user "
                   + "WHERE u_name LIKE '%" + searchTerm + "%' "
                   + "OR u_lname LIKE '%" + searchTerm + "%' "
                   + "OR u_email LIKE '%" + searchTerm + "%' "
                   + "OR u_role LIKE '%" + searchTerm + "%' " 
                   + "OR u_status LIKE '%" + searchTerm + "%'";

        config conf = new config(); 
        conf.displayData(sql, usertable); 

        if (usertable.getColumnCount() >= 8) {
            usertable.getColumnModel().getColumn(6).setMinWidth(0);
            usertable.getColumnModel().getColumn(6).setMaxWidth(0);
            usertable.getColumnModel().getColumn(7).setMinWidth(0);
            usertable.getColumnModel().getColumn(7).setMaxWidth(0);
        }
    } catch (Exception e) {
        System.out.println("Error displaying data: " + e.getMessage());
    }


   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        usertable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        profile = new javax.swing.JButton();
        home = new javax.swing.JButton();
        Usertable = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        approvedbotton = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        orders = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 205, 208));

        usertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(usertable);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("USERS");

        profile.setBackground(new java.awt.Color(153, 153, 153));
        profile.setText("PROFILE");
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });

        home.setBackground(new java.awt.Color(153, 153, 153));
        home.setText("HOME");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        Usertable.setBackground(new java.awt.Color(153, 153, 153));
        Usertable.setText("USERS");
        Usertable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsertableActionPerformed(evt);
            }
        });

        logout.setBackground(new java.awt.Color(153, 153, 153));
        logout.setText("LOG OUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        approvedbotton.setBackground(new java.awt.Color(153, 153, 153));
        approvedbotton.setText("Approved Botton");
        approvedbotton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approvedbottonActionPerformed(evt);
            }
        });

        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        add.setBackground(new java.awt.Color(153, 153, 153));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(153, 153, 153));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(153, 153, 153));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        orders.setBackground(new java.awt.Color(153, 153, 153));
        orders.setText("ORDERS");
        orders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                            .addComponent(profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Usertable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(orders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(delete, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(approvedbotton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(add)
                    .addComponent(update)
                    .addComponent(delete)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Usertable, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(orders, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(approvedbotton)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 429, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
  new admindashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeActionPerformed

    private void UsertableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsertableActionPerformed
    displayUser(search.getText());
    }//GEN-LAST:event_UsertableActionPerformed

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
      new profile().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_profileActionPerformed

    private void approvedbottonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approvedbottonActionPerformed
                                             
    int rowIndex = usertable.getSelectedRow();
    
    if (rowIndex < 0) {
        JOptionPane.showMessageDialog(null, "Please select a user to approve!");
    } else {
        // 1. Kuhaon ang status sa user gikan sa table (Column 5 ang u_status sa imong SQL SELECT)
        String currentStatus = usertable.getModel().getValueAt(rowIndex, 5).toString();
        
        // 2. I-check kung 'Approved' na ba ang status
        if (currentStatus.equalsIgnoreCase("Approved")) {
            JOptionPane.showMessageDialog(null, "This user is already approved!");
        } else {
            // 3. Kung wala pa ma-approve, mangutana na sa confirmation
            int confirm = JOptionPane.showConfirmDialog(null, 
                    "Are you sure you want to approve this user?", 
                    "Approval Confirmation", 
                    JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                String id = usertable.getModel().getValueAt(rowIndex, 0).toString();
                String sql = "UPDATE user SET u_status = 'approved' WHERE u_id = ?";
                
                config.updateRecord(sql, id); 
                
                JOptionPane.showMessageDialog(null, "User Approved!");
                
                // Refresh the table
                displayUser(search.getText());
            }
        }
    }
    
    



    }//GEN-LAST:event_approvedbottonActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
  int confirm = JOptionPane.showConfirmDialog(
                null,
                "Are you sure you want to log out?",
                "Logout",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            new main.login().setVisible(true);
            this.dispose();
        }
    
        
    

    }//GEN-LAST:event_logoutActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed

    }//GEN-LAST:event_searchActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
   int rowIndex = usertable.getSelectedRow();
    
    if (rowIndex < 0) {
        JOptionPane.showMessageDialog(null, "Please select a user to update!");
    } else {
        // Kuhaon ang model sa table
        javax.swing.table.TableModel model = usertable.getModel();
        
        // Tawgon ang updateform ug ipasa ang model ug ang napili nga row
        updateform uf = new updateform(model, rowIndex);
        uf.setVisible(true);
        
        // Opsyonal: I-close o i-hide ang usertable
        this.dispose(); 
    }

    }//GEN-LAST:event_updateActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
     updateform uf = new updateform();
    uf.setVisible(true);
    
  
    this.dispose();
    

    }//GEN-LAST:event_addActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
    int rowIndex = usertable.getSelectedRow();
        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Please select a user to delete!");
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, "Delete this user?", "Confirm", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                String id = usertable.getModel().getValueAt(rowIndex, 0).toString();
                String sql = "DELETE FROM user WHERE u_id = ?";
                config.updateRecord(sql, id); // ✅ FIX: Ginamit ang updateRecord para sa delete
                JOptionPane.showMessageDialog(null, "User deleted successfully!");
                 displayUser(search.getText());
            }
        }


    }//GEN-LAST:event_deleteActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        displayUser(search.getText());
    }//GEN-LAST:event_searchKeyReleased

    private void ordersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ordersActionPerformed

    
     public static void main(String args[]) {
     java.awt.EventQueue.invokeLater(() -> {
            new usertable().setVisible(true);
        });
 
    }

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Usertable;
    private javax.swing.JButton add;
    private javax.swing.JButton approvedbotton;
    private javax.swing.JButton delete;
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton logout;
    private javax.swing.JButton orders;
    private javax.swing.JButton profile;
    private javax.swing.JTextField search;
    private javax.swing.JButton update;
    private javax.swing.JTable usertable;
    // End of variables declaration//GEN-END:variables

   
}