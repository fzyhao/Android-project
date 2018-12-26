package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
public class register 
{
	private static String user_type = "user";
	
	public static String register(String user_name,String user_password)
	{
		String response = "";
		try {
			String url="jdbc:mysql://127.0.0.1:3306/android?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
			String user="root"; 
			String password="123456";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url,user,password);
			Statement st=conn.createStatement();  
			PreparedStatement pst=conn.prepareStatement("select * from android_login where username =?");
			
			pst.setString(1, user_name);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				response = "exist";
			}
			
			else 
			{
				String s="insert into android_login(username,password) values("+"?,?)";
				pst=conn.prepareStatement(s);
				pst.setString(1, user_name);
				pst.setString(2, user_password);
				pst.execute(); 
				response = user_name+"%"+"succeed";
			}
			
			System.out.println(response);  
			rs.close();
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