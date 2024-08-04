package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.Ticket;
import core.Flight;
import core.Passenger;
import helper.ticketHelper;
import helper.flightHelper;
import helper.passengerHelper;

@WebServlet("/ticket")
public class ticketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ticketHelper ticketHelper;

    public ticketServlet() {
        super();
    }
    
    public void init() {
    	ticketHelper = new ticketHelper();
    }


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		try {
			switch(action) {
			case "purchaseTicket":
				purchaseTicket(request, response);
				break; 
				} 
			
		} catch (ServletException e) {
			throw new ServletException(e);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	// purchase ticket
	private void purchaseTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flight_id = Integer.parseInt(request.getParameter("flight_id"));	
		int num_passengers = Integer.parseInt(request.getParameter("num"));
		int passenger_id = Integer.parseInt(request.getParameter("user_id"));
		
		//fetch the flight
		flightHelper flightHelper = new flightHelper();
		Flight flight = flightHelper.getFlight(flight_id);
		
		//fetch the passenger
		passengerHelper passengerHelper = new passengerHelper();
		Passenger passenger = passengerHelper.getPassenger(passenger_id);
		
		// update the number of available seats.
		flight.setseats_available(flight.getSeats_available() - num_passengers);
		flightHelper.updateFlight(flight);
		
		
		//generate the ticket
		Ticket ticket = new Ticket(passenger.getFname(), passenger.getLname(), passenger.getUser_id(), flight.getFlight_id(), num_passengers, flight.getPrice(), "Purchased");
		ticketHelper.addTicket(ticket);
		
		//send details to confirmation page
		request.setAttribute("ticket", ticket);
		request.setAttribute("flight", flight);
		RequestDispatcher dp = request.getRequestDispatcher("confirmation.jsp");
		dp.forward(request, response);
	}

}