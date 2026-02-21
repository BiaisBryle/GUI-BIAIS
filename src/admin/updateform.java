
package admin;

import config.config;
import config.Session;
import java.awt.Image;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;



public class updateform extends javax.swing.JFrame {
   String userID;
    String destinationPath = "";
    String oldImagePath = ""; // Para mahibal-an kung nausab ang image
    private javax.swing.JComboBox<String> roleCombo;
    private JLabel imageLabel;

    public updateform() {
        initComponents();
        setupImageLabel();
        addRoleSelection();
        groupGenders();
        applyButtonStyle(); // I-apply ang transparency
        this.setLocationRelativeTo(null);

        Session sess = Session.getInstance();
        if (sess.getId() == 0) {
            JOptionPane.showMessageDialog(null, "Please Login First!");
            new main.login().setVisible(true);
            this.dispose();
            return;
        }

        add.setVisible(true);
        cancel.setVisible(true);
        update.setVisible(false);
        jButton1.setVisible(false);
        jLabel5.setText("Add New User Profile");
        
        addFieldListeners();
    }

    public updateform(TableModel model, int rowIndex) {
        initComponents();
        setupImageLabel();
        addRoleSelection();
        groupGenders();
        applyButtonStyle(); // I-apply ang transparency
        this.setLocationRelativeTo(null);

        update.setVisible(true);
        update.setEnabled(false); 
        jButton1.setVisible(true);
        add.setVisible(false);
        cancel.setVisible(false);
        userole.setVisible(false);
        if (roleCombo != null) roleCombo.setVisible(false);

        jLabel5.setText("Update User Profile");

        try {
            userID = (model.getValueAt(rowIndex, 0) != null) ? model.getValueAt(rowIndex, 0).toString() : "";
            jTextField1.setText(getSafeValue(model, rowIndex, 1));
            jTextField3.setText(getSafeValue(model, rowIndex, 2));
            jTextField2.setText(getSafeValue(model, rowIndex, 3));
            jTextField4.setText(getSafeValue(model, rowIndex, 6));

            config conf = new config();
            java.sql.ResultSet rs = conf.getData("SELECT u_pass, u_image FROM user WHERE u_id = '" + userID + "'");
            if (rs.next()) {
                jTextField5.setText(rs.getString("u_pass"));
                oldImagePath = rs.getString("u_image");
                destinationPath = oldImagePath;
                if (destinationPath != null && !destinationPath.isEmpty()) {
                    displayImage(destinationPath);
                }
            }

            String currentGender = getSafeValue(model, rowIndex, 7);
            if (currentGender.equalsIgnoreCase("Male")) jRadioButton1.setSelected(true);
            else if (currentGender.equalsIgnoreCase("Female")) jRadioButton2.setSelected(true);

        } catch (Exception e) {
            System.out.println("Error Loading Data: " + e.getMessage());
        }

        addFieldListeners();
    }

    // KINI NGA METHOD MAGHIMO SA BUTTON NGA TRANSPARENT OVERLAY
    private void applyButtonStyle() {
        jButton2.setOpaque(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setBorderPainted(false);
        jButton2.setText("UPLOAD PHOTO");
    }

    private void addFieldListeners() {
        DocumentListener dl = new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { update.setEnabled(true); }
            @Override public void removeUpdate(DocumentEvent e) { update.setEnabled(true); }
            @Override public void changedUpdate(DocumentEvent e) { update.setEnabled(true); }
        };
        jTextField1.getDocument().addDocumentListener(dl);
        jTextField2.getDocument().addDocumentListener(dl);
        jTextField3.getDocument().addDocumentListener(dl);
        jTextField4.getDocument().addDocumentListener(dl);
        jTextField5.getDocument().addDocumentListener(dl);
        
        jRadioButton1.addActionListener(e -> update.setEnabled(true));
        jRadioButton2.addActionListener(e -> update.setEnabled(true));
    }

    private void setupImageLabel() {
        jPanel2.setLayout(null); // Absolute Layout para mag-overlay
        
        imageLabel = new JLabel();
        imageLabel.setBounds(0, 0, 140, 110);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        
        // I-adjust ang jButton2 bounds para mo-match sa label
        jButton2.setBounds(0, 0, 140, 110);
        
        jPanel2.add(jButton2); // Button ang una para naa sa taas (clickable)
        jPanel2.add(imageLabel);
    }

    public void displayImage(String path) {
        try {
            ImageIcon icon = new ImageIcon(path);
            if (icon.getIconWidth() > 0) {
                Image img = icon.getImage().getScaledInstance(imageLabel.getWidth(), imageLabel.getHeight(), Image.SCALE_SMOOTH);
                imageLabel.setIcon(new ImageIcon(img));
                imageLabel.setText("");
                jButton2.setText(""); // Kuhaon ang text para dili sagabal sa image
            } else {
                imageLabel.setIcon(null);
                jButton2.setText("UPLOAD PHOTO");
            }
        } catch (Exception e) {
            jButton2.setText("UPLOAD PHOTO");
        }
    }

