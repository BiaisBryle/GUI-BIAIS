package Worker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Receipt extends javax.swing.JFrame {

    private static Receipt currentInstance = null;

    // Ang Constructor modawat na sa unitPrice isip String gikan sa nanawag niini
    public Receipt(String id, String name, String item, String total, String cash, String change, String status, String unitPrice) {
        if (currentInstance != null) {
            currentInstance.dispose(); 
        }
        currentInstance = this;

        initComponents();
        this.setLocationRelativeTo(null); 
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        jTextArea1.setEditable(false);
        generateReceipt(id, name, item, total, cash, change, status, unitPrice);
    }

    public Receipt() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }

    private void generateReceipt(String id, String name, String item, String total, String cash, String change, String status, String unitPrice) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 12)); 
        jTextArea1.setText("");
        jTextArea1.append("******************************************************\n");
        jTextArea1.append("          BRYLE CHICKEN DELIVERY          \n");
        jTextArea1.append("            Naga, Cebu, 6037              \n");
        jTextArea1.append("          Contact: 09392266654            \n");
        jTextArea1.append("******************************************************\n");
        jTextArea1.append(" Date:    " + dtf.format(now) + "\n");
        jTextArea1.append(" Order ID: " + id + "\n");
        jTextArea1.append(" Customer: " + name + "\n");
        jTextArea1.append(" Status:   " + status.toUpperCase() + "\n"); 
        jTextArea1.append("------------------------------------------------------\n");
        // Gi-ayo nako ang String.format diri (gitangtang ang p_price nga variable)
        jTextArea1.append(String.format(" %-25s %-10s\n", "ITEM DESCRIPTION", "PRICE"));
        jTextArea1.append("------------------------------------------------------\n");

        String displayItem = item;
        if (displayItem.length() > 25) {
            displayItem = displayItem.substring(0, 22) + "...";
        }
        
        // Kani nga unitPrice gikan ni sa imong database (masterlist)
        jTextArea1.append(String.format(" %-25s %-10s\n", displayItem, unitPrice));

        jTextArea1.append("------------------------------------------------------\n");
        jTextArea1.append(String.format(" TOTAL AMOUNT:             PHP %10s\n", total));
        jTextArea1.append("------------------------------------------------------\n");
        jTextArea1.append("   The chicken that’s fast is delicious!   \n");
        jTextArea1.append("          Thank you, Come again!          \n");
        jTextArea1.append("******************************************************\n");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 205, 208));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo small.PNG"))); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
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

   private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // I-close ra ang Receipt frame, dili ang tibuok app
        this.dispose();
    }
  public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Receipt().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
