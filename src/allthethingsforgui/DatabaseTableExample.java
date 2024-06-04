//package gui.beginners;
package allthethingsforgui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class DatabaseTableExample extends JFrame {

    private JTable table;

    public DatabaseTableExample() {
        setTitle("Database Table Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);

        // Create a JTable with a DefaultTableModel
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Fetch data from the database and populate the table
        populateTable();

        // Display the JFrame
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void populateTable() {
        String host = "jdbc:mysql://localhost/appmanagement";
        String user = "root";
        String password = "";

        String sql = "SELECT * FROM user"; // replace your_table with the actual table name

        try (Connection connection = DriverManager.getConnection(host, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            // Get column names
            int columnCount = resultSet.getMetaData().getColumnCount();
            Vector<String> columnNames = new Vector<>();
            for (int i = 1; i <= columnCount; i++) {
                columnNames.add(resultSet.getMetaData().getColumnName(i));
            }

            // Get data rows
            Vector<Vector<Object>> data = new Vector<>();
            while (resultSet.next()) {
                Vector<Object> row = new Vector<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(resultSet.getObject(i));
                }
                data.add(row);
            }

            // Create DefaultTableModel and set data
            DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);
            table.setModel(tableModel);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DatabaseTableExample());
    }
}
