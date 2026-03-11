
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
        // Columns: 0:Name, 1:Price, 2:Select, 3:Quantity, 4:Stock (Hidden Column)
        String[] columns = {"Item Name", "Price", "Select", "Quantity", "Available Stock"};
        model = new DefaultTableModel(columns, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 2) return Boolean.class; // Checkbox
                if (columnIndex == 1) return Double.class;  // Price
                if (columnIndex == 3 || columnIndex == 4) return Integer.class; // Qty & Stock
                return super.getColumnClass(columnIndex);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                // Checkbox (2) ug Quantity (3) ra ang pwedeng usbon sa user
                return column == 2 || column == 3;
            }
        };
        jTable3.setModel(model);

        // I-hide ang 'Available Stock' column (Index 4) para dili makit-an sa user
        jTable3.getColumnModel().getColumn(4).setMinWidth(0);
        jTable3.getColumnModel().getColumn(4).setMaxWidth(0);
        jTable3.getColumnModel().getColumn(4).setPreferredWidth(0);

        // Listener para sa automatic calculation ug stock validation
        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                // Kon ang checkbox (2) o quantity (3) ang gi-usab
                if (e.getColumn() == 2 || e.getColumn() == 3) {
                    calculateGrandTotal();
                }
            }
        });
    }

    private void loadItemsFromDB() {
        config conf = new config();
        try {
            // Naggamit og 'p_quantity' base sa imong database column
            String sql = "SELECT p_item, p_price, p_quantity FROM masterlist";
            ResultSet rs = conf.getData(sql);

            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("p_item"), 
                    rs.getDouble("p_price"), 
                    false, 
                    0, 
                    rs.getInt("p_quantity") // I-save ang stock limit diri
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading items: " + e.getMessage());
        }
    }

    private void calculateGrandTotal() {
        double grandTotal = 0.0;
        for (int i = 0; i < model.getRowCount(); i++) {
            boolean isSelected = (boolean) model.getValueAt(i, 2);

            if (isSelected) {
                double price = (double) model.getValueAt(i, 1);
                int stockAvailable = (int) model.getValueAt(i, 4); // Stock gikan sa DB
                int qty = 0;

                try {
                    qty = Integer.parseInt(model.getValueAt(i, 3).toString());
                    
                    // --- STOCK VALIDATION ---
                    if (qty > stockAvailable) {
                        JOptionPane.showMessageDialog(this, 
                            "Insufficient stock! Only " +  model.getValueAt(i, 0) + " 'units of " + stockAvailable + " are available. ");
                        model.setValueAt(stockAvailable, i, 3); // I-reset sa max stock
                        qty = stockAvailable;
                    }
                    if (qty < 0) {
                        model.setValueAt(0, i, 3);
                        qty = 0;
                    }
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
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 205, 208));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("SELECT ITEMS");

        addtoorder.setBackground(new java.awt.Color(153, 153, 153));
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

        Back.setBackground(new java.awt.Color(153, 153, 153));
        Back.setText("Back");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

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
                        .addComponent(Back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addtoorder, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addtoorder, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
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
        String query = search.getText().toLowerCase();
        config conf = new config();
        model.setRowCount(0); 
        try {
            // Updated SQL to include p_quantity for search results
            String sql = "SELECT p_item, p_price, p_quantity FROM masterlist WHERE p_item LIKE '%" + query + "%'";
            ResultSet rs = conf.getData(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("p_item"), 
                    rs.getDouble("p_price"), 
                    false, 
                    0, 
                    rs.getInt("p_quantity")
                });
            }
        } catch (SQLException e) {
            System.out.println("Search error: " + e.getMessage());
        }
    
    }//GEN-LAST:event_searchKeyReleased

    private void addtoorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtoorderActionPerformed
     StringBuilder selectedItems = new StringBuilder();
        double grandTotal = 0.0;
        boolean hasSelection = false;

        if (jTable3.isEditing()) {
            jTable3.getCellEditor().stopCellEditing();
        }

        for (int i = 0; i < model.getRowCount(); i++) {
            boolean isSelected = (boolean) model.getValueAt(i, 2);

            if (isSelected) {
                String itemName = model.getValueAt(i, 0).toString();
                double price = (double) model.getValueAt(i, 1);
                int qty = 0;
                
                try {
                    qty = Integer.parseInt(model.getValueAt(i, 3).toString());
                } catch (Exception e) { qty = 0; }

                if (qty > 0) {
                    hasSelection = true;
                    selectedItems.append(itemName).append(" (x").append(qty).append("), ");
                    grandTotal += (price * qty);
                }
            }
        }

        if (!hasSelection) {
            JOptionPane.showMessageDialog(this, "Palihug pag-pili og item ug butangi og quantity.");
            return;
        }

        String finalItemsString = selectedItems.toString();
        if (finalItemsString.endsWith(", ")) {
            finalItemsString = finalItemsString.substring(0, finalItemsString.length() - 2);
        }

        if (mainFrame != null) {
            mainFrame.setSelectedItems(finalItemsString, grandTotal);
            this.dispose();
        }

    
    }//GEN-LAST:event_addtoorderActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
     new addorders().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    public static void main(String args[]) {
     java.awt.EventQueue.invokeLater(() -> {
            new items(null).setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
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
