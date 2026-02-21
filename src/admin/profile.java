

package admin;

import config.config;
import config.Session;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import main.login;
import order.orders;


public final class profile extends javax.swing.JFrame {
  private String destinationPath = null;
    private String oldImagePath = null;

    public profile() {
        initComponents();
        this.setLocationRelativeTo(null);
        displayUserInfo();

        // 1. I-lock ang Role field aron dili mausab
        jTextField4.setEditable(false);
        jTextField4.setFocusable(false);

        // 2. I-set ang button transparency para sa Upload Photo (Overlay sa jLabel2)
        jButton4.setOpaque(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setBorderPainted(false);

        // 3. Disable UPDATE button sa sugod hangtod naay usbon ang user
        jButton3.setEnabled(false);

        // 4. I-add ang listener para sa text fields
        addEditListener();
    }

    private void addEditListener() {
        DocumentListener dl = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { jButton3.setEnabled(true); }
            @Override
            public void removeUpdate(DocumentEvent e) { jButton3.setEnabled(true); }
            @Override
            public void changedUpdate(DocumentEvent e) { jButton3.setEnabled(true); }
        };
        jTextField1.getDocument().addDocumentListener(dl);
        jTextField2.getDocument().addDocumentListener(dl);
        jTextField3.getDocument().addDocumentListener(dl);
    }

    public void displayUserInfo() {
        Session sess = Session.getInstance();
        String emailStr = sess.getEmail();
        String sql = "SELECT u_name, u_lname, u_email, u_role, u_image FROM user WHERE u_email = ?";

        try (Connection conn = config.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, emailStr);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // I-set ang text sa fields
                jTextField1.setText(rs.getString("u_name"));
                jTextField2.setText(rs.getString("u_lname"));
                jTextField3.setText(rs.getString("u_email"));
                jTextField4.setText(rs.getString("u_role"));

                // I-save ang karaan nga path para sa image
                oldImagePath = rs.getString("u_image");
                
                if (oldImagePath != null && !oldImagePath.isEmpty()) {
                    setProfileImage(oldImagePath);
                    jButton4.setText(""); // Kuhaon ang text kon naay image
                } else {
                    jLabel2.setIcon(null);
                    jButton4.setText("UPLOAD PHOTO");
                }
                
                // Reset state
                destinationPath = null;
                jButton3.setEnabled(false);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void setProfileImage(String path) {
        try {
            javax.swing.ImageIcon icon = new javax.swing.ImageIcon(path);
            java.awt.Image img = icon.getImage().getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), java.awt.Image.SCALE_SMOOTH);
            jLabel2.setIcon(new javax.swing.ImageIcon(img));
        } catch (Exception e) {
            System.out.println("Error setting image: " + e.getMessage());
        }
    
    
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        home = new javax.swing.JButton();
        usertable = new javax.swing.JButton();
        profile = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        firstname = new javax.swing.JLabel();
        lastname = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        role = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 205, 208));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("PROFILE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(185, 0, -1, -1));

        home.setBackground(new java.awt.Color(153, 153, 153));
        home.setText("HOME");
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        jPanel1.add(home, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 120, 45));

        usertable.setBackground(new java.awt.Color(153, 153, 153));
        usertable.setText("USERS");
        usertable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertableActionPerformed(evt);
            }
        });
        jPanel1.add(usertable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 120, 45));

        profile.setBackground(new java.awt.Color(153, 153, 153));
        profile.setText("PROFILE");
        jPanel1.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 120, 45));

        logout.setBackground(new java.awt.Color(153, 153, 153));
        logout.setText("LOG OUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jPanel1.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 120, 45));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setText("MASTER LIST");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 120, 46));

        jButton2.setBackground(new java.awt.Color(153, 153, 153));
        jButton2.setText("ORDERS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 120, 50));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 110));

        jButton4.setText("Upload Photo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 130, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 130, 110));

        firstname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        firstname.setText("First name:");
        jPanel1.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, -1, -1));

        lastname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lastname.setText("Last name:");
        jPanel1.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, -1, -1));

        email.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        email.setText("Email:");
        jPanel1.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, -1, -1));

        role.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        role.setText("Role:");
        jPanel1.add(role, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, -1, -1));

        jButton3.setBackground(new java.awt.Color(153, 153, 153));
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 350, -1, 40));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 140, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 140, -1));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 140, -1));
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 320, 140, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       Session sess = Session.getInstance();
        String currentEmail = sess.getEmail();
        String fName = jTextField1.getText();
        String lName = jTextField2.getText();
        String newEmail = jTextField3.getText();

        if (fName.isEmpty() || lName.isEmpty() || newEmail.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Fields cannot be empty!");
            return;
        }

        try (Connection conn = config.connectDB()) {
            String sql;
            PreparedStatement pstmt;

            if (destinationPath != null) {
                // I-save ang image sa folder
                java.io.File sourceFile = new java.io.File(destinationPath);
                java.io.File destFolder = new java.io.File("src/user_images/");
                if (!destFolder.exists()) destFolder.mkdirs();

                String fileName = System.currentTimeMillis() + "_" + sourceFile.getName();
                java.nio.file.Path target = java.nio.file.Paths.get("src/user_images/" + fileName);
                java.nio.file.Files.copy(sourceFile.toPath(), target, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                String finalImagePath = "src/user_images/" + fileName;

                sql = "UPDATE user SET u_name=?, u_lname=?, u_email=?, u_image=? WHERE u_email=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, fName);
                pstmt.setString(2, lName);
                pstmt.setString(3, newEmail);
                pstmt.setString(4, finalImagePath);
                pstmt.setString(5, currentEmail);
            } else {
                sql = "UPDATE user SET u_name=?, u_lname=?, u_email=? WHERE u_email=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, fName);
                pstmt.setString(2, lName);
                pstmt.setString(3, newEmail);
                pstmt.setString(4, currentEmail);
            }

            if (pstmt.executeUpdate() > 0) {
                sess.setEmail(newEmail); // Update session email
                JOptionPane.showMessageDialog(null, "Profile Updated Successfully!");
                displayUserInfo(); 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
        int result = chooser.showOpenDialog(null);
        if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File sourceFile = chooser.getSelectedFile();
            destinationPath = sourceFile.getAbsolutePath(); 
            setProfileImage(destinationPath); // Preview
            jButton3.setEnabled(true); // Enable Update
            jButton4.setText("");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

 
   public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new profile().setVisible(true); 
        });
   }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel email;
    private javax.swing.JLabel firstname;
    private javax.swing.JButton home;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel lastname;
    private javax.swing.JButton logout;
    private javax.swing.JButton profile;
    private javax.swing.JLabel role;
    private javax.swing.JButton usertable;
    // End of variables declaration//GEN-END:variables

}
