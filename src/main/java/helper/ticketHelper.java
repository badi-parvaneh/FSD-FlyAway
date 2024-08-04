package helper;

import org.hibernate.Session;
import org.hibernate.Transaction;

import core.Ticket;


public class ticketHelper {
	
	
	//add Ticket
	public int addTicket(Ticket ticket) {
		Transaction tx = null;
		Session session = hibernateHelper.getSession().openSession();
		int ticket_id = 0;
		if (session != null) {
			try {
				tx = session.beginTransaction();
				session.save(ticket);
				tx.commit();

			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			}
		}
		return ticket_id;
		
	}
}