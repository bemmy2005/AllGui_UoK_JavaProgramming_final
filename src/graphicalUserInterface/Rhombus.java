package graphicalUserInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Rhombus extends TwoDShapes{
	private double diagonal1;
    private double diagonal2;
    private double side;

    public double getDiagonal1() {
		return diagonal1;
	}

	public void setDiagonal1(double diagonal1) {
		this.diagonal1 = diagonal1;
	}

	public double getDiagonal2() {
		return diagonal2;
	}

	public void setDiagonal2(double diagonal2) {
		this.diagonal2 = diagonal2;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public Rhombus(double diagonal1, double diagonal2, double side) {
        this.diagonal1 = diagonal1;
        this.diagonal2 = diagonal2;
        this.side = side;
    }

    @Override
    public void calculateArea() {
        double area = 0.5 * diagonal1 * diagonal2;
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
		String sql = "INSERT INTO rhombus (diagonal1,diagonal1,side, area, perimeter) VALUES (?, ?, ?,?,?)";

		try (
				// Establish the connection
				Connection con = DriverManager.getConnection(host, user, password);

				// Create a prepared statement
				PreparedStatement stm= con.prepareStatement(sql);
				) {
			// Set the values for the prepared statement
			stm.setInt(1, (int) this.diagonal1);
			stm.setInt(2, (int) this.diagonal2);
			stm.setInt(3, (int) this.side);
			stm.setInt(4, (int) this.getArea());
			stm.setInt(5, (int) this.getPerimeter());


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
