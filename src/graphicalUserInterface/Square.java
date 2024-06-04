package graphicalUserInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Square extends TwoDShapes{
	private double side;

	public Square(double side) {
		this.side = side;
	}
	

	public double getSide() {
		return side;
	}


	public void setSide(double side) {
		this.side = side;
	}


	@Override
	public void calculateArea() {
		double area = side * side;
		setArea(area);
	}

	@Override
	public void calculatePerimeter() {
		double perimeter = 4 * side;
		setPerimeter(perimeter);
	}
	public void insertDataIntoDatabase() {

		// JDBC URL, username, and password of MySQL server
		String host = "jdbc:mysql://localhost/2d_shape";
		String user = "root";
		String password = "";

		// SQL query to insert data
		String sql = "INSERT INTO square (side, area, perimeter) VALUES (?, ?, ?)";

		try (
				// Establish the connection
				Connection con = DriverManager.getConnection(host, user, password);

				// Create a prepared statement
				PreparedStatement stm= con.prepareStatement(sql);
				) {
			// Set the values for the prepared statement
			stm.setInt(1, (int) this.side);
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
