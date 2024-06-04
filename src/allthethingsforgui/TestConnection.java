package allthethingsforgui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestConnection {

	public static void main(String[] args) {
		Connection con=null;
		PreparedStatement stm=null;
		ResultSet rs=null;
		String sql="SELECT * FROM student ";
		String host="jdbc:mysql://localhost/bithuye";
		String user="root";
		String pass="";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			con=DriverManager.getConnection(host,user,pass);
			stm=con.prepareStatement(sql);
			rs=stm.executeQuery();
			while(rs.next()) {
				//int id =rs.getInt(0);
				String id =rs.getString("id");
				String fn=rs.getString("fname");
				String ln=rs.getString("lname");
				String em=rs.getString("email");
				String tel=rs.getString("telephone");
				String gen=rs.getString("gender");
				
				System.out.println(id+"\t"+fn+"\t"+ln+"\t"+em+"\t"+tel+"\t"+gen);
			}
		}catch (ClassNotFoundException e) {
			System.out.println("An error occurred while loading the JDBC driver");
		} catch (SQLException e) {
			System.out.println("There was an error accessing the database.");
		}finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("There was an error accessing the database.");
			}
		}
		
	}

}
