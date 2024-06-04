package graphicalUserInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Circle extends TwoDShapes{

	private double radius;

	// Constructor
	public Circle(double radius) {
		this.radius = radius;
	}

	// Getter and setter for radius
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	// Implement abstract methods
	@Override
	public void calculateArea() {
		double area = Math.PI * radius * radius;
		setArea(area);
	}
	

	@Override
	public void calculatePerimeter() {
		double perimeter = 2 * Math.PI * radius;
		setPerimeter(perimeter);
	}

	public void insertDataIntoDatabase() {

		// JDBC URL, username, and password of MySQL server
		String host = "jdbc:mysql://localhost/2d_shape";
		String user = "root";
		String password = "";

		// SQL query to insert data
		String sql = "INSERT INTO circle (radius, area, perimeter) VALUES (?, ?, ?)";

		try (
				// Establish the connection
				Connection con = DriverManager.getConnection(host, user, password);

				// Create a prepared statement
				PreparedStatement stm= con.prepareStatement(sql);
				) {
			// Set the values for the prepared statement
			stm.setInt(1, (int) this.radius);
			stm.setInt(2, (int) this.getArea());
			stm.setInt(3, (int) this.getPerimeter());


			// Execute the query
			int rowsAffected = stm.executeUpdate();

			// Check the result
			if (rowsAffected > 0) {
				System.out.println("Data inserted successfully!");
				JOptionPane.showMessageDialog(null, "Data inserted successfully!","After insert",JOptionPane.INFORMATION_MESSAGE);
			} else {
				System.out.println("Failed to insert data.");
				JOptionPane.showMessageDialog(null, "Failed to insert data.!","After insert",JOptionPane.ERROR_MESSAGE);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}	

	}
}
