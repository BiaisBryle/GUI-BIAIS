
package admin;

import config.config;
import config.Session;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;






public class updateform extends javax.swing.JFrame {
    String userID;
    private javax.swing.JComboBox<String> roleCombo;
    
 public updateform() {
        // --- SESSION CHECK START ---
        Session sess = Session.getInstance();
        if (sess.getId() == 0) { // Kung 0, pasabot wala naka-login
            JOptionPane.showMessageDialog(null, "Please Login First!");
            java.awt.EventQueue.invokeLater(() -> {
                new main.login().setVisible(true); // I-redirect sa login (landing page)
            });
            this.dispose();
            return; // Dili na ipadayon ang ubang code sa ubos
        }
        // --- SESSION CHECK END ---

        initComponents();
        this.setLocationRelativeTo(null);
        groupGenders();
        addRoleSelection();
        
        update.setVisible(false); 
        add.setVisible(true);  
        jLabel5.setText("Add New User Profile");
    }

    // 3. CONSTRUCTOR PARA SA "UPDATE"
    public updateform(TableModel model, int rowIndex) {
        // --- SESSION CHECK START ---
        Session sess = Session.getInstance();
        if (sess.getId() == 0) {
            JOptionPane.showMessageDialog(null, "Please Login First!");
            java.awt.EventQueue.invokeLater(() -> {
                new main.login().setVisible(true);
            });
            this.dispose();
            return;
        }
        // --- SESSION CHECK END ---

        initComponents();
        this.setLocationRelativeTo(null);
        groupGenders();
        
        userole.setVisible(false);
        update.setVisible(true);  
        add.setVisible(false); 
        jLabel5.setText("Update User Profile");

        try {
            userID = (model.getValueAt(rowIndex, 0) != null) ? model.getValueAt(rowIndex, 0).toString() : "";
            jTextField1.setText(getSafeValue(model, rowIndex, 1)); 
            jTextField3.setText(getSafeValue(model, rowIndex, 2)); 
            jTextField2.setText(getSafeValue(model, rowIndex, 3)); 
            jTextField4.setText(getSafeValue(model, rowIndex, 6)); 
            
            String currentGender = getSafeValue(model, rowIndex, 7);
            if (currentGender.equalsIgnoreCase("Male")) {
                jRadioButton1.setSelected(true);
            } else if (currentGender.equalsIgnoreCase("Female")) {
                jRadioButton2.setSelected(true);
            }
        } catch (Exception e) {
            System.out.println("Error Loading Data: " + e.getMessage());
        }
    }

    // ... (Ang ubang methods sama sa addRoleSelection, getSafeValue, etc. pabilin lang)
    
    private void addRoleSelection() {
        roleCombo = new javax.swing.JComboBox<>();
        roleCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Select Role", "admin", "worker"}));
        jPanel1.setLayout(null); 
        roleCombo.setBounds(120, 285, 150, 30); 
        jPanel1.add(roleCombo);
        jPanel1.revalidate();
        jPanel1.repaint();
    }

    private String getSafeValue(TableModel model, int row, int col) {
        return (model.getValueAt(row, col) != null) ? model.getValueAt(row, col).toString() : "";
    }

    private void groupGenders() {
        javax.swing.ButtonGroup genderGroup = new javax.swing.ButtonGroup();
        genderGroup.add(jRadioButton1);
        genderGroup.add(jRadioButton2);
    }

    private void actionSave(String mode) {
        // ... (Imong save logic pabilin lang)
        String fname = jTextField1.getText().trim();
        String lname = jTextField3.getText().trim();
        String email = jTextField2.getText().trim();
        String address = jTextField4.getText().trim();
        String gender = jRadioButton1.isSelected() ? "Male" : (jRadioButton2.isSelected() ? "Female" : "");

        if (fname.isEmpty() || lname.isEmpty() || email.isEmpty() || gender.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill up all fields!");
            return;
        }

        config conf = new config();
        if (mode.equals("ADD")) {
            if(roleCombo.getSelectedItem().equals("Select Role")){
                JOptionPane.showMessageDialog(null, "Please select a User Role!");
                return;
            }
            String role = roleCombo.getSelectedItem().toString();
            String sql = "INSERT INTO user (u_name, u_lname, u_email, u_address, u_gender, u_role, u_status) VALUES (?, ?, ?, ?, ?, ?, 'Pending')";
            conf.updateRecord(sql, fname, lname, email, address, gender, role);
            JOptionPane.showMessageDialog(null, "User Added Successfully!");
        } else {
            String sql = "UPDATE user SET u_name = ?, u_lname = ?, u_email = ?, u_address = ?, u_gender = ? WHERE u_id = ?";
            conf.updateRecord(sql, fname, lname, email, address, gender, userID);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        userole = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(245, 205, 208));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 119, 100, -1));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 182, 100, -1));
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 149, 100, 24));

        jRadioButton1.setText("Male");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 245, -1, -1));

        jRadioButton2.setText("Felame");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 245, -1, -1));
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 212, 253, 24));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("First name:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 119, -1, 19));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Last name:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 148, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Email:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Address:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 211, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("Profile");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 260, -1));

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel1.add(update, new org.netbeans.lib.awtextra.AbsoluteConstraints(141, 279, 98, 41));

        add.setText("Add");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel1.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 280, 90, 41));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 123));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(337, 60, 120, -1));

        userole.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userole.setText("User Role:");
        jPanel1.add(userole, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 286, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
     java.awt.EventQueue.invokeLater(() -> {
            new updateform().setVisible(true);
        });
            
      
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.ButtonGroup buttonGroup2;
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
    private javax.swing.JButton update;
    private javax.swing.JLabel userole;
    // End of variables declaration//GEN-END:variables
}
