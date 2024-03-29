/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quiz.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;


/**
 *
 * @author o
 */
public class Adduser extends javax.swing.JFrame {
   // Change to your database password

    /**
     * Creates new form Adduser
     */
      Startscreen stscreen;
    private Connection connection;
    public Adduser(Startscreen s) {
        this.stscreen=s;
        initComponents();
        this.connection=DatabaseManager.getConnected();
    }
 
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        regnumber = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Adduser = new javax.swing.JButton();
        Cancelbtn = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        Role = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Enter reg number");

        regnumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regnumberActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Enter your name");

        Adduser.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Adduser.setText("Add User");
        Adduser.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        Adduser.setFocusPainted(false);
        Adduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdduserActionPerformed(evt);
            }
        });

        Cancelbtn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Cancelbtn.setText("Cancel");
        Cancelbtn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        Cancelbtn.setFocusPainted(false);
        Cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelbtnActionPerformed(evt);
            }
        });

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        Role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Teacher", "Student" }));
        Role.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RoleActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Select Role");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(regnumber, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Adduser, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(Cancelbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(regnumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Role, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Adduser)
                    .addComponent(Cancelbtn))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void regnumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regnumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regnumberActionPerformed

    private void AdduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdduserActionPerformed
        String regNumberText = regnumber.getText().trim(); // Get text from regnumber field
        String nameText = name.getText().trim(); // Get text from name field
        String selectedRole = (String) Role.getSelectedItem();
        
        if (regNumberText.isEmpty() || nameText.isEmpty()) {
            // Display a dialog box if any of the fields are empty
            JOptionPane.showMessageDialog(this, "Please enter values in all text fields.", "Incomplete Information", JOptionPane.WARNING_MESSAGE);
        } else {
            if(validateInput(regNumberText,nameText))
            {
              try {
                String query;
                
                if (selectedRole.equals("Student")) {
                    query = "INSERT INTO students (id, name,Role) VALUES (?, ?,?)";
                } else {
                    query = "INSERT INTO teacher (Tid, name,Role) VALUES (?, ?,?)";
                }

                PreparedStatement preparedStatement = connection.prepareStatement(query);
                // setting the parameters of teh query
                preparedStatement.setString(1, regNumberText);
                preparedStatement.setString(2, nameText);
                preparedStatement.setString(3, selectedRole);
                
                int rowsInserted = preparedStatement.executeUpdate();
                if (rowsInserted > 0) {
                    JOptionPane.showMessageDialog(this, "Data inserted successfully into the database.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to insert data into the database.", "Insertion Error", JOptionPane.ERROR_MESSAGE);
                }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Failed to insert data into the database.", "Database Error", JOptionPane.ERROR_MESSAGE);
        }
                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Enter reg-no in format 21-Arid-777 and name as 'john doe' ");
            }

        }

    }//GEN-LAST:event_AdduserActionPerformed

    private void CancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelbtnActionPerformed
        this.setVisible(false);
//        DatabaseManager.closeConnection();
        stscreen.setVisible(true);

    }//GEN-LAST:event_CancelbtnActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void RoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RoleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RoleActionPerformed

    /**
     * @param args the command line arguments
     */
    private boolean validateInput(String regno,String name)
    {
        return regno.matches("[0-9][0-9]-(Arid|ARID)-[0-9][0-9][0-9]") &&
                name.matches("[a-zA-Z]+\\s+[a-zA-Z]+");
    }
    
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Adduser;
    private javax.swing.JButton Cancelbtn;
    private javax.swing.JComboBox<String> Role;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField name;
    private javax.swing.JTextField regnumber;
    // End of variables declaration//GEN-END:variables
}
