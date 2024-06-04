package allthethingsforgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadDataExample {
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/your_database_name";
        String user = "your_username";
        String password = "your_password";

        // SQL query to retrieve data
        String sql = "SELECT column1, column2, column3 FROM your_table_name";

        try (
            // Establish the connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // Create a prepared statement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            // Execute the query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            // Process the result set
            while (resultSet.next()) {
                String column1Value = resultSet.getString("column1");
                int column2Value = resultSet.getInt("column2");
                String column3Value = resultSet.getString("column3");

                System.out.println("Column1: " + column1Value + ", Column2: " + column2Value + ", Column3: " + column3Value);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

