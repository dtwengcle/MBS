package medicine_bs;

import Admin_internalframe.Edit_user;
import Admin_internalframe.Add_user;
import config.connectDB;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;

public class users extends javax.swing.JInternalFrame {
    
    public users() {
        initComponents();
        displayData();
        
        //remove border
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }

    public final void displayData(){
        try{
            connectDB dbc = new connectDB();
            try (ResultSet rs = dbc.getData("SELECT name, username, email, role, status FROM users")) {
                users.setModel(DbUtils.resultSetToTableModel(rs));
            }
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());

        }
    }
    
//    private void openAddUserFrame() {
//        
//    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane1 = new java.awt.ScrollPane();
        user_tbl = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        users = new javax.swing.JTable();
        addUser = new javax.swing.JPanel();
        EditUser = new javax.swing.JPanel();
        deleteUser = new javax.swing.JPanel();
        refresh = new javax.swing.JPanel();
        search_bar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        refresh1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        delete = new javax.swing.JLabel();
        edit = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        add = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        user_tbl.setBackground(new java.awt.Color(255, 153, 153));
        user_tbl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(users);

        jScrollPane2.setViewportView(jScrollPane1);

        user_tbl.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 610, 270));

        addUser.setBackground(new java.awt.Color(255, 153, 153));
        addUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addUserMouseClicked(evt);
            }
        });
        addUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        user_tbl.add(addUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 110, 30));

        EditUser.setBackground(new java.awt.Color(255, 153, 153));
        EditUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        user_tbl.add(EditUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 490, 110, 30));

        deleteUser.setBackground(new java.awt.Color(255, 153, 153));
        deleteUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteUserMouseClicked(evt);
            }
        });
        deleteUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        user_tbl.add(deleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 490, 110, 30));

        refresh.setBackground(new java.awt.Color(255, 153, 153));
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });
        refresh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        user_tbl.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 490, 110, 30));

        search_bar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        search_bar.setForeground(new java.awt.Color(153, 153, 153));
        search_bar.setText(" search...");
        search_bar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        search_bar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                search_barFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                search_barFocusLost(evt);
            }
        });
        search_bar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_barActionPerformed(evt);
            }
        });
        search_bar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                search_barKeyReleased(evt);
            }
        });
        user_tbl.add(search_bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 170, 25));

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("jLabel4");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 30, -1));

        user_tbl.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 25, 25));

        refresh1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        refresh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        refresh1.setText("Refresh");
        refresh1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        refresh1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refresh1MouseClicked(evt);
            }
        });
        user_tbl.add(refresh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 350, 80, 30));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete-user.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        user_tbl.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 350, 30, 30));

        delete.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        delete.setText("Delete user");
        delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        user_tbl.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 350, -1, 30));

        edit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        edit.setText("Edit user");
        edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        edit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMouseClicked(evt);
            }
        });
        user_tbl.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, -1, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user-edit.png"))); // NOI18N
        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        user_tbl.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 30, 30));

        add.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        add.setText("Add user");
        add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        user_tbl.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add-users.png"))); // NOI18N
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        user_tbl.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(user_tbl, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(user_tbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(104, 104, 104))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserMouseClicked

//        new Add_user().setVisible(true);
    }//GEN-LAST:event_addUserMouseClicked

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        
    }//GEN-LAST:event_refreshMouseClicked

    private void deleteUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteUserMouseClicked
        
    }//GEN-LAST:event_deleteUserMouseClicked

    private void search_barFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search_barFocusGained
        if (search_bar.getText().equals(" search...")) {
            search_bar.setText("");
            search_bar.setFont(new Font("Arial", Font.PLAIN, 11));
            search_bar.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_search_barFocusGained

    private void search_barFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_search_barFocusLost
        if (search_bar.getText().isEmpty()) {
            search_bar.setText(" search...");
            search_bar.setFont(new Font("Arial", Font.PLAIN, 11));
            search_bar.setForeground(Color.GRAY);
        }
    }//GEN-LAST:event_search_barFocusLost

    private void search_barActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_barActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_barActionPerformed

    private void search_barKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_search_barKeyReleased
        
    }//GEN-LAST:event_search_barKeyReleased

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
//         TODO add your handling code here:
                Add_user addUserFrame = Add_user.getInstance();
        
        if (addUserFrame == null || !addUserFrame.isDisplayable()) {
            addUserFrame = new Add_user(); // Create a new instance if null or closed
            addUserFrame.setVisible(true);
        } else {
            if (addUserFrame.getState() == Frame.ICONIFIED) {
                addUserFrame.setState(Frame.NORMAL); // Restore if minimized
            }
            addUserFrame.toFront(); // Bring to front
        }
    }//GEN-LAST:event_addMouseClicked

    private void editMouseClicked(java.awt.event.MouseEvent evt) {
        int row = users.getSelectedRow();
        
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a user to edit.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Get the selected user's data
        String name = users.getValueAt(row, 0).toString();
        String username = users.getValueAt(row, 1).toString();
        String email = users.getValueAt(row, 2).toString();
        String role = users.getValueAt(row, 3).toString();
        String status = users.getValueAt(row, 4).toString();
        
        // Create and show the edit user dialog
        Edit_user editUserFrame = new Edit_user();
        editUserFrame.setUserData(name, username, email, role, status);
        editUserFrame.setVisible(true);
    }

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked
        // TODO add your handling code here:
        int row = users.getSelectedRow(); 

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this user?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        String username = users.getValueAt(row, 1).toString(); 

        if (connectDB.executeQuery("DELETE FROM users WHERE username = '" + username + "'")) {
            displayData();
            JOptionPane.showMessageDialog(this, "User deleted successfully.", "Deleted", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete user.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteMouseClicked

    private void refresh1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refresh1MouseClicked
        // TODO add your handling code here:
        displayData();
    }//GEN-LAST:event_refresh1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EditUser;
    private javax.swing.JLabel add;
    private javax.swing.JPanel addUser;
    private javax.swing.JLabel delete;
    private javax.swing.JPanel deleteUser;
    private javax.swing.JLabel edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel refresh;
    private javax.swing.JLabel refresh1;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JTextField search_bar;
    private javax.swing.JPanel user_tbl;
    private javax.swing.JTable users;
    // End of variables declaration//GEN-END:variables
}
