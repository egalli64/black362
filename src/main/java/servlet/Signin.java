package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.User;
import dao.UserDao;

/**
 * Servlet implementation class Signin
 */
@WebServlet("/signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dateString = request.getParameter("date2");
		LocalDate birtDate = LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
//		User user = new User(request.getParameter("inputname"), request.getParameter("inputlastname"), request.getParameter("date2"), request.getParameter("inputEmail4"), request.getParameter("inputnumber"), request.getParameter("inputusername"), request.getParameter("inputPassword4"), request.getParameter("inputCity"), request.getParameter("inputAddress"), request.getParameter("inputZip"));
//		UserDao userDao = new UserDao();
//		userDao.save(user);
	}

}
