package server;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class exchange_information_server extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public exchange_information_server() {
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
		String first_title = "";
		String second_title = "";
		String first_priority = "";
		String second_priority = "";
		
		user_name = request.getParameter("username").trim();
		label = request.getParameter("label").trim();
		first_title = request.getParameter("first_title").trim();
		second_title = request.getParameter("second_title").trim();
		first_priority = request.getParameter("first_priority").trim();
		second_priority = request.getParameter("second_priority").trim();
		
		out.println(exchange_information.exchange_information(user_name, label,first_title,	second_title,first_priority,second_priority));
		
	}
 
}


