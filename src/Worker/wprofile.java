
package Worker;

import config.config;
import config.Session;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;



public final class wprofile extends javax.swing.JFrame {
    private String destinationPath = null;
    private String oldImagePath = null;

    public wprofile() {
        initComponents();
        this.setLocationRelativeTo(null);
        displayUserInfo();

        // 1. I-lock ang Role field
        jTextField4.setEditable(false);
        jTextField4.setFocusable(false);

        // 2. I-set ang button transparency para sa Upload Photo
        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);

        // 3. Disable UPDATE button sa sugod
        jButton1.setEnabled(false);

        // 4. Listeners para sa text fields
        addEditListener();
    }

    private void addEditListener() {
        DocumentListener dl = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { jButton1.setEnabled(true); }
            @Override
            public void removeUpdate(DocumentEvent e) { jButton1.setEnabled(true); }
            @Override
            public void changedUpdate(DocumentEvent e) { jButton1.setEnabled(true); }
        };
        jTextField1.getDocument().addDocumentListener(dl);
        jTextField2.getDocument().addDocumentListener(dl);
        jTextField3.getDocument().addDocumentListener(dl);
    }

    public void displayUserInfo() {
        Session sess = Session.getInstance();
        String email = sess.getEmail();
        String sql = "SELECT u_name, u_lname, u_email, u_role, u_image FROM user WHERE u_email = ?";

        try (Connection conn = config.connectDB();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                firstname.setText("First name:");
                jLabel3.setText("Last name:");
                jLabel4.setText("Email:");
                jLabel5.setText("Role:");

                jTextField1.setText(rs.getString("u_name"));
                jTextField2.setText(rs.getString("u_lname"));
                jTextField3.setText(rs.getString("u_email"));
                jTextField4.setText(rs.getString("u_role"));

                // I-save ang karaan nga path
                oldImagePath = rs.getString("u_image");
                
                if (oldImagePath != null && !oldImagePath.isEmpty()) {
                    setProfileImage(oldImagePath);
                    jButton2.setText(""); 
                } else {
                    jLabel2.setIcon(null);
                    jButton2.setText("UPLOAD PHOTO");
                }
                
                // I-reset ang temporary path ug disable update button human og load
                destinationPath = null;
                jButton1.setEnabled(false);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Helper method para i-display ang image
    private void setProfileImage(String path) {
        javax.swing.ImageIcon icon = new javax.swing.ImageIcon(path);
        java.awt.Image img = icon.getImage().getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), java.awt.Image.SCALE_SMOOTH);
        jLabel2.setIcon(new javax.swing.ImageIcon(img));
    
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
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 205, 208));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("PROFILE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 150, -1));

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
        jPanel1.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 130, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Last name:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 130, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Email:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Role:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, 80, 20));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 110));

        jButton2.setText("UPLOAD PHOTO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 170, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 170, 110));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setText("UPDATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 350, 100, 40));
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 160, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, 160, -1));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 160, -1));
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 160, -1));

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
      displayUserInfo();
        JOptionPane.showMessageDialog(null, "Profile view refreshed.");
    
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                                            
        javax.swing.JFileChooser chooser = new javax.swing.JFileChooser();
        int result = chooser.showOpenDialog(null);
        if (result == javax.swing.JFileChooser.APPROVE_OPTION) {
            java.io.File sourceFile = chooser.getSelectedFile();
            destinationPath = sourceFile.getAbsolutePath(); // Temporary store path
            setProfileImage(destinationPath); // Preview ra
            jButton1.setEnabled(true); // I-enable ang Update button
            jButton2.setText("");
        }
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
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

            // I-check kung naay bag-ong image nga gi-upload
            if (destinationPath != null) {
                // I-copy ang file sa folder sa system
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
                // Text fields ra ang giusab
                sql = "UPDATE user SET u_name=?, u_lname=?, u_email=? WHERE u_email=?";
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, fName);
                pstmt.setString(2, lName);
                pstmt.setString(3, newEmail);
                pstmt.setString(4, currentEmail);
            }

            if (pstmt.executeUpdate() > 0) {
                sess.setEmail(newEmail);
                JOptionPane.showMessageDialog(null, "Profile Updated Successfully!");
                displayUserInfo(); // Refresh display
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed
  
  
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel firstname;
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton logout;
    private javax.swing.JButton orders;
    private javax.swing.JButton profile;
    // End of variables declaration//GEN-END:variables
}
