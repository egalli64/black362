package servlet;

import java.io.IOException;


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
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name = "jdbc/black362")
    private DataSource ds;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//username e password
		
		try (UserDao userDao = new UserDao(ds)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			if (userDao.usernameExists(username)) {
				if (userDao.passwordCheck(username, password)) {
					User user = userDao.getByUsername(username);
					request.setAttribute("message", "Bentornato " + username);
				} else {
					request.setAttribute("message", "La password inserita non è corretta");
				}
			} else {
				request.setAttribute("message", "Utente non trovato.");
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/loginResult.jsp");
	        rd.forward(request, response);
		}
	}

}
