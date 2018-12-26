package server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class add_information_server extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add_information_server() {
        super();
        // TODO Auto-generated constructor stub
    }
 
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("add_information_server init!");
	}
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}
 
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String user_name = "";
		String label = "";
		String title = "";
		String info = "";
		String priority="";
		
		user_name = request.getParameter("username").trim();
		label = request.getParameter("label").trim();
		title = request.getParameter("title").trim();
		info = request.getParameter("info").trim();
		priority = request.getParameter("priority").trim();
		
		out.println(add_information.add_information(user_name,label,title,info,priority));
	}
 
}
