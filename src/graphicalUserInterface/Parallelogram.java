package graphicalUserInterface;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Parallelogram extends TwoDShapes{
	private double base;
    private double height;
    private double side1;
    private double side2;

    public Parallelogram(double base, double height, double side1, double side2) {
        this.base = base;
        this.height = height;
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public void calculateArea() {
        double area = base * height;
        setArea(area);
    }

    @Override
    public void calculatePerimeter() {
        double perimeter = 2 * (side1 + side2);
        setPerimeter(perimeter);
    }

	public double getBase() {
		return base;
	}

	public void setBase(double base) {
		this.base = base;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}//double base, double height, double side1, double side2
	public void insertDataIntoDatabase() {

		// JDBC URL, username, and password of MySQL server
		String host = "jdbc:mysql://localhost/2d_shape";
		String user = "root";
		String password = "";

		// SQL query to insert data
		String sql = "INSERT INTO parallelogram (base, height,side1,side2, area, perimeter) VALUES (?, ?, ?,?,?,?,?)";

		try (
				// Establish the connection
				Connection con = DriverManager.getConnection(host, user, password);

				// Create a prepared statement
				PreparedStatement stm= con.prepareStatement(sql);
				) {
			// Set the values for the prepared statement
			stm.setInt(1, (int) this.base);
			stm.setInt(2, (int) this.height);
			stm.setInt(3, (int) this.side1);
			stm.setInt(4, (int) this.side2);
			stm.setInt(5, (int) this.getArea());
			stm.setInt(6, (int) this.getPerimeter());


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
