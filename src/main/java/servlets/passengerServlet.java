package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

import core.Passenger;
import helper.passengerHelper;
import core.Flight;
import helper.flightHelper;

@WebServlet("/passenger")
public class passengerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private passengerHelper passengerHelper;

    public passengerServlet() {
        super();
    }
    
    public void init() {
    	passengerHelper = new passengerHelper();
    }


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		try {
			switch(action) {
			case "addPassengerForm":
				addPassengerForm(request, response);
				break;
			case "addPassenger":
				addPassenger(request, response);
				break;		
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	//Display information form for passenger details
	private void addPassengerForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num =request.getParameter("num");
		String flight_id = request.getParameter("flight_id");
		
		RequestDispatcher dp = request.getRequestDispatcher("userinfo.jsp");
		request.setAttribute("flight_id", flight_id);
		request.setAttribute("num", num);

		dp.forward(request, response);
	}
	
	//add a passenger to the database
	private void addPassenger(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
		int flight_id = Integer.parseInt(request.getParameter("flight_id"));
		int num = Integer.parseInt(request.getParameter("num"));

		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");

		//create a new passenger and add to database
		Passenger passenger = new Passenger(fname, lname, email);		
		passengerHelper.addPassenger(passenger); 
		passenger = passengerHelper.getPassengerByEmail(email);
		
		//fetch flight details
		flightHelper flightHelper = new flightHelper();
		Flight flight = flightHelper.getFlight(flight_id);

		
		request.setAttribute("passenger", passenger);
		request.setAttribute("flight", flight);
		request.setAttribute("num", num);
		
		//redirect to purchase page to finalize
		RequestDispatcher dp = request.getRequestDispatcher("purchase.jsp");
		dp.forward(request, response);
	}
}