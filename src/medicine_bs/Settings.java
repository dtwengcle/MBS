/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine_bs;

import config.connectDB;
import config.Session;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Markj
 */
public class Settings extends javax.swing.JInternalFrame {
    
    connectDB db = new connectDB();
    
    private String originalAnswer = "";
    private boolean hasChanges = false;

    /**
     * Creates new form Settings
     */
    public Settings() {
        initComponents();
        
        //remove border
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
        // Add change listener to track modifications
        securityAnswerField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(javax.swing.event.DocumentEvent e) { checkChanges(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { checkChanges(); }
            public void insertUpdate(javax.swing.event.DocumentEvent e) { checkChanges(); }
        });

        // Load existing security settings
        loadSecuritySettings();
    }
    
    private void loadSecuritySettings() {
        try {
            String userId = String.valueOf(Session.getInstance().getId());
            if (userId != null) {
                ResultSet rs = db.getData("SELECT security_question, security_answer FROM users WHERE id = '" + userId + "'");
                if (rs.next()) {
                    String question = rs.getString("security_question");
                    String answer = rs.getString("security_answer");
                    
                    if (question != null && !question.isEmpty()) {
                        // Find and select the matching question in the combo box
                        for (int i = 0; i < securityQuestionComboBox.getItemCount(); i++) {
                            if (securityQuestionComboBox.getItemAt(i).equals(question)) {
                                securityQuestionComboBox.setSelectedIndex(i);
                                break;
                            }
                        }
                    }
                    
                    if (answer != null && !answer.isEmpty()) {
                        securityAnswerField.setText(answer);
                        originalAnswer = answer;
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading security settings: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void checkChanges() {
        String currentAnswer = securityAnswerField.getText();
        hasChanges = !currentAnswer.equals(originalAnswer);
        applyButton.setEnabled(hasChanges);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        securityQuestionComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        securityAnswerField = new javax.swing.JTextField();
        applyButton = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setPreferredSize(new java.awt.Dimension(640, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(102, 102, 102));
        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel1.setText("Settings");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 21, -1, -1));

        jLabel3.setText("Security question:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, -1));

        securityQuestionComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What was the name of your first pet?", "What is the name of the street you grew up on?", "What was the model of your first car?", "What is your mother’s maiden name?", "What was the name of your elementary school?" }));
        securityQuestionComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                securityQuestionComboBoxActionPerformed(evt);
            }
        });
        jPanel1.add(securityQuestionComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 250, -1));

        jLabel2.setText("Answer:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));
        jPanel1.add(securityAnswerField, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 190, -1));

        applyButton.setText("Apply");
        applyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyButtonActionPerformed(evt);
            }
        });
        jPanel1.add(applyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void securityQuestionComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_securityQuestionComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_securityQuestionComboBoxActionPerformed

    private void applyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyButtonActionPerformed
        if (hasChanges) {
            String userId = String.valueOf(Session.getInstance().getId());
            if (userId == null) {
                JOptionPane.showMessageDialog(this, "User session not found. Please log in again.",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String question = (String) securityQuestionComboBox.getSelectedItem();
            String answer = securityAnswerField.getText();

            if (answer.trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Security answer cannot be empty!",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String query = "UPDATE users SET security_question = '" + question + "', " +
            "security_answer = '" + answer + "' " +
            "WHERE id = '" + userId + "'";

            int result = db.InsertData(query);
            if (result == 1) {
                originalAnswer = answer;
                hasChanges = false;
                applyButton.setEnabled(false);
                JOptionPane.showMessageDialog(this, "Security settings updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to update security settings. Please try again.",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_applyButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField securityAnswerField;
    private javax.swing.JComboBox<String> securityQuestionComboBox;
    // End of variables declaration//GEN-END:variables
}
