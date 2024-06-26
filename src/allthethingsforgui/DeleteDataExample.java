package allthethingsforgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteDataExample {
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost/bithuye";
        String user = "root";
        String password = "";

        // SQL query to delete data
        String sql = "DELETE FROM student WHERE id = ?";

        try (
            // Establish the con
            Connection con = DriverManager.getConnection(url, user, password);

            // Create a prepared statement
            PreparedStatement stm = con.prepareStatement(sql);
        ) {
            // Set the value for the WHERE clause
            stm.setInt(1, 3); // Assuming there is a column named 'id' for the WHERE clause

            // Execute the delete
            int rowsAffected = stm.executeUpdate();

            // Check the result
            if (rowsAffected > 0) {
                System.out.println("Data deleted successfully!");
            } else {
                System.out.println("Failed to delete data. No matching record found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

