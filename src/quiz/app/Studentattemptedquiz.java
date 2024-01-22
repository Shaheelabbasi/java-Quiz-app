/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quiz.app;

import java.sql.ResultSet;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.Statement;
import java.sql.Connection;

/**
 *
 * @author o
 */
public class Studentattemptedquiz extends javax.swing.JFrame {

    private JTable table;
    private DefaultTableModel model;
    String id;
    private final Connection connection=DatabaseManager.getConnected();
    private Studentdashboard dashboard;
    public Studentattemptedquiz(String id,Studentdashboard dashboard) {
        initComponents();
        initTable();
        this.dashboard=dashboard;
        this.id=id;
        model.addColumn("Quiz ID");
        model.addColumn("Quiz Name");
        model.addColumn("Obtained Marks");
        model.addColumn("Total Marks");
         populateTable();
//        System.out.println("st id="+id);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bback.setText("Back");
        bback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(308, Short.MAX_VALUE)
                .addComponent(bback)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(235, Short.MAX_VALUE)
                .addComponent(bback)
                .addGap(42, 42, 42))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbackActionPerformed
        this.dashboard.setVisible(true);
        this.dispose();
            
        // TODO add your handling code here:
    }//GEN-LAST:event_bbackActionPerformed

        private void initTable() {
        model = new DefaultTableModel();
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
        pack();
    }
         private void populateTable() {
        // Replace the database connection details with your actual information
      
        try {
//            Connection connection = DriverManager.getConnection(connection);
            Statement statement = connection.createStatement();

            // Fetch data from the database
          ResultSet resultSet = statement.executeQuery("SELECT quiz.Quizid, quiz.Quizname, attemptedquiz.obtainedmarks,attemptedquiz.totalmarks " +
                    "FROM quiz JOIN attemptedquiz ON quiz.Quizid = attemptedquiz.quizid " +
                    "WHERE attemptedquiz.studentid = '" + this.id + "'");

            
            // Add column headers to the table


            // Add data to the table
            while (resultSet.next()) {
                Object[] row = {
                        resultSet.getInt("Quizid"),
                        resultSet.getString("Quizname"),
                        resultSet.getInt("obtainedmarks"),
                         resultSet.getInt("totalmarks")
                };
                model.addRow(row);
                System.out.println("reslt="+resultSet.getString("Quizname"));
            }

            // Close resources
            resultSet.close();
            statement.close();
           

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bback;
    // End of variables declaration//GEN-END:variables
}
