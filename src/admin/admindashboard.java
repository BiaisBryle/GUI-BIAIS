
package admin;

import javax.swing.JOptionPane;
import main.login;
import config.Session;


public class admindashboard extends javax.swing.JFrame {
    private String adminEmail;
      private String userEmail;

public admindashboard() {
        initComponents();
        this.setLocationRelativeTo(null); 
        
        // Example: You can set a welcome message using the session
        Session sess = Session.getInstance();
        jLabel2.setText("Admin,"+sess.getName().toUpperCase());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        home = new javax.swing.JButton();
        userstable = new javax.swing.JButton();
        profile = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        orders = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 205, 208));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo small.PNG"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 307, 310));

        home.setBackground(new java.awt.Color(153, 153, 153));
        home.setText("HOME");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        jPanel1.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 110, 50));

        userstable.setBackground(new java.awt.Color(153, 153, 153));
        userstable.setText("USERS");
        userstable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userstableActionPerformed(evt);
            }
        });
        jPanel1.add(userstable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 110, 50));

        profile.setBackground(new java.awt.Color(153, 153, 153));
        profile.setText("PROFILE");
        profile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profileActionPerformed(evt);
            }
        });
        jPanel1.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 110, 50));

        logout.setBackground(new java.awt.Color(153, 153, 153));
        logout.setText("LOG OUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jPanel1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 110, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 350, 50));

        orders.setBackground(new java.awt.Color(153, 153, 153));
        orders.setText("ORDERS");
        orders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersActionPerformed(evt);
            }
        });
        jPanel1.add(orders, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 110, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
  int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            new main.login().setVisible(true); 
            this.dispose(); 
        }
    

    }//GEN-LAST:event_logoutActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
   new admindashboard().setVisible(true); 
        this.dispose();
    }//GEN-LAST:event_homeActionPerformed

    private void userstableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userstableActionPerformed
     new usertable().setVisible(true); // No arguments needed
        this.dispose();
    

    }//GEN-LAST:event_userstableActionPerformed

    private void profileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profileActionPerformed
   new profile().setVisible(true); // No arguments needed
        this.dispose();
    
    }//GEN-LAST:event_profileActionPerformed

    private void ordersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ordersActionPerformed

   
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(() -> {
            new admindashboard().setVisible(true); // Removed the "test@email.com"
        });
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton logout;
    private javax.swing.JButton orders;
    private javax.swing.JButton profile;
    private javax.swing.JButton userstable;
    // End of variables declaration//GEN-END:variables
}
