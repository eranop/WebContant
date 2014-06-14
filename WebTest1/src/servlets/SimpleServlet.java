package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projectContant.DataBase;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(
		description = "a simple servlet", 
		urlPatterns = { "/SimpleServlet" }
	)
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("Username");
		out.println("Hello " + username);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("test/html");
		ServletContext servletContext = request.getServletContext();
		DataBase db = (DataBase)servletContext.getAttribute("DataBase");
		PrintWriter out = response.getWriter();
		String username = request.getParameter("Username");
		String password = request.getParameter("Password");
		if (db.isUser(username, password))
		{
			response.sendRedirect("/WebTest1/LoginSuccess.jsp");;
		}
		else
		{
			response.sendRedirect("/WebTest1/MainPage.jsp");
		}
		
	}

}
