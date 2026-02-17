
package Worker;

import config.config;
import config.Session;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;



public final class wprofile extends javax.swing.JFrame {
    
   public wprofile() {
       initComponents();
    this.setLocationRelativeTo(null);
    displayUserInfo();

    // Himoon nga transparent ang button
    jButton1.setOpaque(false);
    jButton1.setContentAreaFilled(false);
    jButton1.setBorderPainted(false);


   
   }
    
   
    public void displayUserInfo() {

      Session sess = Session.getInstance();
    String email = sess.getEmail();

    // I-apil ang u_image sa SELECT
    String sql = "SELECT u_name, u_lname, u_email, u_role, u_image FROM user WHERE u_email = ?";

    try (Connection conn = config.connectDB();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {

        pstmt.setString(1, email);
        ResultSet rs = pstmt.executeQuery();

        if (rs.next()) {
            firstname.setText("First Name: " + rs.getString("u_name"));
            jLabel3.setText("Last Name: " + rs.getString("u_lname"));
            jLabel4.setText("Email: " + rs.getString("u_email"));
            jLabel5.setText("Role: " + rs.getString("u_role"));
            
            // --- I-LOAD ANG IMAGE ---
            String imagePath = rs.getString("u_image");
            if (imagePath != null && !imagePath.isEmpty()) {
                javax.swing.ImageIcon icon = new javax.swing.ImageIcon(imagePath);
                java.awt.Image img = icon.getImage().getScaledInstance(170, 110, java.awt.Image.SCALE_SMOOTH);
                jLabel6.setIcon(new javax.swing.ImageIcon(img));
                jButton1.setText(""); // Mawala ang text kay naay image
            }
        }
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        profile = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        home = new javax.swing.JButton();
        orders = new javax.swing.JButton();
        firstname = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 205, 208));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("PROFILE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 150, -1));

        profile.setBackground(new java.awt.Color(153, 153, 153));
        profile.setText("PROFILE");
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });
        jPanel1.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 110, 50));

        logout.setBackground(new java.awt.Color(153, 153, 153));
        logout.setText("LOG OUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jPanel1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 110, 50));

        home.setBackground(new java.awt.Color(153, 153, 153));
        home.setText("HOME");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        jPanel1.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 110, 50));

        orders.setBackground(new java.awt.Color(153, 153, 153));
        orders.setText("ORDERS");
        orders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersActionPerformed(evt);
            }
        });
        jPanel1.add(orders, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 110, 50));

        firstname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        firstname.setText("First name:");
        jPanel1.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 280, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Last name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 260, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Email:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 250, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Role:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 310, 240, 20));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setText("Update Photo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(40, 40, 40))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, 170, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
      
    }//GEN-LAST:event_profileActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
     new workerdashboard().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_homeActionPerformed

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
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new wprofile().setVisible(true);
        });
    }//GEN-LAST:event_logoutActionPerformed

    private void ordersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersActionPerformed
    worder ord = new worder(); 
    ord.setVisible(true);
    this.dispose();
    }//GEN-LAST:event_ordersActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
    int result = chooser.showOpenDialog(null);
    
    if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
        java.io.File f = chooser.getSelectedFile();
        String path = f.getAbsolutePath();
        
        // 1. I-display ang image
        javax.swing.ImageIcon icon = new javax.swing.ImageIcon(path);
        java.awt.Image img = icon.getImage().getScaledInstance(170, 110, java.awt.Image.SCALE_SMOOTH);
        jLabel6.setIcon(new javax.swing.ImageIcon(img));
        jButton1.setText(""); // Para dili makatabon sa picture

        // 2. I-save sa Database
        Session sess = Session.getInstance();
        String email = sess.getEmail();
        String sql = "UPDATE user SET u_image = ? WHERE u_email = ?";
        
        try (Connection conn = config.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, path);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Profile picture saved!");
        } catch (SQLException e) {
            System.out.println("Error saving path: " + e.getMessage());
        }
    }
    }//GEN-LAST:event_jButton1ActionPerformed

 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel firstname;
    private javax.swing.JButton home;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton logout;
    private javax.swing.JButton orders;
    private javax.swing.JButton profile;
    // End of variables declaration//GEN-END:variables
}
