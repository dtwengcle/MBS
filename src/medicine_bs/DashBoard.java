/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine_bs;

import dashboard.users;

/**
 *
 * @author SCC-COLLEGE
 */
public class DashBoard extends javax.swing.JFrame {

    /**
     * Creates new form DashBoard
     */
    public DashBoard() {
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

        jPanel2 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        Dashboard = new javax.swing.JLabel();
        userpanel1 = new javax.swing.JPanel();
        users1 = new javax.swing.JLabel();
        userpanel = new javax.swing.JPanel();
        users = new javax.swing.JLabel();
        Dashboard1 = new javax.swing.JLabel();
        maindesktop = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/im1.png"))); // NOI18N
        jPanel2.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, 70));

        Dashboard.setBackground(new java.awt.Color(0, 102, 102));
        Dashboard.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        Dashboard.setForeground(new java.awt.Color(0, 102, 102));
        Dashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Dashboard.setText("Admin ");
        jPanel2.add(Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, 22));

        userpanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userpanel1MouseClicked(evt);
            }
        });
        userpanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        users1.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        users1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        users1.setText("Home");
        userpanel1.add(users1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 30));

        jPanel2.add(userpanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 100, 30));

        userpanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userpanelMouseClicked(evt);
            }
        });
        userpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        users.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        users.setText("users");
        users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersMouseClicked(evt);
            }
        });
        userpanel.add(users, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 30));

        jPanel2.add(userpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 100, 30));

        Dashboard1.setBackground(new java.awt.Color(0, 102, 102));
        Dashboard1.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        Dashboard1.setForeground(new java.awt.Color(0, 102, 102));
        Dashboard1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Dashboard1.setText("Dashboard");
        jPanel2.add(Dashboard1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, 110, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 550));

        maindesktop.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout maindesktopLayout = new javax.swing.GroupLayout(maindesktop);
        maindesktop.setLayout(maindesktopLayout);
        maindesktopLayout.setHorizontalGroup(
            maindesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        maindesktopLayout.setVerticalGroup(
            maindesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        getContentPane().add(maindesktop, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 650, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userpanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userpanelMouseClicked
        users us = new users();
        maindesktop.add(us).setVisible(true);
        
    }//GEN-LAST:event_userpanelMouseClicked

    private void userpanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userpanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_userpanel1MouseClicked

    private void usersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersMouseClicked
        users us = new users();
        maindesktop.add(us).setVisible(true);
    }//GEN-LAST:event_usersMouseClicked

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
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dashboard;
    private javax.swing.JLabel Dashboard1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logo;
    private javax.swing.JDesktopPane maindesktop;
    private javax.swing.JPanel userpanel;
    private javax.swing.JPanel userpanel1;
    private javax.swing.JLabel users;
    private javax.swing.JLabel users1;
    // End of variables declaration//GEN-END:variables
}
