/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quiz.app;

/**
 *
 * @author o
 */
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
public class Studentdashboard extends javax.swing.JFrame {


    String id;
    private final Connection connection=DatabaseManager.getConnected();;
    public Studentdashboard(String id) {
        this.id=id;
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

        bavaliable_quiz = new javax.swing.JButton();
        battempted_quiz = new javax.swing.JButton();
        tquizid = new javax.swing.JTextField();
        battempted_quiz1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bavaliable_quiz.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bavaliable_quiz.setText("Avaliable Quizes");
        bavaliable_quiz.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        bavaliable_quiz.setFocusPainted(false);
        bavaliable_quiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bavaliable_quizActionPerformed(evt);
            }
        });

        battempted_quiz.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        battempted_quiz.setText("Attempted Quizes");
        battempted_quiz.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        battempted_quiz.setFocusPainted(false);
        battempted_quiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                battempted_quizActionPerformed(evt);
            }
        });

        tquizid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tquizidActionPerformed(evt);
            }
        });

        battempted_quiz1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        battempted_quiz1.setText("Start Quiz");
        battempted_quiz1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        battempted_quiz1.setFocusPainted(false);
        battempted_quiz1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                battempted_quiz1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter Quiz Id");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(battempted_quiz, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bavaliable_quiz, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tquizid, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(battempted_quiz1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(bavaliable_quiz)
                .addGap(18, 18, 18)
                .addComponent(battempted_quiz)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tquizid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(battempted_quiz1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bavaliable_quizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bavaliable_quizActionPerformed

        showAvailableQuizzesPopup();
        
    }//GEN-LAST:event_bavaliable_quizActionPerformed

    private void battempted_quizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_battempted_quizActionPerformed
        Studentattemptedquiz s1=new Studentattemptedquiz(this.id,this);
        this.setVisible(false);
        s1.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_battempted_quizActionPerformed

    private void battempted_quiz1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_battempted_quiz1ActionPerformed
        int quizid=Integer.parseInt(tquizid.getText().trim());
//        if(!quizid)
//        {
//            
//            
//        }
        StudentQuizPortal s1=new StudentQuizPortal(this.id,quizid,this);
        this.setVisible(false);
        s1.setVisible(true);
        
        // TODO add your handling code here:
    }//GEN-LAST:event_battempted_quiz1ActionPerformed

    private void tquizidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tquizidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tquizidActionPerformed




private void showAvailableQuizzesPopup() {
        

        List<String> availableQuizzes = new ArrayList<>();

        try {
     
            Statement statement = connection.createStatement();

            // Fetch quizzes not attempted by the student
          ResultSet resultSet = statement.executeQuery("SELECT Quizid, Quizname FROM quiz " +
                    "WHERE Quizid NOT IN (SELECT quizid FROM attemptedquiz WHERE studentid = '" + id + "')");

            while (resultSet.next()) {
                int quizId = resultSet.getInt("Quizid");
                String quizName = resultSet.getString("Quizname");
                availableQuizzes.add("Quiz ID: " + quizId + ", Quiz Name: " + quizName);
            }

            // Close resources
            resultSet.close();
            statement.close();
         

        } catch (Exception e) {
            e.printStackTrace();
        }

        // Display a popup dialog with available quizzes
        JOptionPane.showMessageDialog(this, String.join("\n", availableQuizzes),
                "Available Quizzes", JOptionPane.INFORMATION_MESSAGE);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton battempted_quiz;
    private javax.swing.JButton battempted_quiz1;
    private javax.swing.JButton bavaliable_quiz;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField tquizid;
    // End of variables declaration//GEN-END:variables
}
