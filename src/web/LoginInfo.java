package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginInfo() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("name");
		String pass = request.getParameter("password");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		RequestDispatcher rd = null;
		request.setAttribute(id, "name");

		if (id.equals("name") && pass.equals("pass")) {
			rd = request.getRequestDispatcher("/WelcomeServlet");
			rd.forward(request, response);
		}

		else {
			out.println("<b>Invalid Login Info.</b><br>");
			rd = request.getRequestDispatcher("/LoginInfo.jsp");
			rd.include(request, response);
		}
		out.close();
	}

}
