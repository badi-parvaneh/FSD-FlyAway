package helper;


import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Date;
import java.util.List;

import core.Flight;

public class flightHelper {

	//List all available flights
	@SuppressWarnings("unchecked")
	public List<Flight> getFlights() {
		Transaction tx = null;
		List<Flight> flightList = null;
		
		Session session = hibernateHelper.getSession().openSession();
		if (session != null) {
			try {
				tx = session.beginTransaction();
				flightList = session.createQuery("FROM Flight").getResultList();
				tx.commit();
				
			} catch (Exception e ) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			}
		}
		return flightList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Flight> searchFlights(String src, String dst, Date date, int num_passenger) {
		Transaction tx = null;
		List<Flight> flightList = null;
		
		Session session = hibernateHelper.getSession().openSession();
		if (session != null) {
			try {
				tx = session.beginTransaction();
				flightList = session.createQuery("FROM Flight f WHERE f.source_airport = :src AND f.destination = :dst"
						+ " AND DATE(f.departure_time) LIKE :date AND f.seats_available >= :num_passenger")
						.setParameter("src", src)
						.setParameter("dst", dst)
						.setParameter("date", date)
						.setParameter("num_passenger", num_passenger)
						.getResultList();
				tx.commit();
			} catch (Exception e ) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			}
		}
		return flightList;
	}
		
	//show flight details
	public Flight getFlight(int flight_id) {

		Transaction tx = null;
		Flight flight = null;
		Session session = hibernateHelper.getSession().openSession();
		
		if (session != null) {
			try {
				tx = session.beginTransaction();
				flight = session.get(Flight.class, flight_id);
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			}
		}
		
		return flight;
	}
	
	//update flight details
	public void updateFlight(Flight flight) {
		Transaction tx = null;
		Session session = hibernateHelper.getSession().openSession();
		if (session != null) {
			try {
				tx = session.beginTransaction();
				session.update(flight);
				tx.commit();

			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			}
		}	
	}

}
