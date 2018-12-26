package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class add_label {
	public static String add_label(String user_name,String label, String priority) 
	{
		String response = "";
		
		try {
			String url="jdbc:mysql://127.0.0.1:3306/android?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
			String user="root"; 
			String password="123456";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url,user,password);
			Statement st=conn.createStatement();
			st.execute("insert into android_label values('"+label+"','"+user_name+"','"+priority+"')");
			
			response = "succeed";
			
			System.out.println(response); 
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return response;
	}
}
