
package order;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import config.config;
import java.sql.ResultSet;
import java.sql.SQLException;


public class items extends javax.swing.JFrame {

   DefaultTableModel model;
    private addorders mainFrame; 

    public items(addorders mainFrame) {
        this.mainFrame = mainFrame;
        initComponents();
        setupTable();
        loadItemsFromDB();
        this.setLocationRelativeTo(null);
    }

    private void setupTable() {
        // Updated Columns: Name, Price, Select (Checkbox), Quantity
        String[] columns = {"Item Name", "Price", "Select", "Quantity"};
        model = new DefaultTableModel(columns, 0) {
            @Override
           public Class<?> getColumnClass(int columnIndex) {
    if (columnIndex == 2) return Boolean.class; // Select
    if (columnIndex == 1) return Double.class;  // Price
    if (columnIndex == 3) return Integer.class; // FIX: Ensure Qty is Integer
    return super.getColumnClass(columnIndex);

            }
            @Override
            public boolean isCellEditable(int row, int column) {
                // Only Checkbox (2) and Quantity (3) are editable
                return column == 2 || column == 3; 
            }
        };
        jTable3.setModel(model);

        // Listener for automatic calculation
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                // If checkbox or quantity changes
                if (e.getColumn() == 2 || e.getColumn() == 3) {
                    calculateGrandTotal();
                }
            }
        });
    }

    private void loadItemsFromDB() {
        config conf = new config();
        try {
            String sql = "SELECT p_item, p_price FROM masterlist"; 
            ResultSet rs = conf.getData(sql);
            
            while (rs.next()) {
                // ROW ORDER: Item Name (0), Price (1), Select (2), Qty (3)
                model.addRow(new Object[]{rs.getString("p_item"), rs.getDouble("p_price"), false, 0});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading items: " + e.getMessage());
        }
    }

    private void calculateGrandTotal() {
        double grandTotal = 0.0;
        for (int i = 0; i < model.getRowCount(); i++) {
            
            // Checkbox ("Select") is at Index 2
            boolean isSelected = (boolean) model.getValueAt(i, 2); 
            
            if (isSelected) {
                // Price is at Index 1
                double price = (double) model.getValueAt(i, 1); 
                
                // Quantity is at Index 3
                int qty = 0;
                try {
                    qty = Integer.parseInt(model.getValueAt(i, 3).toString());
                } catch (Exception e) {
                    qty = 0;
                }
                
                grandTotal += (price * qty);
            }
        }
        jLabelTotal.setText(String.format("%.2f", grandTotal));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        addtoorder = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabelTotal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 205, 208));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("SELECT ITEMS");

        addtoorder.setText("Add to Order");
        addtoorder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtoorderActionPerformed(evt);
            }
        });

        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jLabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("GRAND TOTAL:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addtoorder)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addtoorder, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_searchKeyReleased

    private void addtoorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtoorderActionPerformed
     StringBuilder selectedItems = new StringBuilder();
    double grandTotal = 0.0;
    boolean hasSelection = false;

    // IMPORTANT: Stop editing before reading values to ensure the latest data is in the model
    if (jTable3.isEditing()) {
        jTable3.getCellEditor().stopCellEditing();
    }

    for (int i = 0; i < model.getRowCount(); i++) {
        // 1. Get Selection (Boolean)
        boolean isSelected = (boolean) model.getValueAt(i, 2);

        if (isSelected) {
            hasSelection = true;
            // 2. Get Item Name (String)
            String itemName = model.getValueAt(i, 0).toString();
            // 3. Get Price (Double)
            double price = (double) model.getValueAt(i, 1);

            // 4. Get Quantity (Integer) - Safer Parsing
            int qty = 0;
            Object qtyObj = model.getValueAt(i, 3);
            if (qtyObj != null) {
                try {
                    // Try parsing from String or casting from Integer
                    qty = Integer.parseInt(qtyObj.toString());
                } catch (NumberFormatException e) {
                    qty = 0; // Invalid input treated as 0
                }
            }

            if (qty > 0) {
                selectedItems.append(itemName).append(" (x").append(qty).append("), ");
                grandTotal += (price * qty);
            }
        }
    }

    if (!hasSelection || grandTotal == 0.0) {
        JOptionPane.showMessageDialog(this, "Please select items and ensure quantity is greater than 0.");
        return;
    }

    // Remove trailing comma
    String finalItemsString = selectedItems.toString();
    if (finalItemsString.endsWith(", ")) {
        finalItemsString = finalItemsString.substring(0, finalItemsString.length() - 2);
    }

    // Send data back to main frame
    if (mainFrame != null) {
        mainFrame.setSelectedItems(finalItemsString, grandTotal);
    }
    this.dispose(); // Close frame

    
    }//GEN-LAST:event_addtoorderActionPerformed

    public static void main(String args[]) {
     java.awt.EventQueue.invokeLater(() -> {
            new items(null).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtoorder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
