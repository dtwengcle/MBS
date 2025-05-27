
package medicine_bs;

import config.Session;
import config.connectDB;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicInternalFrameUI;


public class profile extends javax.swing.JInternalFrame {

    /**
     * Creates new form profile
     */
    public profile() {
        initComponents();
        loadProfileData();
        
          //remove border
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }
    
    private void loadProfileData() {
        config.Session session = config.Session.getInstance();
        if (session != null) {
            nameField.setText(session.getName());
            usernameField.setText(session.getUsername());
            emailField.setText(session.getEmail());
            genderField.setText(session.getGender());
            roleField.setText(session.getRole());
        }
    }
    
    public String destination = "";
    File selectedFile;
    public String oldpath;
    public String path;
    
    public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/images", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }
    
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
    
    public ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
        ImageIcon MyImage;

        if (ImagePath != null) {
            MyImage = new ImageIcon(ImagePath);
        } else {
            MyImage = new ImageIcon(pic);
        }

        Image img = MyImage.getImage();

        int width = label.getWidth() > 0 ? label.getWidth() : 100; // fallback width
        int originalWidth = MyImage.getIconWidth();
        int originalHeight = MyImage.getIconHeight();

        int newHeight = (int) ((double) width / originalWidth * originalHeight);

        Image newImg = img.getScaledInstance(width, newHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(newImg);
    }


        private void loadProfilePicture(String userId) {
            try (Connection con = new connectDB().getConnection();
                 PreparedStatement pst = con.prepareStatement("SELECT profile_pic FROM user WHERE user_id = ?")) {

                pst.setString(1, userId);
                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        String fileName = rs.getString("profile_pic");
                        if (fileName != null && !fileName.isEmpty()) {
                            // Construct full image path
                            String imagePath = "src/userImages/" + fileName;

                            // Resize and set the image using your method
                            ImageIcon resizedIcon = ResizeImage(imagePath, null, profile);
                            profile.setIcon(resizedIcon);
                        } else {
                            profile.setIcon(null); // or default
                        }
                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error loading profile picture: " + e.getMessage());
            }
        }
        
        public void showLargeMessage(Component parent, String message, String title, int messageType) {
    JTextArea textArea = new JTextArea(message);
    textArea.setFont(new Font("Arial", Font.PLAIN, 16)); // Larger font
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    textArea.setEditable(false);
    textArea.setBackground(null);
    textArea.setBorder(null);

    JScrollPane scrollPane = new JScrollPane(textArea);
    scrollPane.setPreferredSize(new Dimension(400, 200)); // Set custom size

    JOptionPane optionPane = new JOptionPane(scrollPane, messageType);
    JDialog dialog = optionPane.createDialog(parent, title);
    dialog.setModal(true);
    dialog.setResizable(true); // Allow resizing if needed
    dialog.setVisible(true);
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernameField = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nameField = new javax.swing.JLabel();
        emailField = new javax.swing.JLabel();
        roleField = new javax.swing.JLabel();
        genderField = new javax.swing.JLabel();
        profile = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(640, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MY PROFILE");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 150, -1));

        jLabel2.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Role:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, -1, -1));

        usernameField.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        usernameField.setForeground(new java.awt.Color(51, 51, 51));
        usernameField.setText("None");
        jPanel1.add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, -1, 20));

        jLabel4.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Usename:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, -1, 20));

        jLabel5.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Email:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, -1, -1));

        jLabel6.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Gender");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 360, -1, 20));

        jLabel7.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Name:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));

        nameField.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        nameField.setForeground(new java.awt.Color(51, 51, 51));
        nameField.setText("None");
        jPanel1.add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, -1, -1));

        emailField.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        emailField.setForeground(new java.awt.Color(51, 51, 51));
        emailField.setText("None");
        jPanel1.add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 240, -1, -1));

        roleField.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        roleField.setForeground(new java.awt.Color(51, 51, 51));
        roleField.setText("None");
        jPanel1.add(roleField, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, -1, -1));

        genderField.setFont(new java.awt.Font("Calibri Light", 1, 24)); // NOI18N
        genderField.setForeground(new java.awt.Color(51, 51, 51));
        genderField.setText("None");
        jPanel1.add(genderField, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, -1, 20));

        profile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/profile6.png"))); // NOI18N
        jPanel1.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 100));

        jLabel8.setFont(new java.awt.Font("Calibri Light", 1, 14)); // NOI18N
        jLabel8.setText("SELECT IMAGES");
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, -1, -1));

        jButton1.setText("Upload");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 500, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
         JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            try {
                selectedFile = fileChooser.getSelectedFile();
                destination = "src/userImages/" + selectedFile.getName();
                path  = selectedFile.getAbsolutePath();


                if(FileExistenceChecker(path) == 1){
                  JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                    destination = "";
                    path="";
                }else{
                    profile.setIcon(ResizeImage(path, null, profile));
                }
            } catch (Exception ex) {
                System.out.println("File Error!");
            }
        }
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         if (selectedFile == null) {
            JOptionPane.showMessageDialog(null, "No file selected. Please choose a file first.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(
            null,
            "Do you want to change your profile picture?",
            "Change Profile Picture",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            String fileName = selectedFile.getName();
            File destFile = new File("src/userImages/" + fileName);

            // Get old profile picture filename from database
            connectDB cn = new connectDB();
            Connection con = cn.getConnection();
            Session UserSession = Session.getInstance();

            String selectSql = "SELECT profile_pic FROM users WHERE id = ?";
            PreparedStatement selectPst = con.prepareStatement(selectSql);
            selectPst.setInt(1, UserSession.getId());

            String oldFileName = null;
            try (ResultSet rs = selectPst.executeQuery()) {
                if (rs.next()) {
                    oldFileName = rs.getString("profile_pic");
                }
            }
            selectPst.close();

            // Delete old file if it exists and is different from new file
            if (oldFileName != null && !oldFileName.isEmpty() && !oldFileName.equals(fileName)) {
                File oldFile = new File("src/userImages/" + oldFileName);
                if (oldFile.exists()) {
                    boolean deleted = oldFile.delete();
                    if (!deleted) {
                        System.out.println("Warning: Could not delete old profile picture: " + oldFileName);
                    }
                }
            }

            // Copy new file, overwriting if it exists
            Files.copy(selectedFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            // Update database with new filename
            String updateSql = "UPDATE users SET profile_pic = ? WHERE id = ?";
            PreparedStatement updatePst = con.prepareStatement(updateSql);
            updatePst.setString(1, fileName);
            updatePst.setInt(2, UserSession.getId());

            int rows = updatePst.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Profile picture updated successfully.");
            } else {
                JOptionPane.showMessageDialog(null, "Failed to update profile picture.");
            }

            updatePst.close();
            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error uploading image: " + e.getMessage());
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel emailField;
    private javax.swing.JLabel genderField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel nameField;
    private javax.swing.JLabel profile;
    private javax.swing.JLabel roleField;
    private javax.swing.JLabel usernameField;
    // End of variables declaration//GEN-END:variables
}
