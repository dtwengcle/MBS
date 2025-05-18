/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order;

import config.connectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author markjay
 */
public class AddOrder extends javax.swing.JFrame {
    private connectDB db;
    private double medicinePrice;

    /**
     * Creates new form AddOrder
     */
    public AddOrder() {
        initComponents();
        db = new connectDB();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // Add listeners
        addButton.addActionListener(e -> addOrder());
        quantityField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(javax.swing.event.DocumentEvent e) { calculateTotal(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { calculateTotal(); }
            public void insertUpdate(javax.swing.event.DocumentEvent e) { calculateTotal(); }
        });
        medicineIDField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(javax.swing.event.DocumentEvent e) { validateMedicine(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { validateMedicine(); }
            public void insertUpdate(javax.swing.event.DocumentEvent e) { validateMedicine(); }
        });
    }

    private void validateMedicine() {
        String medicineId = medicineIDField.getText().trim();
        if (!medicineId.isEmpty()) {
            try {
                String sql = "SELECT price, quantity_in_stock FROM medicines WHERE medicine_id = " + Integer.parseInt(medicineId);
                ResultSet rs = db.getData(sql);
                if (rs.next()) {
                    medicinePrice = rs.getDouble("price");
                    calculateTotal();
                } else {
                    medicinePrice = 0;
                    totalPriceField.setText("");
                    JOptionPane.showMessageDialog(this, "Medicine ID not found", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error validating medicine: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void calculateTotal() {
        try {
            String quantityStr = quantityField.getText().trim();
            if (!quantityStr.isEmpty()) {
                int quantity = Integer.parseInt(quantityStr);
                if (quantity > 0) {
                    double total = quantity * medicinePrice;
                    totalPriceField.setText(String.format("%.2f", total));
                } else {
                    totalPriceField.setText("");
                }
            } else {
                totalPriceField.setText("");
            }
        } catch (NumberFormatException ex) {
            totalPriceField.setText("");
        }
    }

    private void addOrder() {
        // Get input values
        String customerName = customerNameField.getText().trim();
        String medicineId = medicineIDField.getText().trim();
        String quantityStr = quantityField.getText().trim();

        // Validate inputs
        if (customerName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter customer name", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (medicineId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter medicine ID", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (quantityStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter quantity", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int quantity = Integer.parseInt(quantityStr);
            if (quantity <= 0) {
                JOptionPane.showMessageDialog(this, "Quantity must be greater than 0", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Check if enough stock is available
            String checkStockSql = "SELECT quantity_in_stock FROM medicines WHERE medicine_id = " + Integer.parseInt(medicineId);
            ResultSet rs = db.getData(checkStockSql);
            if (rs.next()) {
                int availableStock = rs.getInt("quantity_in_stock");
                if (quantity > availableStock) {
                    JOptionPane.showMessageDialog(this, 
                        "Not enough stock available. Only " + availableStock + " items in stock.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Calculate total price
            double totalPrice = quantity * medicinePrice;

            // First insert into orders table to get order_id
            String insertOrderSql = "INSERT INTO orders (customer_name, order_date) VALUES (?, CURRENT_DATE)";
            boolean orderSuccess = db.executeQuery(insertOrderSql, customerName);

            if (orderSuccess) {
                // Get the generated order_id
                String getOrderIdSql = "SELECT LAST_INSERT_ID() as order_id";
                ResultSet orderRs = db.getData(getOrderIdSql);
                if (orderRs.next()) {
                    int orderId = orderRs.getInt("order_id");
                    
                    // Insert into order_items table
                    String insertOrderItemSql = "INSERT INTO order_items (order_id, medicine_id, quantity, total_price) VALUES (?, ?, ?, ?)";
                    boolean itemSuccess = db.executeQuery(insertOrderItemSql, orderId, Integer.parseInt(medicineId), quantity, totalPrice);

                    if (itemSuccess) {
                        // Update inventory quantity
                        String updateStockSql = "UPDATE medicines SET quantity_in_stock = quantity_in_stock - ? WHERE medicine_id = ?";
                        boolean updateSuccess = db.executeQuery(updateStockSql, quantity, Integer.parseInt(medicineId));

                        if (updateSuccess) {
                            JOptionPane.showMessageDialog(this, "Order added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                            clearFields();
                        } else {
                            JOptionPane.showMessageDialog(this, "Failed to update inventory", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to add order item", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to get order ID", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add order", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for quantity", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        customerNameField.setText("");
        medicineIDField.setText("");
        quantityField.setText("");
        totalPriceField.setText("");
        customerNameField.requestFocus();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        customerNameField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        quantityField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        totalPriceField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        medicineIDField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        jLabel1.setText("Add Order");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addComponent(jLabel1)
                .addContainerGap(186, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(26, 26, 26))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 80));

        jLabel2.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Customer Name");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 140, 20));

        customerNameField.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        customerNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(customerNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 140, 40));

        jLabel3.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Medicine ID");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 140, 20));

        jLabel4.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Quantity");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 140, 20));

        quantityField.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        quantityField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(quantityField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 140, 40));

        jLabel5.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Total Price");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 140, 20));

        totalPriceField.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        totalPriceField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalPriceField.setEditable(false);
        jPanel1.add(totalPriceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, 140, 40));

        addButton.setBackground(new java.awt.Color(255, 102, 102));
        addButton.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        addButton.setText("Add Order");
        jPanel1.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 140, 40));
        jPanel1.add(medicineIDField, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 140, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTextField customerNameField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField medicineIDField;
    private javax.swing.JTextField quantityField;
    private javax.swing.JTextField totalPriceField;
    // End of variables declaration//GEN-END:variables
}
