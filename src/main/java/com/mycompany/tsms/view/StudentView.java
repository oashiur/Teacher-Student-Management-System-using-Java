package com.mycompany.tsms.view;

import com.mycompany.tsms.DbCon;
import com.mycompany.tsms.model.Student;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class StudentView extends javax.swing.JFrame {
    
    DbCon db = new DbCon();
    String filename = null;
    byte[] photo;

    public StudentView(byte[] photo, JButton btnClear, JButton btnDelete, JButton btnSave, JButton btnUpdate, JLabel imageLabel, JPanel jPanel1, JScrollPane jScrollPane1, JLabel labelCell, JLabel labelEmail, JLabel labelHeader, JLabel labelId, JLabel labelName, JTable studentTable, JTextField txtCell, JTextField txtEmail, JLabel txtId, JTextField txtName) throws HeadlessException {
        this.photo = photo;
        this.btnClear = btnClear;
        this.btnDelete = btnDelete;
        this.btnSave = btnSave;
        this.btnUpdate = btnUpdate;
        this.imageLabel = imageLabel;
        this.jPanel1 = jPanel1;
        this.jScrollPane1 = jScrollPane1;
        this.labelCell = labelCell;
        this.labelEmail = labelEmail;
        this.labelHeader = labelHeader;
        this.labelId = labelId;
        this.labelName = labelName;
        this.studentTable = studentTable;
        this.txtCell = txtCell;
        this.txtEmail = txtEmail;
        this.txtId = txtId;
        this.txtName = txtName;
    }
    
    public StudentView() throws ClassNotFoundException {
        initComponents();
        TableDataRetrive();
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }
    
    private void Clear(){
        txtId.setText("");
        txtName.setText("");
        txtEmail.setText("");
        txtCell.setText("");
        imageLabel.setIcon(null);
        photo = null;
        imageLabel.setText("Choose a Photo");
        btnSave.setEnabled(true);
        btnUpdate.setEnabled(false);
        btnDelete.setEnabled(false);
    }
    
    private void Refresh() throws ClassNotFoundException{
        DefaultTableModel dtm = (DefaultTableModel) studentTable.getModel();
        dtm.setRowCount(0);
        TableDataRetrive();
    }
    
    //model class
    public ArrayList<Student> sList() throws ClassNotFoundException {

        ArrayList<Student> sList = new ArrayList<>();

        String sqlRetrive = "SELECT * from studentinfo";
        try {
            PreparedStatement pst = db.getCon().prepareStatement(sqlRetrive);
            ResultSet rs = pst.executeQuery();
            Student s;
            while (rs.next()) {
                s = new Student(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("cell"), rs.getBytes("image"));
                sList.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sList;
    }
    
    private void TableDataRetrive() throws ClassNotFoundException {
        ArrayList<Student> list = sList();
        DefaultTableModel dtm = (DefaultTableModel) studentTable.getModel();
        Object[] row = new Object[5];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getId();
            row[1] = list.get(i).getName();
            row[2] = list.get(i).getEmail();
            row[3] = list.get(i).getCell();
            row[4] = list.get(i).getImage();
            dtm.addRow(row);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelHeader = new javax.swing.JLabel();
        teacherPanel = new javax.swing.JLabel();
        labelId = new javax.swing.JLabel();
        labelName = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelCell = new javax.swing.JLabel();
        txtCell = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtId = new javax.swing.JLabel();
        imageLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        btnSave = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        labelHeader.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        labelHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelHeader.setText("Student Panel");

        teacherPanel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        teacherPanel.setForeground(new java.awt.Color(0, 0, 255));
        teacherPanel.setText("Teacher Panel");
        teacherPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        teacherPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teacherPanelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 642, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(teacherPanel)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(teacherPanel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(labelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        labelId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelId.setText("Id:");

        labelName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelName.setText("Name:");

        labelEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelEmail.setText("Email:");

        labelCell.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelCell.setText("Cell:");

        txtCell.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtEmail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtName.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtId.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtId.setForeground(new java.awt.Color(230, 0, 0));
        txtId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        imageLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        imageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imageLabel.setText("Choose a Photo (Max 64 Kb)");
        imageLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imageLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                imageLabelMouseEntered(evt);
            }
        });

        studentTable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Email", "Cell", "Image"
            }
        ));
        studentTable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        studentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(studentTable);

        btnSave.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSave.setText("Save");
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        btnUpdate.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });

        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnClearMouseClicked(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(240, 0, 0));
        btnExit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setText("EXIT");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(labelCell)
                                .addComponent(labelEmail)
                                .addComponent(labelName)
                                .addComponent(labelId))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtCell, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                                .addComponent(txtEmail)
                                .addComponent(txtName)
                                .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelId)
                            .addComponent(txtId))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelName)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelEmail)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(labelCell))
                            .addComponent(txtCell, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseClicked
        // TODO add your handling code here:
        Clear();
    }//GEN-LAST:event_btnClearMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        // TODO add your handling code here:
        String sqlSave = "INSERT INTO studentinfo (name, email, cell, image) VALUES (?,?,?,?)";
        try {
            PreparedStatement psSave = db.getCon().prepareStatement(sqlSave);
            
            if(!txtName.getText().trim().isEmpty() && !txtEmail.getText().trim().isEmpty() && !txtCell.getText().trim().isEmpty() && photo != null){
                psSave.setString(1, txtName.getText().trim());
                psSave.setString(2, txtEmail.getText().trim());
                psSave.setString(3, txtCell.getText().trim());
                psSave.setBytes(4, photo);
                
                psSave.executeUpdate();
                btnSave.setEnabled(false);
                Refresh();
                JOptionPane.showMessageDialog(null, "Information has been Successfully Saved!");
                Clear();
            }
            else{
                JOptionPane.showMessageDialog(null, "Fill the all Information!");
            }            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(StudentView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSaveMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        // TODO add your handling code here:
        String sqlUpdate = "UPDATE studentinfo SET name = ?, email = ?, cell = ?, image = ? WHERE id = ?";        
        try {            
            PreparedStatement psUpdate = db.getCon().prepareStatement(sqlUpdate);
            psUpdate.setString(1, txtName.getText().trim());
            psUpdate.setString(2, txtEmail.getText().trim());
            psUpdate.setString(3, txtCell.getText().trim());
            psUpdate.setBytes(4, photo);
            psUpdate.setInt(5,Integer.parseInt( txtId.getText()));
            psUpdate.executeUpdate();
            Refresh();
            JOptionPane.showMessageDialog(null, "Information Updated Successfully");
            Clear();
        }
        catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);            
            Logger.getLogger(StudentView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUpdateMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:
        String sqlDelete = "DELETE FROM studentinfo WHERE id=?";
        try {
            PreparedStatement psDelete = db.getCon().prepareStatement(sqlDelete);
            psDelete.setInt(1, Integer.parseInt(txtId.getText())); // Integer.parseInt(txtId.getText())
            psDelete.executeUpdate();
            Refresh();
            JOptionPane.showMessageDialog(null, "Information has been Deleted");
            Clear();
        }
        catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex);            
            Logger.getLogger(StudentView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void imageLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageLabelMouseClicked
        // TODO add your handling code here:
        photo = null;
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showSaveDialog(getParent());
        if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = fileChooser.getSelectedFile();
            imageLabel.setIcon(new ImageIcon(selectedFile.toString()));
            imageLabel.setText("");
            filename = selectedFile.getAbsolutePath();
        }
        try {
            File images = new File(filename);
            FileInputStream fis = new FileInputStream(images);

            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
            }
            photo = bos.toByteArray();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_imageLabelMouseClicked

    private void imageLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageLabelMouseEntered
        // TODO add your handling code here:
        Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
        imageLabel.setCursor(cursor);
    }//GEN-LAST:event_imageLabelMouseEntered

    private void studentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentTableMouseClicked
        // TODO add your handling code here:
        int i = studentTable.getSelectedRow();
        TableModel model = studentTable.getModel();
        txtId.setText(model.getValueAt(i, 0).toString());
        txtName.setText(model.getValueAt(i, 1).toString());
        txtEmail.setText(model.getValueAt(i, 2).toString());
        txtCell.setText(model.getValueAt(i, 3).toString());
        
        photo = (byte[]) model.getValueAt(i, 4);
        ImageIcon format = new ImageIcon(photo);
        imageLabel.setIcon(format);
        
        btnSave.setEnabled(false);
        btnUpdate.setEnabled(true);
        btnDelete.setEnabled(true);
    }//GEN-LAST:event_studentTableMouseClicked

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnExitMouseClicked

    private void teacherPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherPanelMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        try {
            new TeacherView().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_teacherPanelMouseClicked

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new StudentView().setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(StudentView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCell;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelHeader;
    private javax.swing.JLabel labelId;
    private javax.swing.JLabel labelName;
    private javax.swing.JTable studentTable;
    private javax.swing.JLabel teacherPanel;
    private javax.swing.JTextField txtCell;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
