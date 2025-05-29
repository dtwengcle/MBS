package order;

import config.connectDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class AddOrder extends javax.swing.JFrame {
    private connectDB db;
    private double medicinePrice;
    private String selectedMedicineId = "";  // Store the selected medicine ID
    private DefaultTableModel tableModel;

    public AddOrder() {
        initComponents();
        db = new connectDB();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Initialize table model with proper columns
        tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] { "Medicine ID", "Medicine Name", "Quantity", "Unit Price", "Total Price" }
        );
        orderTable.setModel(tableModel);

        // Populate the ComboBox with medicine names
        populateMedicineComboBox();

        // Add action listeners
        addButton.addActionListener(e -> addOrder());
        quantityField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(javax.swing.event.DocumentEvent e) { calculateTotal(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { calculateTotal(); }
            public void insertUpdate(javax.swing.event.DocumentEvent e) { calculateTotal(); }
        });
        medicineComboBox.addActionListener(e -> updateSelectedMedicineDetails());
        jButton1.addActionListener(e -> addMedicineToTable());  // "Add Medicine" button
    }

    
    private void populateMedicineComboBox() {
        medicineComboBox.removeAllItems();
        medicineComboBox.addItem("Select a Medicine");
        try {
            String query = "SELECT medicine_id, name FROM medicines";
            ResultSet rs = db.getData(query);
            while (rs.next()) {
                String medicineName = rs.getString("name");
                String medicineId = rs.getString("medicine_id");
                medicineComboBox.addItem(medicineName + " (ID: " + medicineId + ")");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading medicines: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void updateSelectedMedicineDetails() {
        String selectedMedicine = (String) medicineComboBox.getSelectedItem();

        if (selectedMedicine == null || selectedMedicine.equals("Select a Medicine")) {
            selectedMedicineId = "";
            medicinePrice = 0;
            totalPriceField.setText("");
            return;
        }

        try {
            // Extract the ID inside parentheses: e.g. "Paracetamol (ID: 5)" => 5
            int start = selectedMedicine.indexOf("ID: ") + 4;
            int end = selectedMedicine.indexOf(")", start);
            selectedMedicineId = selectedMedicine.substring(start, end);

            String query = "SELECT price FROM medicines WHERE medicine_id = " + Integer.parseInt(selectedMedicineId);
            ResultSet rs = db.getData(query);
            if (rs.next()) {
                medicinePrice = rs.getDouble("price");
                calculateTotal();
            } else {
                JOptionPane.showMessageDialog(this, "Medicine not found in the database", "Error", JOptionPane.ERROR_MESSAGE);
                medicinePrice = 0;
                totalPriceField.setText("");
            } 
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error fetching medicine details: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            medicinePrice = 0;
            totalPriceField.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid medicine ID format", "Error", JOptionPane.ERROR_MESSAGE);
            medicinePrice = 0;
            totalPriceField.setText("");
        }
    }

    private void addMedicineToTable() {
        if (selectedMedicineId.isEmpty() || medicinePrice <= 0) {
            JOptionPane.showMessageDialog(this, "Please select a valid medicine", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String quantityStr = quantityField.getText().trim();
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

            double totalPrice = quantity * medicinePrice;

            // Extract medicine name from ComboBox selection (before " (ID: ...")
            String selectedMedicine = (String) medicineComboBox.getSelectedItem();
            String medicineName = selectedMedicine.substring(0, selectedMedicine.indexOf(" (ID:"));

            // Add the row to table
            Object[] row = new Object[] {
                selectedMedicineId,
                medicineName,
                quantity,
                medicinePrice,
                totalPrice
            };
            tableModel.addRow(row);

            // Clear quantity and total price fields for next entry
            quantityField.setText("");
            totalPriceField.setText("");
            medicineComboBox.setSelectedIndex(0);
            selectedMedicineId = "";
            medicinePrice = 0;

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid quantity format", "Error", JOptionPane.ERROR_MESSAGE);
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
                    return;
                }
            }
            totalPriceField.setText("");
        } catch (NumberFormatException ex) {
            totalPriceField.setText("");
        }
    }


    private void addOrder() {
        String customerName = customerNameField.getText().trim();

        if (customerName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter customer name", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int rowCount = tableModel.getRowCount();
        if (rowCount == 0) {
            JOptionPane.showMessageDialog(this, "Please add at least one medicine to the order", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Insert into orders table first
            String insertOrderSql = "INSERT INTO orders (customer_name, order_date) VALUES (?, CURRENT_DATE)";
            boolean orderSuccess = db.executeQuery(insertOrderSql, customerName);

            if (!orderSuccess) {
                JOptionPane.showMessageDialog(this, "Failed to add order", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Get the generated order_id
            String getOrderIdSql = "SELECT LAST_INSERT_ID() as order_id";
            ResultSet orderRs = db.getData(getOrderIdSql);
            if (!orderRs.next()) {
                JOptionPane.showMessageDialog(this, "Failed to get order ID", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int orderId = orderRs.getInt("order_id");

            // For each row, insert into order_items and update stock
            for (int i = 0; i < rowCount; i++) {
                String medicineId = (String) tableModel.getValueAt(i, 0);
                int quantity = (int) tableModel.getValueAt(i, 2);
                double totalPrice = (double) tableModel.getValueAt(i, 4);

                // Check stock availability
                String checkStockSql = "SELECT quantity_in_stock FROM medicines WHERE medicine_id = " + Integer.parseInt(medicineId);
                ResultSet rsStock = db.getData(checkStockSql);
                if (rsStock.next()) {
                    int stockAvailable = rsStock.getInt("quantity_in_stock");
                    if (quantity > stockAvailable) {
                        JOptionPane.showMessageDialog(this, 
                            "Not enough stock for medicine ID " + medicineId + ". Only " + stockAvailable + " left.", 
                            "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Medicine ID " + medicineId + " not found", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Insert into order_items
                String insertOrderItemSql = "INSERT INTO order_items (order_id, medicine_id, quantity, total_price) VALUES (?, ?, ?, ?)";
                boolean itemSuccess = db.executeQuery(insertOrderItemSql, orderId, Integer.parseInt(medicineId), quantity, totalPrice);

                if (!itemSuccess) {
                    JOptionPane.showMessageDialog(this, "Failed to add order item for medicine ID " + medicineId, "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Update stock
                String updateStockSql = "UPDATE medicines SET quantity_in_stock = quantity_in_stock - ? WHERE medicine_id = ?";
                boolean updateSuccess = db.executeQuery(updateStockSql, quantity, Integer.parseInt(medicineId));

                if (!updateSuccess) {
                    JOptionPane.showMessageDialog(this, "Failed to update stock for medicine ID " + medicineId, "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            JOptionPane.showMessageDialog(this, "Order added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

            // Clear all fields and table
            customerNameField.setText("");
            quantityField.setText("");
            totalPriceField.setText("");
            medicineComboBox.setSelectedIndex(0);
            selectedMedicineId = "";
            medicinePrice = 0;
            tableModel.setRowCount(0);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid data format: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void clearFields() {
        customerNameField.setText("");
        quantityField.setText("");
        totalPriceField.setText("");
        medicineComboBox.setSelectedIndex(0);
        selectedMedicineId = "";
        medicinePrice = 0;
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
        jLabel5 = new javax.swing.JLabel();
        totalPriceField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        medicineComboBox = new javax.swing.JComboBox<>();
        quantityField = new javax.swing.JTextField();

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
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 150, 20));

        customerNameField.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        customerNameField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(customerNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 150, 30));

        jLabel5.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Total Price");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 140, 20));

        totalPriceField.setEditable(false);
        totalPriceField.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        totalPriceField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(totalPriceField, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 150, 40));

        addButton.setBackground(new java.awt.Color(255, 102, 102));
        addButton.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        addButton.setText("Add Order");
        jPanel1.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, 140, 40));

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(orderTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 370, 140));

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setText("Add Medicine");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 150, 30));

        medicineComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(medicineComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 150, 30));
        jPanel1.add(quantityField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 150, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> medicineComboBox;
    private javax.swing.JTable orderTable;
    private javax.swing.JTextField quantityField;
    private javax.swing.JTextField totalPriceField;
    // End of variables declaration//GEN-END:variables
}
