package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class delete_label {
private static String user_type = "user";
	
	public static String delete_label(String user_name,String label) {
		String response = "";
		try {
			String url="jdbc:mysql://127.0.0.1:3306/android?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
			String user="root"; 
			String password="123456";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url,user,password);
			Statement st=conn.createStatement();  
			PreparedStatement pst=conn.prepareStatement("delete from android_label where username =? and label =?");
			
			pst.setString(1, user_name);
			pst.setString(2, label);
			System.out.println(user_name);
			System.out.println(label);
			pst.execute();
			
			pst=conn.prepareStatement("delete from android_title where username =? and label =?");
			pst.setString(1, user_name);
			pst.setString(2, label);
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
