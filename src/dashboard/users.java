
package dashboard;

import Admin_internalframe.Add_user;
import config.connectDB;
import java.awt.Frame;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import net.proteanit.sql.DbUtils;

public class users extends javax.swing.JInternalFrame {
    
    private static Add_user addUserFrame = null;
    
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
            try (ResultSet rs = dbc.getData("SELECT * FROM users")) {
                users.setModel(DbUtils.resultSetToTableModel(rs));
            }
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());

        }
    }
    
    private void openAddUserFrame() {
        if (addUserFrame == null || !addUserFrame.isDisplayable()) {
            addUserFrame = new Add_user(); // Create a new instance if null or closed
            addUserFrame.setVisible(true);
        } else {
            if (addUserFrame.getState() == Frame.ICONIFIED) {
                addUserFrame.setState(Frame.NORMAL); // Restore if minimized
            }
            addUserFrame.toFront(); // Bring to front
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane1 = new java.awt.ScrollPane();
        user_tbl = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        users = new javax.swing.JTable();
        addUser = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        add = new javax.swing.JLabel();
        EditUser = new javax.swing.JPanel();
        edit = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        deleteUser = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        delete = new javax.swing.JLabel();
        refresh = new javax.swing.JPanel();
        refresh1 = new javax.swing.JLabel();

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

        user_tbl.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 610, 430));

        addUser.setBackground(new java.awt.Color(255, 153, 153));
        addUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addUserMouseClicked(evt);
            }
        });
        addUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add-users.png"))); // NOI18N
        addUser.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 30));

        add.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        add.setText("Add user");
        addUser.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        user_tbl.add(addUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 110, 30));

        EditUser.setBackground(new java.awt.Color(255, 153, 153));
        EditUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        edit.setText("Edit user");
        EditUser.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user-edit.png"))); // NOI18N
        EditUser.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 30));

        user_tbl.add(EditUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, 110, 30));

        deleteUser.setBackground(new java.awt.Color(255, 153, 153));
        deleteUser.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteUserMouseClicked(evt);
            }
        });
        deleteUser.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete-user.png"))); // NOI18N
        deleteUser.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 30));

        delete.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        delete.setText("Delete user");
        deleteUser.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, -1, 30));

        user_tbl.add(deleteUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 450, 110, 30));

        refresh.setBackground(new java.awt.Color(255, 153, 153));
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshMouseClicked(evt);
            }
        });
        refresh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        refresh1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        refresh1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        refresh1.setText("Refresh");
        refresh.add(refresh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 80, 30));

        user_tbl.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 450, 110, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(user_tbl, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(user_tbl, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addUserMouseClicked
        openAddUserFrame();
    }//GEN-LAST:event_addUserMouseClicked

    private void refreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseClicked
        displayData();
    }//GEN-LAST:event_refreshMouseClicked

    private void deleteUserMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteUserMouseClicked
        int row = users.getSelectedRow(); 

        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this user?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        String id = users.getValueAt(row, 0).toString(); 

        if (connectDB.updateDatabase("DELETE FROM users WHERE id = '" + id + "'")) {
            displayData();
            JOptionPane.showMessageDialog(this, "User deleted successfully.", "Deleted", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Failed to delete user.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_deleteUserMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel EditUser;
    private javax.swing.JLabel add;
    private javax.swing.JPanel addUser;
    private javax.swing.JLabel delete;
    private javax.swing.JPanel deleteUser;
    private javax.swing.JLabel edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel refresh;
    private javax.swing.JLabel refresh1;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JPanel user_tbl;
    private javax.swing.JTable users;
    // End of variables declaration//GEN-END:variables
}
