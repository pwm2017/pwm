package it.unirc.pwm.eureca.evento.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.unirc.pwm.eureca.hibernate.util.HibernateUtil;
 
public class EventoDAOImplement implements EventoDAOInterface{
	
	private static Logger logger = LogManager.getLogger(EventoDAOImplement.class); 
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;

	public EventoDAOImplement() {
		super();
	
	}
	
}
