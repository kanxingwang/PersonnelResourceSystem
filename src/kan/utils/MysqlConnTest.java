package kan.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlConnTest {
	public String name="com.mysql.jdbc.Driver";
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection connection=DriverManager.getConnection(  "jdbc:mysql://localhost:3306/kan","root","1234");
			Statement stmt=connection.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from people");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			connection.close();  
		} catch (Exception  e) {
			System.out.println(e);
			e.printStackTrace();
		}

	}
	
	

}
