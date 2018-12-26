package server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class login 
{
	public static String login(String user_name,String user_password) 
	{
		String response = "";
		
		try {
			String url="jdbc:mysql://127.0.0.1:3306/android?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=false";
			String user="root"; 
			String password="123456";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection(url,user,password);
			Statement st=conn.createStatement();
			PreparedStatement pst=conn.prepareStatement("select * from android_login where username=? and password=?");
			
			pst.setString(1, user_name);
			pst.setString(2, user_password);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				pst=conn.prepareStatement("select * from android_login where username=?");
				pst.setString(1, user_name);
				rs=pst.executeQuery();
				
				//int img_id = rs.getInt("picture");
				int img_id = 0;
				
				pst=conn.prepareStatement("select DISTINCT label,priority from android_label where username=?");
				pst.setString(1, user_name);
				rs=pst.executeQuery();
				
				String label = "";
				String priority = "";
				if(!rs.next()) {
					label = "-1000";
					priority = "-1000";
				}
				else {
					label = rs.getString("label")+"&";
					priority = rs.getString("priority")+"&";
				}
				while(rs.next()) {
					label+=rs.getString("label")+"&";
					priority+=rs.getString("priority")+"&";
				}
				
				pst=conn.prepareStatement("select * from android_title where username=?");
				pst.setString(1, user_name);
				rs=pst.executeQuery();
				
				String label2="";
				String priority2 = "";
				String title = "";
				String information = "";
				
				if(!rs.next()) {
					label2 = "-1000";
					priority2 = "-1000";
					title = "-1000";
					information = "-1000";
				}
				else {
					label2 = rs.getString("label")+"&";
					priority2 = rs.getString("priority")+"&";
					title = rs.getString("title")+"&";
					information = rs.getString("information")+"&";
				}
				while(rs.next()) {
					label2+=rs.getString("label")+"&";
					priority2+=rs.getString("priority")+"&";
					title+=rs.getString("title")+"&";
					information+=rs.getString("information")+"&";
				}
				
				response = user_name+"%"+img_id+"%"+label+"%"+priority+"%"+label2+"%"+priority2+"%"+title+"%"+information+"%"+"succeed";
			}
			
			else {
				response = "not_exist";
			}
			
			System.out.println(response); 
		}catch(SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return response;
	}
 
}