
package admin;

import config.config; 
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class masterlist extends javax.swing.JFrame {

public masterlist() {
        initComponents();
        this.setLocationRelativeTo(null);
        
        // I-load ang tanang data inig sugod (empty string para walay filter)
        displayData(""); 
    }

    // Giusab nato kini: Nagdawat na siya og "String keyword"
    public void displayData(String keyword) {
        config conf = new config();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // I-clear ang table sa dili pa mo-load

        try {
            // SQL query nga naay LIKE para sa search functionality
            String sql = "SELECT * FROM masterlist WHERE p_item LIKE '%" + keyword + "%'";
            ResultSet rs = conf.getData(sql);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("p_item"), 
                    rs.getString("p_quantity"), 
                    rs.getString("p_price")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Loading Data: " + e.getMessage());
        }
    }

    // Overloaded method para sa mga karaan nga tawag nga walay parameter
    public void displayData() {
        displayData("");
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        save = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 205, 208));
        jPanel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add.setBackground(new java.awt.Color(153, 153, 153));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 60, -1));

        update.setBackground(new java.awt.Color(153, 153, 153));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, -1, -1));

        delete.setBackground(new java.awt.Color(153, 153, 153));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel1.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, -1, -1));

        save.setBackground(new java.awt.Color(153, 153, 153));
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 90, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel3.setText("Master List");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        back.setBackground(new java.awt.Color(153, 153, 153));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 360, 90, 30));

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
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 170, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Quantity", "Price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 430, 230));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
     String name = JOptionPane.showInputDialog(this, "Enter Product Name:");
        String qty = JOptionPane.showInputDialog(this, "Enter Quantity:");
        String price = JOptionPane.showInputDialog(this, "Enter Price:");
        
        if (name != null && !name.isEmpty() && qty != null && price != null) {
            config conf = new config();
            String sql = "INSERT INTO masterlist (p_item, p_quantity, p_price) VALUES (?, ?, ?)";
            conf.addRecord(sql, name, qty, price);
            displayData(""); 
        }
    }//GEN-LAST:event_addActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
      int row = jTable1.getSelectedRow();
        if (row != -1) {
            String name = jTable1.getValueAt(row, 0).toString();
            String currentQty = jTable1.getValueAt(row, 1).toString();
            String currentPrice = jTable1.getValueAt(row, 2).toString();
            
            String newQty = JOptionPane.showInputDialog(this, "Update Quantity:", currentQty);
            String newPrice = JOptionPane.showInputDialog(this, "Update Price:", currentPrice);
            
            if (newQty != null && newPrice != null) {
                config conf = new config();
                String sql = "UPDATE masterlist SET p_quantity = ?, p_price = ? WHERE p_item = ?";
                conf.updateRecord(sql, newQty, newPrice, name);
                displayData(""); 
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pili una og row!");
        }
    
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
      int row = jTable1.getSelectedRow();
        if (row != -1) {
            String name = jTable1.getValueAt(row, 0).toString();
            int confirm = JOptionPane.showConfirmDialog(this, "I-delete ang " + name + "?", "Confirm", JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                config conf = new config();
                String sql = "DELETE FROM masterlist WHERE p_item = ?";
                conf.updateRecord(sql, name); 
                displayData(""); 
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pili una og row!");
        }
    }//GEN-LAST:event_deleteActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        displayData(""); 
        search.setText(""); 
        JOptionPane.showMessageDialog(this, "Table Refreshed!");
    }//GEN-LAST:event_saveActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
       new admindashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        displayData(search.getText());
    }//GEN-LAST:event_searchKeyReleased

    public static void main(String args[]) {
       java.awt.EventQueue.invokeLater(() -> {
            new masterlist().setVisible(true);
        });
       
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton back;
    private javax.swing.JButton delete;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton save;
    private javax.swing.JTextField search;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables

}