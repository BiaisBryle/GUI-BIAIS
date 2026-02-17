

package admin;

import config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import main.login;
import config.Session;
import order.orders;


public final class profile extends javax.swing.JFrame {
   private String adminEmail;
    private String userEmail;
   
  
    // Constructor nga modawat og email gikan sa Dashboard/Login
    public profile() { // Constructor is now empty
        initComponents();
        this.setLocationRelativeTo(null);
        displayUserInfo(); // No longer needs to pass email
    }

    public void displayUserInfo() {
        Session sess = Session.getInstance();
        String email = sess.getEmail(); // Get email from Session
        
        String sql = "SELECT u_name, u_lname, u_email, u_role FROM user WHERE u_email = ?";
        
        try (Connection conn = config.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                jLabel2.setText("First Name: " + rs.getString("u_name"));
                jLabel3.setText("Last Name: " + rs.getString("u_lname"));
                jLabel4.setText("Email: " + rs.getString("u_email"));
                jLabel5.setText("Role: " + rs.getString("u_role"));
            }
        } catch (SQLException e) {
            System.out.println("Error loading user info: " + e.getMessage());
        }
    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        home = new javax.swing.JButton();
        usertable = new javax.swing.JButton();
        profile = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 205, 208));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("PROFILE");

        home.setBackground(new java.awt.Color(153, 153, 153));
        home.setText("HOME");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        usertable.setBackground(new java.awt.Color(153, 153, 153));
        usertable.setText("USERS");
        usertable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertableActionPerformed(evt);
            }
        });

        profile.setBackground(new java.awt.Color(153, 153, 153));
        profile.setText("PROFILE");

        logout.setBackground(new java.awt.Color(153, 153, 153));
        logout.setText("LOG OUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(245, 205, 208));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("first name:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 330, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Last name:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 153, 320, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Email:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 193, 280, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Role:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 233, 270, -1));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setText("MASTER LIST");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setText("ORDERS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usertable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                    .addComponent(home, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel1)
                        .addGap(139, 139, 139))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usertable, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(profile, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(logout, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
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

    private void usertableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertableActionPerformed
    new usertable().setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_usertableActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
   new admindashboard().setVisible(true); 
        this.dispose();
    
    }//GEN-LAST:event_homeActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
       int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Logout", JOptionPane.YES_NO_OPTION);
    
    if (confirm == JOptionPane.YES_OPTION) {
        // Palitan ang 'login' ng tamang class name ng iyong login form
        new main.login().setVisible(true); 
        this.dispose(); // Isara ang kasalukuyang usertable window
    }

    }//GEN-LAST:event_logoutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         masterlist ml = new masterlist();
        ml.setVisible(true);

        // Mo-close ang Dashboard para dili daghan og windows nga abli
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new orders().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

 
   public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new profile().setVisible(true); 
        });
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton home;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton logout;
    private javax.swing.JButton profile;
    private javax.swing.JButton usertable;
    // End of variables declaration//GEN-END:variables

}
