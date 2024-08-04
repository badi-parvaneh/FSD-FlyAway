package helper;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import java.util.Properties;


import core.Admin;
import core.Flight;
import core.Passenger;
import core.Ticket;

public class hibernateHelper {

	private static SessionFactory sFactory;
	public static SessionFactory getSession() {

		if (sFactory == null) {
			try {
				Configuration config = new Configuration();

				Properties props = new Properties();
				props.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
				props.put(Environment.USER, "root");
				props.put(Environment.PASS, "adminroot");
				props.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
				props.put(Environment.URL, "jdbc:mysql://127.0.0.1:3306/flyawayDB");
				props.put(Environment.SHOW_SQL, "true");
				props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				props.put(Environment.HBM2DDL_AUTO, "update");

				config.setProperties(props);
				config.addAnnotatedClass(Admin.class);
				config.addAnnotatedClass(Flight.class);
				config.addAnnotatedClass(Passenger.class);
				config.addAnnotatedClass(Ticket.class);

				ServiceRegistry sRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
				sFactory = config.buildSessionFactory(sRegistry);
				return sFactory;

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return sFactory;

	}

}
