package servlets;

import static javax.swing.JOptionPane.showMessageDialog;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;


import core.Admin;
import helper.adminHelper;

@WebServlet("/admin")
public class adminServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private adminHelper adminHelper;

    public adminServlet() {
        super();
    }
    @Override
	public  void init() {
    	adminHelper = new adminHelper();
    }

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");

		try {
			switch(action) {
			case "adminLogin":
				try {
					adminAuth(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case "adminSignUp":
				adminSignUp(request, response);
				break;
			case "adminEdit":
				adminEdit(request, response);
				break;
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	//authenticate admins for login
	private void adminAuth(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String uName = request.getParameter("uName");
		String password = request.getParameter("password");

		boolean authenticated = adminHelper.authenticate(uName, password);

		if (authenticated) {
			RequestDispatcher dp = request.getRequestDispatcher("admindashboard.html");
			dp.forward(request, response);
		} else {
			showMessageDialog(null, "Login unsuccessful, try again!");
		}
	}

	// sign up a new admin
	private void adminSignUp(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String uName = request.getParameter("uName");
		String password = request.getParameter("password");

		Admin admin = new Admin(uName, password);
		try {
			adminHelper.adminSignUp(admin);
			RequestDispatcher dp = request.getRequestDispatcher("admindashboard.html");
			dp.forward(request, response);
		} catch (Exception e) {
			showMessageDialog(null, "Sign up failure, try again!");
			e.printStackTrace();
		}

	}

	//allow admins to update their passwords
	private void adminEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		String uName = request.getParameter("uName");
		String password = request.getParameter("password");
		String newPassword = request.getParameter("newPassword");
		Admin admin = null;

	    if (adminHelper.authenticate(uName, password)) {
	    	 admin = new Admin(uName, newPassword);
	    	 try {
	 			adminHelper.updateAdmin(admin);
	 			RequestDispatcher dp = request.getRequestDispatcher("admindashboard.html");
	 			dp.forward(request, response);
	 		} catch (Exception e) {
	 			showMessageDialog(null, "Password change failed, try again!");
	 			e.printStackTrace();
	 		}
	    } else {
	    	showMessageDialog(null, "Incorrect username or password, try again!");
	    }

	}

}
