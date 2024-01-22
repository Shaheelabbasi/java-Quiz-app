/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package quiz.app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.JOptionPane;

/**
 *
 * @author o
 */
public class StudentQuizPortal extends javax.swing.JFrame {

    /**
     * Creates new form StudentQuizPortal
     */
    String studentid;
    int quizid;
    private final Connection connection=DatabaseManager.getConnected();
    private Studentdashboard dashboard;
    private int questionindex=0;
    private List<Question> questions;

    public StudentQuizPortal(String studentid, int quizid,Studentdashboard dashboard) {
        initComponents();
        this.quizid=quizid;
        this.studentid=studentid;
        this.dashboard=dashboard;
        this.questions = this.getAllQuestionsAndOptions(quizid);
//        for (Question question : questions) {
//            System.out.println("Question Text: " + question.questionText);
//            System.out.println("Options: " + question.options);
//            System.out.println("Correct Option: " + question.correctOption);
//            System.out.println();
//        }
        questions.size();
        System.out.println(this.buttonGroup1.getSelection());
        this.setQuestionAndOptions(this.questions.get(questionindex));
    }
    private class Question {
        String questionText;
        String options;
        String correctOption;
        String selectedQuestion;

        public Question(String questionText, String options, String correctOption) {
            this.questionText = questionText;
            this.options = options;
            this.correctOption = correctOption;
            this.selectedQuestion=null;
        }
        public boolean isCorrect() {
        return correctOption.equals(selectedQuestion);
        //question 
    }

