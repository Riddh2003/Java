package JDBC;

import java.io.*;
import java.sql.*;

public class ImageExample {

	public static void main(String[] args) throws SQLException, IOException{
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees","root","riddhmodi");
		
		PreparedStatement st = conn.prepareStatement("insert into image(image) values(?)");
		
		String file = new String("src/Image/img.png");
		String inputStream = new String(file);
		st.setString(1, inputStream);
		st.executeUpdate();
		st.close();
		conn.close();
	}

}
