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
import projectContant.Forum;

/**
 * Servlet implementation class EnterForumServlet
 */
@WebServlet(description = "servlet that dispaches a connection request into a forum page", urlPatterns = { "/EnterForumServlet" })
public class EnterForumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnterForumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String forumName = request.getParameter("Forums");
		
		ServletContext servletContext = request.getServletContext();
		DataBase db = (DataBase)servletContext.getAttribute("DataBase");
		
		Forum f = null;
		for (int i = 0; i < db.getForums().size(); i++)
			if (db.getForums().get(i).getName().equals(forumName))
				f = db.getForums().get(i);
		
		request.getSession().setAttribute("forumname", forumName);
		response.sendRedirect("/WebTest1/Forum.jsp");
		//out.println("You have chose the forum " + forumName);
		
	}

}
