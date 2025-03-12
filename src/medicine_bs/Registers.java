/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine_bs;

import config.connectDB;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author mikel
 */
public class Registers extends javax.swing.JFrame {

    /**
     * Creates new form Registers
     */
    public Registers() {
        initComponents();
    }

         private Color hoverColor = new Color(180, 180, 180); // Grayish color on hover
         private Color defaultColor = new Color(255, 255, 255); // Default white color
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login_Panel = new javax.swing.JPanel();
        nameField = new javax.swing.JTextField();
        name = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        username1 = new javax.swing.JLabel();
        passField = new javax.swing.JTextField();
        pass = new javax.swing.JLabel();
        passField2 = new javax.swing.JTextField();
        conpass = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        genderField = new javax.swing.JComboBox<>();
        role = new javax.swing.JComboBox<>();
        create_acc = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        reg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Login_Panel.setBackground(new java.awt.Color(255, 153, 153));
        Login_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });
        Login_Panel.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 230, 40));

        name.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("Name");
        Login_Panel.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 230, 20));

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        Login_Panel.add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 230, 40));

        username1.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        username1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username1.setText("Username");
        Login_Panel.add(username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 230, -1));

        passField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFieldActionPerformed(evt);
            }
        });
        Login_Panel.add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 230, 40));

        pass.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        pass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pass.setText("Password");
        Login_Panel.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 230, -1));

        passField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passField2ActionPerformed(evt);
            }
        });
        Login_Panel.add(passField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, 230, 40));

        conpass.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        conpass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        conpass.setText("Confirm Password");
        Login_Panel.add(conpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 230, -1));

        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });
        Login_Panel.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, 230, 40));

        email.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        email.setText("Email");
        Login_Panel.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 150, 230, -1));

        genderField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male" }));
        genderField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderFieldActionPerformed(evt);
            }
        });
        Login_Panel.add(genderField, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 180, 230, 40));

        role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Staff" }));
        role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roleActionPerformed(evt);
            }
        });
        Login_Panel.add(role, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 230, 40));

        create_acc.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        create_acc.setForeground(new java.awt.Color(102, 0, 102));
        create_acc.setText("Click here to Sign in");
        create_acc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                create_accMouseClicked(evt);
            }
        });
        Login_Panel.add(create_acc, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 150, 20));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("Already have an acount? ");
        Login_Panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 170, -1));

        registerButton.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        registerButton.setText("Register");
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButtonMouseClicked(evt);
            }
        });
        Login_Panel.add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 110, 40));

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        reg.setFont(new java.awt.Font("Arial Black", 1, 30)); // NOI18N
        reg.setForeground(new java.awt.Color(51, 51, 51));
        reg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reg.setText("REGISTER");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(237, 237, 237)
                .addComponent(reg, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(283, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(reg, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Login_Panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Login_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Login_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    private void passFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passFieldActionPerformed

    private void passField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passField2ActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void registerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseClicked
        
                // Get users input and trim spaces
        String u_name = nameField.getText().trim();
        String usern = usernameField.getText().trim();
        String genderSelected = (genderField.getSelectedItem() != null) ? genderField.getSelectedItem().toString() : "";
        String roleSelected = (role.getSelectedItem() != null) ? role.getSelectedItem().toString() : "";
        String email = emailField.getText().trim();
        String pass1 = passField.getText().trim(); // TODO: Hash password before saving
        String pass2 = passField2.getText().trim();

        // Validate inputs
        if (u_name.isEmpty() || usern.isEmpty() || genderSelected.isEmpty() || email.isEmpty() || pass1.isEmpty() || pass2.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(!pass1.equals(pass2)){
            JOptionPane.showMessageDialog(null, "Passwords DO NOT Match!", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Database Connection
        connectDB con = new connectDB();
        Connection cn = con.getConnection();

        if (cn == null) {
            JOptionPane.showMessageDialog(null, "Database connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // **Check if email already exists**
            String checkEmailSql = "SELECT COUNT(*) FROM users WHERE email = ?";
            try (PreparedStatement emailPst = cn.prepareStatement(checkEmailSql)) {
                emailPst.setString(1, email);
                try (ResultSet rsEmail = emailPst.executeQuery()) {
                    if (rsEmail.next() && rsEmail.getInt(1) > 0) {
                        JOptionPane.showMessageDialog(null, "Email already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }

            // **Check if username already exists**
            String checkUsernameSql = "SELECT COUNT(*) FROM users WHERE username = ?";
            try (PreparedStatement usernamePst = cn.prepareStatement(checkUsernameSql)) {
                usernamePst.setString(1, usern);
                try (ResultSet rsUsername = usernamePst.executeQuery()) {
                    if (rsUsername.next() && rsUsername.getInt(1) > 0) {
                        JOptionPane.showMessageDialog(null, "Username already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }

            // **Insert users data into the database**
            String insertSql = "INSERT INTO users (name, username, email, password, gender, role, status) VALUES (?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pst = cn.prepareStatement(insertSql)) {
                pst.setString(1, u_name);
                pst.setString(2, usern);
                pst.setString(3, email);
                pst.setString(4, pass1); // TODO: Hash password before saving
                pst.setString(5, genderSelected);
                pst.setString(6, roleSelected);
                pst.setString(7, (roleSelected.equals("Admin") ? "Active" : "Pending"));

                int result = pst.executeUpdate();
                if (result == 1) {
                    JOptionPane.showMessageDialog(null, "Registered Successfully!");
                    new LOGIN().setVisible(true);
                    SwingUtilities.getWindowAncestor(nameField).dispose(); // Close the registration form
                } else {
                    JOptionPane.showMessageDialog(null, "Registration failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (cn != null) cn.close(); // Ensure connection is closed
            } catch (SQLException ex) {
                Logger.getLogger(Registers.class.getName()).log(Level.SEVERE, null, ex);
            }
}


    }//GEN-LAST:event_registerButtonMouseClicked

    private void genderFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genderFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_genderFieldActionPerformed

    private void create_accMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_create_accMouseClicked
        LOGIN log = new LOGIN();
        log.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_create_accMouseClicked

    private void roleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_roleActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registers.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registers().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Login_Panel;
    private javax.swing.JLabel conpass;
    private javax.swing.JLabel create_acc;
    private javax.swing.JLabel email;
    private javax.swing.JTextField emailField;
    private javax.swing.JComboBox<String> genderField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel name;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel pass;
    private javax.swing.JTextField passField;
    private javax.swing.JTextField passField2;
    private javax.swing.JLabel reg;
    private javax.swing.JButton registerButton;
    private javax.swing.JComboBox<String> role;
    private javax.swing.JLabel username1;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
