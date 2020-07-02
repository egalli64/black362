package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (UserDao userDao = new UserDao(ds)) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			RequestDispatcher rd = null;
			
			if (userDao.usernameExists(username)) {
				if (userDao.passwordCheck(username, password)) {
					User user = userDao.getByUsername(username);
					
					HttpSession session = request.getSession(true);
					session.setAttribute("user", username);
					
					rd = request.getRequestDispatcher("/ristorante.jsp");
				} else {
					rd = request.getRequestDispatcher("/Login.jsp");
				}
			} else {
				rd = request.getRequestDispatcher("/Login.jsp");
			}
			
			rd.forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
