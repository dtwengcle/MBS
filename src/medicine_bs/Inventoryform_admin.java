/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicine_bs;

import config.connectDB;
import inventory.AddMedicine;
import inventory.EditMedicine;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author admin
 */
public class Inventoryform_admin extends javax.swing.JInternalFrame {

    private connectDB db;
    private DefaultTableModel tableModel;
    
    
    
    public Inventoryform_admin() {
    initComponents();
    db = new connectDB();
    tableModel = new DefaultTableModel(
        new Object[][]{},
        new String[]{"Order ID", "Item Name", "Quantity", "Price", "Expiration Date", "Expiring Soon?"}
    ) {
        final boolean[] canEdit = new boolean[]{
            false, true, true, true, false, false
        };

        @Override
        public boolean isCellEditable(int row, int column) {
            return canEdit[column];
        }
    };
    inventoryTable.setModel(tableModel);
    loadMedicineData(); // Make sure you call it here
}

    private void loadMedicineData() {
    try {
        tableModel.setRowCount(0);
        String sql = "SELECT * FROM medicines";
        ResultSet rs = db.getData(sql);

        java.util.Date today = new java.util.Date();
        java.util.Calendar cal = java.util.Calendar.getInstance();

        while (rs.next()) {
            java.sql.Date expirationDate = rs.getDate("expiration_date");
            String expiration = (expirationDate != null) ? expirationDate.toString() : "N/A";

            // Compute if expiring within 1 year
            String expiringSoon = "N/A";
            if (expirationDate != null) {
                cal.setTime(today);
                cal.add(java.util.Calendar.YEAR, 1);
                java.util.Date oneYearFromNow = cal.getTime();

                expiringSoon = expirationDate.before(oneYearFromNow) ? "Yes" : "No";
            }

            Object[] row = {
                rs.getInt("medicine_id"),
                rs.getString("name"),
                rs.getInt("quantity_in_stock"),
                rs.getDouble("price"),
                expiration,
                expiringSoon
            };
            tableModel.addRow(row);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error loading data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }



}

    private void searchMedicine(String searchText) {
        try {
            // Clear existing data
            tableModel.setRowCount(0);
            
            // Search in database
            String sql = "SELECT * FROM medicines WHERE name LIKE '%" + searchText + "%' OR description LIKE '%" + searchText + "%'";
            ResultSet rs = db.getData(sql);
            
            // Add matching data to table
            while (rs.next()) {
                Object[] row = {
                    rs.getInt("medicine_id"),
                    rs.getString("name"),
                    rs.getInt("quantity_in_stock"),
                    rs.getDouble("price"),
                    rs.getDate("expiration_date") != null ? rs.getDate("expiration_date").toString() : "N/A"
                };

                tableModel.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error searching data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteSelectedMedicine() {
    int selectedRow = inventoryTable.getSelectedRow();
    if (selectedRow == -1) {
        JOptionPane.showMessageDialog(this, "Please select a medicine to delete", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int medicineId = (int) inventoryTable.getValueAt(selectedRow, 0);
    String medicineName = (String) inventoryTable.getValueAt(selectedRow, 1);

    int confirm = JOptionPane.showConfirmDialog(this,
        "Are you sure you want to delete " + medicineName + "?",
        "Confirm Delete",
        JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        try {
            String sql = "DELETE FROM medicines WHERE medicine_id = ?";
            boolean success = connectDB.executeUpdate(sql, medicineId); // updated here
            if (success) {
                JOptionPane.showMessageDialog(this, "Medicine deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                loadMedicineData(); // Refresh table
            } else {
                JOptionPane.showMessageDialog(this, "Failed to delete medicine", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error deleting medicine: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        inventoryTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        searchIcon = new javax.swing.JLabel();
        addMedicineButton = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        editMedicineButton = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        deleteMedicineButton = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        refreshButton = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(849, 549));

        jPanel1.setBackground(new java.awt.Color(255, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inventoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Order ID", "Item Name", "Quantity", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(inventoryTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 600, 320));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel1.setText("INVENTORY");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 150, -1));

        searchField.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        searchField.setForeground(new java.awt.Color(153, 153, 153));
        searchField.setText(" search...");
        searchField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        searchField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                searchFieldFocusLost(evt);
            }
        });
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });
        jPanel1.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 170, 25));

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchIcon.setText("🔍");
        jPanel2.add(searchIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 20, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 25, 25));

        addMedicineButton.setBackground(new java.awt.Color(255, 102, 102));
        addMedicineButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMedicineButtonMouseClicked(evt);
            }
        });
        addMedicineButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Add Medicine");
        addMedicineButton.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 6, -1, 20));

