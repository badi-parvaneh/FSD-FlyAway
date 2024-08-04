package servlets;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import core.Flight;
import helper.flightHelper;


@WebServlet("/flights")
public class flightServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private flightHelper flightHelper;


    public flightServlet() {
        super();

    }

    @Override
	public void init() {
    	flightHelper = new flightHelper();
    }


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String action = request.getParameter("action");
		try {
			switch(action) {
			case "displayCities":
				displayCities(request, response);
				break;
			case "displayFlights":
				displayFlights(request, response);
				break;
			case "displayAirlines":
				displayAirlines(request, response);
				break;
			case "searchFlights":
				searchFlights(request, response);
				break;		
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	//For admins to view the current flights
	private void displayFlights(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Flight> flightList = flightHelper.getFlights();
		request.setAttribute("flightList", flightList);
		RequestDispatcher dp = request.getRequestDispatcher("displayflights.jsp");
		dp.forward(request, response);
	}
	
	//for admins to view the current source and destination cities
	private void displayCities(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Flight> flightList = flightHelper.getFlights();
		request.setAttribute("flightList", flightList);
		RequestDispatcher dp = request.getRequestDispatcher("displaycities.jsp");
		dp.forward(request, response);
	}
	
	//for admins to see the airlines
	private void displayAirlines(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		List<Flight> flightList = flightHelper.getFlights();
		request.setAttribute("flightList", flightList);
		RequestDispatcher dp = request.getRequestDispatcher("displayairlines.jsp");
		dp.forward(request, response);
	}
	
	//fetch flights from search results
	private void searchFlights(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException, ParseException {
		
		List<Flight> flightList = null;
		String source_airport = request.getParameter("source_airport");
		String destination = request.getParameter("destination");
		
		//parse the date from HTML
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
		Date departure_time = dateFormat.parse(request.getParameter("departure_time"));
		
		int num_passengers =  Integer.parseInt(request.getParameter("num_passengers"));
		
		flightList = flightHelper.searchFlights(source_airport, destination, departure_time, num_passengers);
		
		RequestDispatcher dp = request.getRequestDispatcher("flightresults.jsp");
		request.setAttribute("flightList", flightList);
		request.setAttribute("num", num_passengers);
		dp.forward(request, response);
	}

}
