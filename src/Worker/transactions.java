package Worker;

import config.Session;
import config.config;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class transactions extends javax.swing.JFrame {

    config conf = new config();
    String currentworker = "";
    
    // Static reference para ma-refresh ang table gikan sa laing frames
    public static transactions instance;

    public transactions() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.currentworker = Session.getInstance().getName();
        
        instance = this; 
        displayTransactions();

        // --- MOUSE LISTENER PARA SA DOUBLE CLICK ---
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
    }

    public static void displayTransactions() {
        if (instance != null) {
            try {
                int workerId = Session.getInstance().getId(); 
                String searchTerm = instance.search.getText().trim();
                
                if (workerId == 0) {
                    System.out.println("No worker logged in or ID is 0.");
                    return;
                }

                // Gi-include ang order_status sa SQL query
                String sql = "SELECT o_id, customer_name, item, total_amount, order_status " +
                             "FROM OrdersTable WHERE worker_id = " + workerId + " " +
                             "AND order_status != 'Pending' " + 
                             "AND (customer_name LIKE '%" + searchTerm + "%' " +
                             "OR item LIKE '%" + searchTerm + "%' " +
                             "OR order_status LIKE '%" + searchTerm + "%')";
                
                // 1. I-load ang data gamit ang config class
                config.displayData(sql, instance.jTable1);
                
                // 2. I-lock ang table para dili ma-edit ang cells (Non-editable model)
                TableModel model = instance.jTable1.getModel();
                DefaultTableModel nonEditableModel = new DefaultTableModel() {
                    @Override
                    public boolean isCellEditable(int row, int column) {
                        return false; 
                    }
                };

                for (int i = 0; i < model.getColumnCount(); i++) {
                    nonEditableModel.addColumn(model.getColumnName(i));
                }

                for (int i = 0; i < model.getRowCount(); i++) {
                    Object[] rowData = new Object[model.getColumnCount()];
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        rowData[j] = model.getValueAt(i, j);
                    }
                    nonEditableModel.addRow(rowData);
                }

                instance.jTable1.setModel(nonEditableModel);
                
            } catch (Exception e) {
                System.out.println("Error loading transactions: " + e.getMessage());
            }
        } 
    }

    // --- KINI NGA METHOD ANG MO-HANDLE SA DOUBLE CLICK PARA VIEW RECEIPT ---
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
      if (evt.getClickCount() == 2) { 
            int rowIndex = jTable1.getSelectedRow();
            if (rowIndex >= 0) {
                TableModel model = jTable1.getModel();
                
         
                
                String id = model.getValueAt(rowIndex, 0).toString();      
                String name = model.getValueAt(rowIndex, 1).toString();    
                String item = model.getValueAt(rowIndex, 2).toString();    
                String total = model.getValueAt(rowIndex, 3).toString();   
                String status = model.getValueAt(rowIndex, 4).toString();  
                
                String unitPrice = "0.00";
                
                try {
                    // Limpyohan ang item name (kuhaon lang ang text sa dili pa ang space/parenthesis)
                    String cleanItem = item.trim();
                    if (cleanItem.contains(" ")) {
                        cleanItem = cleanItem.split(" ")[0];
                    }

                    // Siguroha nga husto ang 'p_item' ug 'p_price' base sa imong masterlist table
                    String sql = "SELECT p_price FROM masterlist WHERE p_item LIKE '" + cleanItem + "%'";
                    java.sql.ResultSet rs = conf.getData(sql);
                    
                    if (rs != null && rs.next()) {
                        unitPrice = rs.getString("p_price");
                    } else {
                        // Kung walay nakit-an sa masterlist, gamita ang total isip fallback
                        unitPrice = total; 
                    }
                } catch (Exception e) {
                    System.out.println("Fetch Price Error: " + e.getMessage());
                    unitPrice = total; 
                }

                // I-open ang Receipt (Siguroha nga 8 parameters kini)
                Worker.Receipt rec = new Worker.Receipt(id, name, item, total, "0.00", "0.00", status, unitPrice);
                rec.setVisible(true);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        back = new javax.swing.JButton();
        search = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 205, 208));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        back.setBackground(new java.awt.Color(153, 153, 153));
        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("TRANSACTIONS");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
       displayTransactions();
    }//GEN-LAST:event_searchActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
       new workerdashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backActionPerformed

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
       displayTransactions();
    }//GEN-LAST:event_searchKeyReleased

   public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new transactions().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField search;
    // End of variables declaration//GEN-END:variables
}
