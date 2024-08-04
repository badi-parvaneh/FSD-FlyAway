package helper;


import org.hibernate.Session;
import org.hibernate.Transaction;


import core.Admin;

public class adminHelper {

	public void adminSignUp(Admin admin) {
		Transaction tx = null;

		Session session = hibernateHelper.getSession().openSession();
		if (session != null) {
			try {
				tx = session.beginTransaction();
				session.save(admin);
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	//Show admin Details
	public Admin getAdmin(int user_id) {

		Transaction tx = null;
		Admin admin = null;
		Session session = hibernateHelper.getSession().openSession();
		
		if (session != null) {
			try {
				tx = session.beginTransaction();
				admin = session.get(Admin.class, user_id);
				tx.commit();

			} catch (Exception e) {
				if (tx != null) {
					tx.rollback();
				}
				e.printStackTrace();
			}
		}
		return admin;
	}

	// helper to authenticate admins
	@SuppressWarnings("deprecation")
	public boolean authenticate (String uName, String password) {
		Transaction tx = null;
		Admin admin = null;
		Session session = hibernateHelper.getSession().openSession();
		if (session != null) {
			try {
				tx = session.beginTransaction();
				System.out.println(uName);
				System.out.println(password);
				admin = (Admin) session.createQuery("FROM Admin a where a.uName = :uName").setParameter("uName", uName).uniqueResult();
				System.out.println(admin);
				if (admin.getPassword().equals(password) && admin != null) {
					return true;
				}
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;

	}

	//for updating existing admin information
	public void updateAdmin(Admin admin) {
		Transaction tx = null;
		Session session = hibernateHelper.getSession().openSession();
		if (session != null) {
			try {
				tx = session.beginTransaction();
				session.update(admin);
				tx.commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
