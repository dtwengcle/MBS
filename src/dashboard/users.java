
package dashboard;

import config.connectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public void displayData(){
        try{
            connectDB dbc = new connectDB();
            ResultSet rs = dbc.getData("SELECT * FROM users");
            users.setModel(DbUtils.resultSetToTableModel(rs));
             rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());

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
        jLabel1 = new javax.swing.JLabel();
        add = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        edit = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        delete = new javax.swing.JLabel();
        refresh = new javax.swing.JLabel();

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

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add-users.png"))); // NOI18N
        user_tbl.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 30, 30));

        add.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        add.setText("Add user");
        user_tbl.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/user-edit.png"))); // NOI18N
        user_tbl.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        edit.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        edit.setText("Edit user");
        user_tbl.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/delete-user.png"))); // NOI18N
        user_tbl.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, -1, -1));

        delete.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        delete.setText("Delete user");
        user_tbl.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, -1, -1));

        refresh.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh.png"))); // NOI18N
        refresh.setText("Refresh");
        user_tbl.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(user_tbl, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(user_tbl, javax.swing.GroupLayout.DEFAULT_SIZE, 541, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel add;
    private javax.swing.JLabel delete;
    private javax.swing.JLabel edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel refresh;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JPanel user_tbl;
    private javax.swing.JTable users;
    // End of variables declaration//GEN-END:variables
}