        public int calculateMarks() {
            if (isCorrect()) {
                return 5; // If the selected option is correct, return 5 marks
            } else {
                return 0; // If the selected option is incorrect, return 0 marks
            }
        }
    }
    private List<Question> getAllQuestionsAndOptions(int quizid) {
        List<Question> questions = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();

            // Fetch data from the database
            ResultSet resultSet = statement.executeQuery("SELECT questionText, options, correctoption FROM questions " +
                    "WHERE quizid = " + quizid);

            while (resultSet.next()) {
                String questionText = resultSet.getString("questionText");
                String options = resultSet.getString("options");
                String correctOption = resultSet.getString("correctoption");

                // Create a new Question object and add it to the list
                Question question = new Question(questionText, options, correctOption);
                questions.add(question);
            }

            resultSet.close();
            statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return questions;
    }
    
public void insertAttemptedQuiz(int quizId, String studentId, int obtainedNumber, int totalmarks) {
    try {
        // Assuming "attemptedquiz" has columns: quizid, studentid, obtainednumber, totalmarks
        String query = "INSERT INTO attemptedquiz (quizid, studentid, obtainedmarks, totalmarks) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) //automatic resource closure
        {
            preparedStatement.setInt(1, quizId);
            preparedStatement.setString(2, studentId);
            preparedStatement.setInt(3, obtainedNumber);
            preparedStatement.setInt(4, totalmarks);

            int rowsAffected = preparedStatement.executeUpdate();//running query
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
            } else {
                System.out.println("Failed to insert data.");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
    // chat gpt vala
    
//    public void insertAttemptedQuiz(int quizId, String studentId, int obtainedNumber, int totalmarks) {
//    try {
//        // Check if the quiz has already been attempted by the student
//        String checkQuery = "SELECT * FROM attemptedquiz WHERE quizid = ? AND studentid = ?";
//        try (PreparedStatement checkStatement = connection.prepareStatement(checkQuery)) {
//            checkStatement.setInt(1, quizId);
//            checkStatement.setString(2, studentId);
//
//            try (ResultSet resultSet = checkStatement.executeQuery()) {
//                if (resultSet.next()) {
//                    // The quiz has already been attempted by the student
//                    System.out.println("This quiz has already been attempted by the student. Cannot attempt again.");
//                      JOptionPane.showMessageDialog(this,"this quiz is already attempted");
//                    return; // Exit the method without attempting to insert a new record
//                }
//            }
//        }
//
//        // If the code reaches here, it means the quiz has not been attempted, proceed with the insertion
//        String insertQuery = "INSERT INTO attemptedquiz (quizid, studentid, obtainedmarks, totalmarks) VALUES (?, ?, ?, ?)";
//        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
//            preparedStatement.setInt(1, quizId);
//            preparedStatement.setString(2, studentId);
//            preparedStatement.setInt(3, obtainedNumber);
//            preparedStatement.setInt(4, totalmarks);
//
//            int rowsAffected = preparedStatement.executeUpdate();
//            if (rowsAffected > 0) {
//                System.out.println("Data inserted successfully!");
//            } else {
//                System.out.println("Failed to insert data.");
//            }
//        }
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//}
//ended here
//     private void GetAllQuestionsAndOptions() {
//        try {
////            Connection connection = DriverManager.getConnection(connection);
//            Statement statement = connection.createStatement();
//
//            // Fetch data from the database
//          ResultSet resultSet = statement.executeQuery("SELECT questionText, options, correctoption FROM questions " +
//                           "WHERE quizid = "+quizid);
//            resultSet.close();
//            statement.close();
//           
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
     private void setQuestionAndOptions(Question q) {
    // Set the question text
    
    question.setText(q.questionText);
    String[] options = q.options.strip().split(","); // remove leading and traling white spaces.
    // Set the options text and action command for each option
    o1.setText(options[0]);// text set on ui
    o1.setActionCommand(options[0]);// function of radio button seting a string which wil be returned on get
    // action command.

    o2.setText(options[1]);
    o2.setActionCommand(options[1]);

    o3.setText(options[2]);
    o3.setActionCommand(options[2]);

    o4.setText(options[3]);
    o4.setActionCommand(options[3]);
    if (q.selectedQuestion==null)
    {
        this.buttonGroup1.clearSelection();
        // after one question atempted
    }
    else
    {
        String correctOption = q.selectedQuestion;
        
       

    // Find the radio button with the correct option and set it as selected
    Enumeration<AbstractButton> buttons = buttonGroup1.getElements();// due to return type of this  function
    while (buttons.hasMoreElements()) {
        
        AbstractButton button = buttons.nextElement();//just icrement
        if (button.getActionCommand().equals(correctOption)) {
            button.setSelected(true);
            break;
        }
    }
    }
}
     public int calculateTotalMarks() {
        return questions.size() * 5; // Each question is worth 5 marks
    }

    public int calculateObtainedMarks() {
        int obtainedMarks = 0;

        for (Question question : questions) {
            obtainedMarks += question.calculateMarks();
        }

        return obtainedMarks;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lquizheading = new javax.swing.JLabel();
        o1 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        question = new javax.swing.JTextArea();
        o2 = new javax.swing.JRadioButton();
        o3 = new javax.swing.JRadioButton();
        o4 = new javax.swing.JRadioButton();
        bnext = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        bback = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(o1);
        o1.setText("o1");
        o1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                o1ActionPerformed(evt);
            }
        });

        question.setEditable(false);
        question.setColumns(20);
        question.setLineWrap(true);
        question.setRows(5);
        jScrollPane1.setViewportView(question);

        buttonGroup1.add(o2);
        o2.setText("o2");
        o2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                o2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(o3);
        o3.setText("o3");
        o3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                o3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(o4);
        o4.setText("o4");
        o4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                o4ActionPerformed(evt);
            }
        });

        bnext.setText("next");
        bnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnextActionPerformed(evt);
            }
        });

        jButton3.setText("cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        bback.setText("back");
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lquizheading, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(o4)
                    .addComponent(o3)
                    .addComponent(o2)
                    .addComponent(o1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(bback)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bnext))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lquizheading, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(o1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(o2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(o3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(o4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bnext)
                    .addComponent(bback))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void o2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_o2ActionPerformed
        Question q=this.questions.get(this.questionindex); //get method of list 
//        q.selectedQuestion=this.buttonGroup1.getSelection().getActionCommand();
        q.selectedQuestion=o2.getText();
        this.questions.set(this.questionindex, q);        // TODO add your handling code here:
    }//GEN-LAST:event_o2ActionPerformed

    private void o3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_o3ActionPerformed
        Question q=this.questions.get(this.questionindex);
//        q.selectedQuestion=this.buttonGroup1.getSelection().getActionCommand();
 q.selectedQuestion=o3.getText();
        this.questions.set(this.questionindex, q);        // TODO add your handling code here:
    }//GEN-LAST:event_o3ActionPerformed

    private void bnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnextActionPerformed
        
        
        if (this.buttonGroup1.getSelection()==null)
        {
         JOptionPane.showMessageDialog(this, "PLEASE SELECT AN OPTION FIRST ");
        }
        else
        {
            if (this.questions.size()==this.questionindex+1)
            {
                System.out.println("Quiz Completed");
//            for (Question question : questions) {
//            System.out.println("Question Text: " + question.questionText);
//            System.out.println("Options: " + question.options);
//            System.out.println("Correct Option: " + question.correctOption);
//            System.out.println("selectedQuestion "+question.selectedQuestion);
//            
//            
//        }
            insertAttemptedQuiz(this.quizid, this.studentid, calculateObtainedMarks(), calculateTotalMarks());
            JOptionPane.showMessageDialog(this, "Quiz submitted successfully ");
            this.dispose();
            this.dashboard.setVisible(true);
            }
            else
            {   
                this.questionindex+=1;
                this.setQuestionAndOptions(this.questions.get(questionindex));
                if (this.questions.size()==this.questionindex+1)
                {
                    this.bnext.setText("Submit");
                }
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_bnextActionPerformed

    private void bbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbackActionPerformed

        
            if (this.questionindex==0)
            {
//                System.out.println("no question to back");
                 bback.setEnabled(false);
            }
            else
            {
                bback.setEnabled(true);
                this.questionindex-=1;
                this.setQuestionAndOptions(this.questions.get(questionindex));
                if (this.questions.size()==this.questionindex+1)
                {
                    this.bnext.setText("Submit");
                }
                else
                {
                    this.bnext.setText("Next");
                }
            }
        // TODO add your handling code here:
    }//GEN-LAST:event_bbackActionPerformed

    private void o1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_o1ActionPerformed
        Question q=this.questions.get(this.questionindex);
//        q.selectedQuestion=this.buttonGroup1.getSelection().getActionCommand();
 q.selectedQuestion=o1.getText();
        this.questions.set(this.questionindex, q);
        // TODO add your handling code here:
    }//GEN-LAST:event_o1ActionPerformed

    private void o4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_o4ActionPerformed
        Question q=this.questions.get(this.questionindex);
//        q.selectedQuestion=this.buttonGroup1.getSelection().getActionCommand();
 q.selectedQuestion=o4.getText();
        this.questions.set(this.questionindex, q);        // TODO add your handling code here:
    }//GEN-LAST:event_o4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        
        this.setVisible(false);
        dashboard.setVisible(true);
        
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bback;
    private javax.swing.JButton bnext;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lquizheading;
    private javax.swing.JRadioButton o1;
    private javax.swing.JRadioButton o2;
    private javax.swing.JRadioButton o3;
    private javax.swing.JRadioButton o4;
    private javax.swing.JTextArea question;
    // End of variables declaration//GEN-END:variables
}
