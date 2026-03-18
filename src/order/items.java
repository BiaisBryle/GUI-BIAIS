package order;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import config.config;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class items extends javax.swing.JFrame {

    DefaultTableModel model;
    private addorders mainFrame;
    private String currentSelectedItems; // Sudlanan sa karaan nga selection

    // Gidugangan og 'preSelected' parameter ang constructor
    public items(addorders mainFrame, String preSelected) {
        this.mainFrame = mainFrame;
        this.currentSelectedItems = preSelected; 
        initComponents();
        setupTable();
        loadItemsFromDB(); 
        
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void setupTable() {
        String[] columns = {"Item Name", "Price", "Select", "Quantity", "Available Stock"};
        model = new DefaultTableModel(columns, 0) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 2) return Boolean.class; 
                if (columnIndex == 1) return Double.class;  
                if (columnIndex == 3 || columnIndex == 4) return Integer.class; 
                return super.getColumnClass(columnIndex);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 2 || column == 3;
            }
        };
        jTable3.setModel(model);

        jTable3.getColumnModel().getColumn(4).setMinWidth(0);
        jTable3.getColumnModel().getColumn(4).setMaxWidth(0);
        jTable3.getColumnModel().getColumn(4).setPreferredWidth(0);

        model.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (e.getColumn() == 2 || e.getColumn() == 3) {
                    calculateGrandTotal();
                }
            }
        });
    }

    private void loadItemsFromDB() {
        config conf = new config();
        try {
            String sql = "SELECT p_item, p_price, p_quantity FROM masterlist";
            ResultSet rs = conf.getData(sql);

            model.setRowCount(0);
            while (rs.next()) {
                String itemName = rs.getString("p_item");
                double price = rs.getDouble("p_price");
                int stock = rs.getInt("p_quantity");

                // --- LOGIC PARA SA RE-CHECK ---
                boolean isChecked = false;
                int existingQty = 0;

                if (currentSelectedItems != null && !currentSelectedItems.isEmpty()) {
                    if (currentSelectedItems.contains(itemName)) {
                        isChecked = true;
                        // Extract quantity gamit ang regex: "Item Name (x5)" -> 5
                        try {
                            Pattern p = Pattern.compile(Pattern.quote(itemName) + " \\(x(\\d+)\\)");
                            Matcher m = p.matcher(currentSelectedItems);
                            if (m.find()) {
                                existingQty = Integer.parseInt(m.group(1));
                            }
                        } catch (Exception e) { existingQty = 1; }
                    }
                }

                model.addRow(new Object[]{
                    itemName, 
                    price, 
                    isChecked,   // I-set ang checkbox
                    existingQty, // I-set ang quantity
                    stock 
                });
            }
            calculateGrandTotal(); // I-calculate dayon ang total inig abli
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
                int stockAvailable = (int) model.getValueAt(i, 4);
                int qty = 0;

                try {
                    qty = Integer.parseInt(model.getValueAt(i, 3).toString());
                    
                    if (qty > stockAvailable) {
                        JOptionPane.showMessageDialog(this, 
                            "Insufficient stock! " + model.getValueAt(i, 0) + " has only " + stockAvailable + " left.");
                        model.setValueAt(stockAvailable, i, 3); 
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
            String sql = "SELECT p_item, p_price, p_quantity FROM masterlist WHERE p_item LIKE '%" + query + "%'";
            ResultSet rs = conf.getData(sql);
            while (rs.next()) {
                String itemName = rs.getString("p_item");
                double price = rs.getDouble("p_price");
                int stock = rs.getInt("p_quantity");

                // I-apply gihapon ang re-check maski sa search
                boolean isChecked = false;
                int existingQty = 0;
                if (currentSelectedItems != null && currentSelectedItems.contains(itemName)) {
                    isChecked = true;
                    try {
                        Pattern p = Pattern.compile(Pattern.quote(itemName) + " \\(x(\\d+)\\)");
                        Matcher m = p.matcher(currentSelectedItems);
                        if (m.find()) existingQty = Integer.parseInt(m.group(1));
                    } catch (Exception e) { existingQty = 1; }
                }

                model.addRow(new Object[]{ itemName, price, isChecked, existingQty, stock });
            }
        } catch (SQLException e) {
            System.out.println("Search error: " + e.getMessage());
        }
    
    
    }//GEN-LAST:event_searchKeyReleased

    private void addtoorderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtoorderActionPerformed
     StringBuilder selectedItems = new StringBuilder();
        double total = 0.0;
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
                    total += (price * qty);
                }
            }
        }

        if (!hasSelection) {
            JOptionPane.showMessageDialog(this, "Please select an item and enter quantity.");
            return;
        }

        String finalString = selectedItems.toString();
        if (finalString.endsWith(", ")) {
            finalString = finalString.substring(0, finalString.length() - 2);
        }

        if (mainFrame != null) {
            mainFrame.setSelectedItems(finalString, total);
            this.dispose(); 
        }
    
    
    }//GEN-LAST:event_addtoorderActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new items(null, "").setVisible(true);
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
