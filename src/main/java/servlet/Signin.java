package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import dao.User;
import dao.UserDao;

/**
 * Servlet implementation class Signin
 */
@WebServlet("/signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/black362")
    private DataSource ds;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try (UserDao userDao = new UserDao(ds)) {
			String dateString = request.getParameter("date2");
			LocalDate birthDate = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
			
			User user = new User(request.getParameter("firstName"), request.getParameter("lastName"), birthDate, request.getParameter("email"), request.getParameter("telephone"), request.getParameter("username"), request.getParameter("password"), request.getParameter("city"), request.getParameter("address"), Integer.parseInt(request.getParameter("cap")));
			
			userDao.save(user);
			
			request.setAttribute("user", user);
			
			RequestDispatcher rd = request.getRequestDispatcher("/result.jsp");
	        rd.forward(request, response);
		}		
	}
}
