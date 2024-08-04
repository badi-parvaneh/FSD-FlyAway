package helper;

import org.hibernate.Session;
import org.hibernate.Transaction;

import core.Passenger;


public class passengerHelper {
	
	// add Passenger Details
	public void addPassenger(Passenger passenger) {
		Transaction tx = null;
		Session session = hibernateHelper.getSession().openSession();
		if (session != null) {
			try {
				tx = session.beginTransaction();
				session.save(passenger);
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			}
		}
	}

	// Display Passenger Details
	public Passenger getPassenger(int passenger_id) {

		Transaction tx = null;
		Passenger passenger = null;
		Session session = hibernateHelper.getSession().openSession();
		
		if (session != null) {
			try {
				tx = session.beginTransaction();
				passenger = session.get(Passenger.class, passenger_id);
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			}
		}
		
		return passenger;
	}
	
	//get passenger details by email
	@SuppressWarnings("deprecation")
	public Passenger getPassengerByEmail(String email) {
		Transaction tx = null;
		Passenger passenger = null;
		Session session = hibernateHelper.getSession().openSession();
		
		if (session != null) {
			try {
				tx = session.beginTransaction();
				passenger = (Passenger) session.createQuery("FROM Passenger p where p.email = :email").setParameter("email", email).uniqueResult();
				tx.commit();
			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			}
		}
		
		return passenger;
	}
}
