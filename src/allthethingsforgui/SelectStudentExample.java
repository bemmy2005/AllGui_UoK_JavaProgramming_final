package allthethingsforgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectStudentExample {
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost/bithuye";
        String user = "root";
        String password = "";

        // SQL query to select all columns from student where id = ?
        String sql = "SELECT * FROM student WHERE id = ?";

        try (
            // Establish the connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // Create a prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            // Set the value for the parameterized query
            int studentId = 1; // Replace with the desired student id
            preparedStatement.setInt(1, studentId);

            // Execute the query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String fname = resultSet.getString("fname");
                String lname = resultSet.getString("lname");
                String email = resultSet.getString("email");
                String telephone = resultSet.getString("telephone");
                String gender = resultSet.getString("gender");

                // Print or use the retrieved data
                System.out.println("Student ID: " + id);
                System.out.println("First Name: " + fname);
                System.out.println("Last Name: " + lname);
                System.out.println("Email: " + email);
                System.out.println("Telephone: " + telephone);
                System.out.println("Gender: " + gender);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

