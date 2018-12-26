package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class edit_information {
private static String user_type = "user";
	
	public static String edit_information(String user_name,String label,String title,String change_title, String change_info) {
		String response = "";
		try {
			String url="jdbc:mysql://127.0.0.1:3306/android?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
			String user="root"; 
			String password="123456";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url,user,password);
			Statement st=conn.createStatement();  
			PreparedStatement pst=conn.prepareStatement("update android_title set title = ?, information = ? where username =? and label =? and title =?");
			 
			pst.setString(1, change_title);
			pst.setString(2, change_info);
			pst.setString(3, user_name);
			pst.setString(4, label);
			pst.setString(5, title);
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
