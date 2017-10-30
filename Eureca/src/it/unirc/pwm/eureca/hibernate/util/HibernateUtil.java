package it.unirc.pwm.eureca.hibernate.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static Logger logger = LogManager.getLogger(HibernateUtil.class);
	private static final SessionFactory sessionFactory = buildSessionFactory();



	private static SessionFactory buildSessionFactory() {
		
		try {
			//Scegliere in base all'esercitazione da svolgere
			
//			SessionFactory sessionFactory = new Configuration().configure("it/unirc/pjam/hibernate/many_to_one/hibernate_many_to_one.cfg.xml").buildSessionFactory();
//			SessionFactory sessionFactory = new Configuration().configure("it/unirc/pjam/hibernate/one_to_many/hibernate_one_to_many.cfg.xml").buildSessionFactory();
			SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//			SessionFactory sessionFactory = new Configuration().configure("it/unirc/pjam/hibernate/one_to_one/hibernate_one_to_one.cfg.xml").buildSessionFactory();
//			SessionFactory sessionFactory = new Configuration().configure("it/unirc/pjam/hibernate/one_to_one_bidir/hibernate_one_to_one_bidir.cfg.xml").buildSessionFactory();
//			SessionFactory sessionFactory = new Configuration().configure("it/unirc/pjam/hibernate/one_to_one_composed/hibernate_one_to_one_composed.cfg.xml").buildSessionFactory();
//			SessionFactory sessionFactory = new Configuration().configure("it/unirc/pjam/hibernate/many_to_many/hibernate_many_to_many.cfg.xml").buildSessionFactory();
//			SessionFactory sessionFactory = new Configuration().configure("it/unirc/pjam/hibernate/chiave_composta/hibernate_chiave_composta.cfg.xml").buildSessionFactory();
//			SessionFactory sessionFactory = new Configuration().configure("it/unirc/pjam/hibernate/ereditarieta/single/hibernate_ereditarieta_single.cfg.xml").buildSessionFactory();
//			SessionFactory sessionFactory = new Configuration().configure("it/unirc/pjam/hibernate/ereditarieta/joined/hibernate_ereditarieta_joined.cfg.xml").buildSessionFactory();
	
			
			return sessionFactory;


		} 
		catch (Throwable ex) {
			logger.error("Creazione del SessionFactory fallita");
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void close() {
		sessionFactory.close();
	}
}