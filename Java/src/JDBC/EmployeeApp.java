package JDBC;

import java.sql.*;

public class EmployeeApp {

	public static void main(String[] args) throws SQLException {
//		insertData(1,"Riddh Modi",80000,20);
//		insertData(2,"Vaibhav S.",25000,45);
//		insertData(3,"Vaibhav M.",20000,42);
//		insertData(4,"Harshal",52000,50);
//		insertData(5,"Harsh",5000,18);
//		insertData(6,"Kunjan",5500,15);
//		insertData(7,"Ikram-ul",15000,23);
//		insertData(8,"Pravin",10000,39);
//		insertData(9,"Dhruv",40000,60);
//		insertData(10,"Devesh",8000,33);
		
		updateData();
		
		printData();
		
//		deleteData(1);
//		deleteData(2);
//		deleteData(3);
//		deleteData(4);
//		deleteData(5);
//		deleteData(6);
//		deleteData(7);
//		deleteData(8);
//		deleteData(9);
//		deleteData(10);
	}
	public static Connection Database() throws SQLException{
		String url = "jdbc:mysql://localhost:3306/employees";
		String userName = "root";
		String password = "riddhmodi";
		Connection conn = DriverManager.getConnection(url,userName,password);
		return conn;		
	}
	public static void insertData(int eid,String ename,int esalary,int eage) throws SQLException {
		Connection conn = EmployeeApp.Database();
		String insert = "insert into employeeApp(eid,ename,esalary,eage) values(?,?,?,?)";
		PreparedStatement st = conn.prepareStatement(insert);
		st.setInt(1, eid);
		st.setString(2, ename);
		st.setInt(3, esalary);
		st.setInt(4, eage);
		st.executeUpdate();
		st.close();
	}
	public static void updateData() throws SQLException {
		Connection conn = EmployeeApp.Database();
		String update = "update employeeApp set esalary=esalary+500  where eage>40";
		PreparedStatement st = conn.prepareStatement(update);
//		st.setInt(3, esalary);
//		st.setInt(4, eage);
		st.executeUpdate();
		st.close();
	}
	public static void deleteData(int eid) throws SQLException {
		Connection conn = EmployeeApp.Database();
		String delete = "delete from employeeApp where eid = ?";
		PreparedStatement st = conn.prepareStatement(delete);
		st.setInt(1, eid);
		st.executeUpdate();
		st.close();
	}
	public static void printData() throws SQLException{
		Connection conn = EmployeeApp.Database();
		String print = "select * from employeeApp  where eage>40";
		PreparedStatement  st = conn.prepareStatement(print);
		ResultSet rs = st.executeQuery(print);
		System.out.println("<--------EmloyeeApp(Salary>20000)--------->");
		while(rs.next()) {			
			int eid = rs.getInt("eid");
			String ename = rs.getString("ename");
			int esalary = rs.getInt("esalary");
			int eage = rs.getInt("eage");
			System.out.println(eid+"\t"+ename+"\t"+esalary+"\t"+eage);
		}
		st.close();
	}
}
