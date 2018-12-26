package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class important_information {
private static String user_type = "user";
	
	public static String important_information(String user_name,String label,String title,String priority) {
		String response = "";
		try {
			String url="jdbc:mysql://127.0.0.1:3306/android?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
			String user="root"; 
			String password="123456";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url,user,password);
			Statement st=conn.createStatement();  
			PreparedStatement pst=conn.prepareStatement("update android_title set priority = ? where username =? and label =? and title =?");
			 
			pst.setString(1, priority);
			pst.setString(2, user_name);
			pst.setString(3, label);
			pst.setString(4, title);
			pst.execute();
			
			response = "succeed";
			
			System.out.println(response);  
			st.close();
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return response;
	}
}
