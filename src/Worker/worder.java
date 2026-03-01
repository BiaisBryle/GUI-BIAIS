
package Worker;

import config.Session;
import config.config; 
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public final class worder extends javax.swing.JFrame {
    config conf = new config();
    String currentworker = "";

    public worder(String workerName) {
        initComponents();
        this.currentworker = workerName; 
        this.setLocationRelativeTo(null);
        displayOrders(); 
    }

    public worder() {
       initComponents();
    this.setLocationRelativeTo(null);
   
    this.currentworker = String.valueOf(Session.getInstance().getId()); 
    displayOrders();
    }

    public void displayOrders() {
  
   try {
        String searchTerm = search.getText().trim();
        
        // Siguraduhing may laman ang currentworker (dapat ito ay ID)
        if (currentworker == null || currentworker.isEmpty()) {
            System.out.println("No worker logged in or invalid ID.");
            return;
        }

        // BAGONG SQL QUERY: Gumamit ng worker_id (INT) sa halip na pangalan
        String sql = "SELECT o_id, customer_name, phone_number, address, item, total_amount, order_status " +
                     "FROM OrdersTable WHERE worker_id = " + currentworker + " " + // <--- Walang single quotes kung ID ay number sa DB
                     "AND order_status = 'Pending' " +
                     "AND (customer_name LIKE '%" + searchTerm + "%' " +
                     "OR item LIKE '%" + searchTerm + "%' " +
                     "OR order_status LIKE '%" + searchTerm + "%' " +
                     "OR CAST(total_amount AS CHAR) LIKE '%" + searchTerm + "%')";
        
        config.displayData(sql, jTable1);
        
    } catch (Exception e) {
        System.out.println("Error display: " + e.getMessage());
    }


    }

    private void changeOrderStatus(String newStatus) {
        int rowIndex = jTable1.getSelectedRow();
        
        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Please select the order from the table first!");
            return;
        }
        
        TableModel model = jTable1.getModel();
        String id = model.getValueAt(rowIndex, 0).toString(); 
        
        int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to " + newStatus + " this?", "Confirmation", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            // Gamiton nato ang updateRecord gikan sa imong config class
            String sql = "UPDATE OrdersTable SET order_status = ? WHERE o_id = ?";
            
            try {
                conf.updateRecord(sql, newStatus, id);
                JOptionPane.showMessageDialog(null, "Order Successfully " + newStatus);
               displayOrders(); 
        
            transactions.displayTransactions();
                
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        canceled = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        delivered = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 205, 208));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 470, 290));

        canceled.setBackground(new java.awt.Color(153, 153, 153));
        canceled.setText("CANCELED");
        canceled.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                canceledActionPerformed(evt);
            }
        });
        jPanel1.add(canceled, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 100, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("NEEDED TO DELIVER");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, -1));

        delivered.setBackground(new java.awt.Color(153, 153, 153));
        delivered.setText("DELIVERED");
        delivered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveredActionPerformed(evt);
            }
        });
        jPanel1.add(delivered, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 360, -1, 30));

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
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 140, -1));

        back.setBackground(new java.awt.Color(153, 153, 153));
        back.setText("BACK");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        jPanel1.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 399, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void deliveredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveredActionPerformed
       changeOrderStatus("Delivered");
    }//GEN-LAST:event_deliveredActionPerformed

    private void canceledActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_canceledActionPerformed
       changeOrderStatus("Canceled");
    }//GEN-LAST:event_canceledActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
       new workerdashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
      displayOrders();
    }//GEN-LAST:event_searchActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
      displayOrders();
    }//GEN-LAST:event_searchKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         java.awt.EventQueue.invokeLater(() -> {
            new worder().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton canceled;
    private javax.swing.JButton delivered;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