        jPanel1.add(addMedicineButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 120, 30));

        editMedicineButton.setBackground(new java.awt.Color(255, 102, 102));
        editMedicineButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editMedicineButtonMouseClicked(evt);
            }
        });
        editMedicineButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Edit Medicine");
        editMedicineButton.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, 30));

        jPanel1.add(editMedicineButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 440, 130, 30));

        deleteMedicineButton.setBackground(new java.awt.Color(255, 102, 102));
        deleteMedicineButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMedicineButtonMouseClicked(evt);
            }
        });
        deleteMedicineButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Delete Medicine");
        deleteMedicineButton.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 30));

        jPanel1.add(deleteMedicineButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 440, 130, 30));

        refreshButton.setBackground(new java.awt.Color(255, 102, 102));
        refreshButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshButtonMouseClicked(evt);
            }
        });
        refreshButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Refresh");
        refreshButton.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, -4, -1, 40));

        jPanel1.add(refreshButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 440, 100, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusGained
        if (searchField.getText().equals(" search...")) {
            searchField.setText("");
            searchField.setForeground(new java.awt.Color(0, 0, 0));
        }
    }//GEN-LAST:event_searchFieldFocusGained

    private void searchFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchFieldFocusLost
        if (searchField.getText().isEmpty()) {
            searchField.setForeground(new java.awt.Color(99, 99, 99));
            searchField.setText(" search...");
            loadMedicineData(); // Reload all data when search is cleared
        }
    }//GEN-LAST:event_searchFieldFocusLost

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        String searchText = searchField.getText().trim();
        if (!searchText.equals(" search...") && !searchText.isEmpty()) {
            searchMedicine(searchText);
        }
    }//GEN-LAST:event_searchFieldActionPerformed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        String searchText = searchField.getText().trim();
        if (!searchText.equals(" search...") && !searchText.isEmpty()) {
            searchMedicine(searchText);
        }
    }//GEN-LAST:event_searchFieldKeyReleased

    private void addMedicineButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMedicineButtonMouseClicked
        AddMedicine addForm = new AddMedicine();
        addForm.setVisible(true);
        // Wait for the form to close before refreshing
        addForm.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                loadMedicineData();
            }
        });
    }//GEN-LAST:event_addMedicineButtonMouseClicked

    private void editMedicineButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editMedicineButtonMouseClicked
        int selectedRow = inventoryTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a medicine to edit", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int medicineId = (int) inventoryTable.getValueAt(selectedRow, 0);
        EditMedicine editForm = new EditMedicine();
        editForm.loadMedicineData(medicineId);
        editForm.setVisible(true);
        // Wait for the form to close before refreshing
        editForm.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                loadMedicineData();
            }
        });
    }//GEN-LAST:event_editMedicineButtonMouseClicked

    private void deleteMedicineButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMedicineButtonMouseClicked
        deleteSelectedMedicine();
    }//GEN-LAST:event_deleteMedicineButtonMouseClicked

    private void refreshButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshButtonMouseClicked
        loadMedicineData();
    }//GEN-LAST:event_refreshButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel addMedicineButton;
    private javax.swing.JPanel deleteMedicineButton;
    private javax.swing.JPanel editMedicineButton;
    private javax.swing.JTable inventoryTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel refreshButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JLabel searchIcon;
    // End of variables declaration//GEN-END:variables
}
