/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine_bs;

import config.connectDB;
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Login_Panel = new javax.swing.JPanel();
        reg = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        name = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        username1 = new javax.swing.JLabel();
        passField = new javax.swing.JTextField();
        pass = new javax.swing.JLabel();
        textield3 = new javax.swing.JTextField();
        conpass = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        email = new javax.swing.JLabel();
        genderField = new javax.swing.JComboBox<>();
        create_acc = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Login_Panel.setBackground(new java.awt.Color(153, 255, 255));
        Login_Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reg.setFont(new java.awt.Font("Arial Black", 1, 30)); // NOI18N
        reg.setForeground(new java.awt.Color(51, 51, 51));
        reg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reg.setText("REGISTER");
        Login_Panel.add(reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 310, 50));

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });
        Login_Panel.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 230, 40));

        name.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("Name");
        Login_Panel.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 230, -1));

        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        Login_Panel.add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 230, 40));

        username1.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        username1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        username1.setText("Username");
        Login_Panel.add(username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 230, -1));

        passField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFieldActionPerformed(evt);
            }
        });
        Login_Panel.add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 300, 230, 40));

        pass.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        pass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pass.setText("Password");
        Login_Panel.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 230, -1));

        textield3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textield3ActionPerformed(evt);
            }
        });
        Login_Panel.add(textield3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 160, 230, 40));

        conpass.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        conpass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        conpass.setText("Confirm Password");
        Login_Panel.add(conpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, 230, -1));

        emailField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailFieldActionPerformed(evt);
            }
        });
        Login_Panel.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 230, 40));

        email.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        email.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        email.setText("Email");
        Login_Panel.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 230, -1));

        genderField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Female", "Male" }));
        genderField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genderFieldActionPerformed(evt);
            }
        });
        Login_Panel.add(genderField, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, 230, 40));

        create_acc.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        create_acc.setForeground(new java.awt.Color(102, 0, 102));
        create_acc.setText("Click here to Sign in");
        create_acc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                create_accMouseClicked(evt);
            }
        });
        Login_Panel.add(create_acc, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, 150, -1));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jLabel1.setText("Already have an acount? ");
        Login_Panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 500, 170, -1));

        registerButton.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        registerButton.setText("Register");
        registerButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerButtonMouseClicked(evt);
            }
        });
        Login_Panel.add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 110, 40));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/alo.png"))); // NOI18N
        background.setText("jLabel2");
        Login_Panel.add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Login_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Login_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
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

    private void textield3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textield3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textield3ActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void registerButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerButtonMouseClicked
        
                // Get user input and trim spaces
        String u_name = nameField.getText().trim();
        String usern = usernameField.getText().trim();
        String genderSelected = (genderField.getSelectedItem() != null) ? genderField.getSelectedItem().toString() : "";
        String email = emailField.getText().trim();
        String pass = passField.getText().trim(); // TODO: Hash password before saving

        // Validate inputs
        if (u_name.isEmpty() || usern.isEmpty() || genderSelected.isEmpty() || email.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required!", "Input Error", JOptionPane.ERROR_MESSAGE);
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
            String checkEmailSql = "SELECT COUNT(*) FROM user WHERE u_email = ?";
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
            String checkUsernameSql = "SELECT COUNT(*) FROM user WHERE u_username = ?";
            try (PreparedStatement usernamePst = cn.prepareStatement(checkUsernameSql)) {
                usernamePst.setString(1, usern);
                try (ResultSet rsUsername = usernamePst.executeQuery()) {
                    if (rsUsername.next() && rsUsername.getInt(1) > 0) {
                        JOptionPane.showMessageDialog(null, "Username already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }

            // **Insert user data into the database**
            String insertSql = "INSERT INTO user (u_fname, u_username, u_email, u_password, u_gender) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement pst = cn.prepareStatement(insertSql)) {
                pst.setString(1, u_name);
                pst.setString(2, usern);
                pst.setString(3, email);
                pst.setString(4, pass); // TODO: Hash password before saving
                pst.setString(5, genderSelected);

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
    private javax.swing.JLabel background;
    private javax.swing.JLabel conpass;
    private javax.swing.JLabel create_acc;
    private javax.swing.JLabel email;
    private javax.swing.JTextField emailField;
    private javax.swing.JComboBox<String> genderField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel name;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel pass;
    private javax.swing.JTextField passField;
    private javax.swing.JLabel reg;
    private javax.swing.JButton registerButton;
    private javax.swing.JTextField textield3;
    private javax.swing.JLabel username1;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
