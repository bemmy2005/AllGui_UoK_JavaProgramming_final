package allthethingsforgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDataExample {
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String host = "jdbc:mysql://localhost/bithuye";
        String user = "root";
        String password = "";

        // SQL query to insert data
        String sql = "INSERT INTO student (fname, lname, email,telephone,gender) VALUES (?, ?, ?, ?, ?)";

        try (
            // Establish the connection
            Connection connection = DriverManager.getConnection(host, user, password);

            // Create a prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            // Set the values for the prepared statement
            preparedStatement.setString(1, "FirstName");
            preparedStatement.setString(2, "LastName");
            preparedStatement.setString(3, "Email");
            preparedStatement.setString(4, "Telephone");
            preparedStatement.setString(5, "Gender");

            // Execute the query
            int rowsAffected = preparedStatement.executeUpdate();

            // Check the result
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
            } else {
                System.out.println("Failed to insert data.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

