package it.unirc.pwm.eureca.viaggio.dao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.unirc.pwm.eureca.hibernate.util.HibernateUtil;

public class ViaggioDAOImplement implements ViaggioDAOInterface{
	
	private static Logger logger = LogManager.getLogger(ViaggioDAOImplement.class); 
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;

	public ViaggioDAOImplement() {
		super();
	
	}
}
