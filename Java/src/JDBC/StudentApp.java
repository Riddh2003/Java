package JDBC;

import java.sql.*;

public class StudentApp {

	public static void main(String[] args) throws Exception {
//		insertData(1,"Riddh",20,85);
//		insertData(2,"Pravin",18,90);
//		insertData(3,"Harshal",12,70);
//		insertData(4,"Harsh",23,99);
//		insertData(5,"Devesh",19,98);
//		insertData(6,"Dev",22,65);
//		insertData(7,"Kunjan",21,60);
//		insertData(8,"Dhruv",20,50);
//		insertData(9,"Vaibhav",20,55);
//		
//		updateData(3,"Modi");
		printData();
	}
	public static Connection db() {
		Connection conn = null;
		try {
			String url = "jdbc:mysql://localhost:3306/students";
			String userName = "root";
			String password = "riddhmodi";
			
			conn = DriverManager.getConnection(url,userName,password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	private static void insertData(int id,String name,int age,int score)throws Exception {
		Connection conn = StudentApp.db();
		String insert = "insert into Topperstudent(id,name,age,score) values(?,?,?,?);";
		PreparedStatement st = conn.prepareStatement(insert);
		st.setInt(1,id);
		st.setString(2,name);
		st.setInt(3, age);
		st.setInt(4, score);
		st.executeUpdate();
		st.close();
	}
	private static void updateData(int id,String name) throws Exception{
		Connection conn = StudentApp.db();
		String update = "update Topperstudent set name = ? where id = ?";
		PreparedStatement st = conn.prepareStatement(update);
		st.setInt(1,id);
		st.setString(2,name);
		st.executeUpdate();
		st.close();
	}
	private static void deleteData(int id) throws Exception{
		Connection conn = StudentApp.db();
		String delete = "delete from Topperstudent where id = ?";
		PreparedStatement st = conn.prepareStatement(delete);
		st.setInt(1, id);
		st.executeUpdate();
		st.close();
	}
	private static void printData() throws Exception{
		Connection conn = StudentApp.db();
		String print = "select * from Topperstudent order by score desc limit 5;";
		PreparedStatement st = conn.prepareStatement(print);
		ResultSet rs = st.executeQuery(print);
		System.out.println("<---------Data Of Top 5 Student---------->");
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			int score = rs.getInt("score");
			System.out.println(id +" "+name+" "+age+" "+score);
		}
		st.close();
	}
}
