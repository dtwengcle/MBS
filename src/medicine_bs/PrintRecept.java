/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine_bs;

import config.connectDB;
import config.panelPrinter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author markjay
 */
public class PrintRecept extends javax.swing.JFrame {
    private connectDB db;
    private int orderId;
    
    /**
     * Creates new form PrintRecept
     */
    public PrintRecept() {
        initComponents();
        db = new connectDB();
    }

    public void loadOrderData(int orderId) {
        this.orderId = orderId;
        try {
            String sql = "SELECT o.order_id, o.customer_name, m.name as medicine_name, " +
                        "oi.quantity, oi.total_price, o.order_date " +
                        "FROM order_items oi " +
                        "INNER JOIN orders o ON oi.order_id = o.order_id " +
                        "INNER JOIN medicines m ON oi.medicine_id = m.medicine_id " +
                        "WHERE o.order_id = " + orderId;
            
            ResultSet rs = db.getData(sql);
            if (rs.next()) {
                // Set receipt header
                receiptTitle.setText("MEDICINE STORE RECEIPT");
                receiptDate.setText("Date: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(rs.getTimestamp("order_date")));
                receiptNumber.setText("Receipt #: " + rs.getInt("order_id"));
                
                // Set customer info
                customerName.setText("Customer: " + rs.getString("customer_name"));
                
                // Set order details
                medicineName.setText("Medicine: " + rs.getString("medicine_name"));
                quantity.setText("Quantity: " + rs.getInt("quantity"));
                totalPrice.setText(String.format("Total: $%.2f", rs.getDouble("total_price")));
                
                // Set footer
                thankYou.setText("Thank you for your purchase!");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading order data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        receiptPanel = new javax.swing.JPanel();
        receiptTitle = new javax.swing.JLabel();
        receiptDate = new javax.swing.JLabel();
        receiptNumber = new javax.swing.JLabel();
        customerName = new javax.swing.JLabel();
        medicineName = new javax.swing.JLabel();
        quantity = new javax.swing.JLabel();
        totalPrice = new javax.swing.JLabel();
        thankYou = new javax.swing.JLabel();
        printButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Print Receipt");
        setResizable(false);

        receiptPanel.setBackground(new java.awt.Color(255, 255, 255));
        receiptPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        receiptPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        receiptTitle.setFont(new java.awt.Font("Arial", 1, 24));
        receiptTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        receiptTitle.setText("MEDICINE STORE RECEIPT");
        receiptPanel.add(receiptTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 360, 30));

        receiptDate.setFont(new java.awt.Font("Arial", 0, 14));
        receiptDate.setText("Date: ");
        receiptPanel.add(receiptDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 360, 20));

        receiptNumber.setFont(new java.awt.Font("Arial", 0, 14));
        receiptNumber.setText("Receipt #: ");
        receiptPanel.add(receiptNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 360, 20));

        customerName.setFont(new java.awt.Font("Arial", 0, 14));
        customerName.setText("Customer: ");
        receiptPanel.add(customerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 360, 20));

        medicineName.setFont(new java.awt.Font("Arial", 0, 14));
        medicineName.setText("Medicine: ");
        receiptPanel.add(medicineName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 360, 20));

        quantity.setFont(new java.awt.Font("Arial", 0, 14));
        quantity.setText("Quantity: ");
        receiptPanel.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 360, 20));

        totalPrice.setFont(new java.awt.Font("Arial", 1, 16));
        totalPrice.setText("Total: ");
        receiptPanel.add(totalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 360, 20));

        thankYou.setFont(new java.awt.Font("Arial", 2, 14));
        thankYou.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        thankYou.setText("Thank you for your purchase!");
        receiptPanel.add(thankYou, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 360, 20));

        printButton.setFont(new java.awt.Font("Arial", 1, 14));
        printButton.setText("Print Receipt");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });
        receiptPanel.add(printButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(receiptPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(receiptPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {
        panelPrinter panelprint = new panelPrinter(receiptPanel);
        panelprint.printPanel();
    }

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
            java.util.logging.Logger.getLogger(PrintRecept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrintRecept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrintRecept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrintRecept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrintRecept().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel customerName;
    private javax.swing.JLabel medicineName;
    private javax.swing.JButton printButton;
    private javax.swing.JLabel quantity;
    private javax.swing.JPanel receiptPanel;
    private javax.swing.JLabel receiptDate;
    private javax.swing.JLabel receiptNumber;
    private javax.swing.JLabel receiptTitle;
    private javax.swing.JLabel thankYou;
    private javax.swing.JLabel totalPrice;
    // End of variables declaration//GEN-END:variables
}