    private void actionSave(String mode) {
        String f = jTextField1.getText().trim();
        String l = jTextField3.getText().trim();
        String e = jTextField2.getText().trim();
        String p = jTextField5.getText().trim();
        String a = jTextField4.getText().trim();
        String g = jRadioButton1.isSelected() ? "Male" : (jRadioButton2.isSelected() ? "Female" : "");

        if (f.isEmpty() || l.isEmpty() || e.isEmpty() || p.isEmpty() || a.isEmpty() || g.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill up all fields!");
            return;
        }

        // LOGIC PARA SA PAG-COPY SA IMAGE SA FOLDER (Gikan sa Profile code nimo)
        String finalPath = destinationPath;
        if (destinationPath != null && !destinationPath.equals(oldImagePath)) {
            try {
                File sourceFile = new File(destinationPath);
                File destFolder = new File("src/user_images/");
                if (!destFolder.exists()) destFolder.mkdirs();

                String fileName = System.currentTimeMillis() + "_" + sourceFile.getName();
                Path target = Paths.get("src/user_images/" + fileName);
                Files.copy(sourceFile.toPath(), target, StandardCopyOption.REPLACE_EXISTING);
                finalPath = "src/user_images/" + fileName;
            } catch (Exception ex) {
                System.out.println("Image Copy Error: " + ex.getMessage());
            }
        }

        config conf = new config();
        String checkID = (mode.equals("ADD")) ? "" : userID;

        if (conf.isEmailExisting(e, checkID)) {
            JOptionPane.showMessageDialog(null, "Error: Email is already taken!");
            return;
        }

        if (mode.equals("ADD")) {
            if (roleCombo.getSelectedItem().equals("Select Role")) {
                JOptionPane.showMessageDialog(null, "Please select a User Role!");
                return;
            }
            String role = roleCombo.getSelectedItem().toString();
            String sql = "INSERT INTO user (u_name, u_lname, u_email, u_pass, u_address, u_gender, u_role, u_status, u_image) VALUES (?, ?, ?, ?, ?, ?, ?, 'Pending', ?)";
            conf.updateRecord(sql, f, l, e, p, a, g, role, finalPath);
            JOptionPane.showMessageDialog(null, "User Added Successfully!");
        } else {
            String sql = "UPDATE user SET u_name=?, u_lname=?, u_email=?, u_pass=?, u_address=?, u_gender=?, u_image=? WHERE u_id=?";
            conf.updateRecord(sql, f, l, e, p, a, g, finalPath, userID);
            JOptionPane.showMessageDialog(null, "User Updated Successfully!");
        }

        new usertable().setVisible(true);
        this.dispose();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        add = new javax.swing.JButton();
        userole = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 205, 208));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 100, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 100, -1));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 100, 24));

        jRadioButton1.setText("Male");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, -1));

        jRadioButton2.setText("Female");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 250, -1, -1));
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 212, 253, 24));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("First name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, 19));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Last name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Email:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Address:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 211, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Profile");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 260, -1));

        update.setBackground(new java.awt.Color(153, 153, 153));
        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 80, 41));

        add.setBackground(new java.awt.Color(153, 153, 153));
        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 90, 41));

        userole.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userole.setText("User Role:");
        jPanel1.add(userole, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 286, -1, -1));

        jButton1.setBackground(new java.awt.Color(153, 153, 153));
        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 80, 30));

        cancel.setBackground(new java.awt.Color(153, 153, 153));
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 330, 90, 30));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jButton2.setText("UPLOAD PHOTO");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jButton2)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 140, 110));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Password:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
    actionSave("UPDATE");
    

    }//GEN-LAST:event_updateActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
       actionSave("ADD");
    }//GEN-LAST:event_addActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
       new usertable().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       new usertable().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "png", "jpeg");
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            destinationPath = selectedFile.getAbsolutePath();
            displayImage(destinationPath);
            update.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed
    }
    private void addRoleSelection() {
        if (roleCombo == null) {
            roleCombo = new javax.swing.JComboBox<>();
            roleCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Select Role", "admin", "worker"}));
            jPanel1.add(roleCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 285, 150, 30));
            roleCombo.addActionListener(e -> update.setEnabled(true));
        }
    }

    private void groupGenders() {
        buttonGroup2.add(jRadioButton1);
        buttonGroup2.add(jRadioButton2);
    }

    private String getSafeValue(TableModel model, int row, int col) {
        return (model.getValueAt(row, col) != null) ? model.getValueAt(row, col).toString() : "";
    }
    
    
    public static void main(String args[]) {
   java.awt.EventQueue.invokeLater(() -> {
            new updateform().setVisible(true);
        });
            
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton cancel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JButton update;
    private javax.swing.JLabel userole;
    // End of variables declaration//GEN-END:variables
}
