/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quiz.app;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/testdb"; // Change to your database URL
    private static final String USERNAME = "shaheel"; // Change to your database username
    private static final String PASSWORD = "shaheel"; 
    
    private static Connection connection;
    public static Connection getConnected()
    {
        try{
             if(connection==null)
        {
         Class.forName("com.mysql.cj.jdbc.Driver");
        connection= DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
         System.out.print("connected to the database");
        }
        }
        catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
            
        }
       
        return connection;
    }
     public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
                // Handle closing connection errors
            }
        }
    }

    
}
