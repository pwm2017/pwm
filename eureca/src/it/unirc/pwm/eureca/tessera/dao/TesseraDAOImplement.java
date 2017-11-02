package it.unirc.pwm.eureca.tessera.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.unirc.pwm.eureca.hibernate.util.HibernateUtil;

public class TesseraDAOImplement implements TesseraDAOInterface
{
	
	private static Logger logger = LogManager.getLogger(TesseraDAOImplement.class); 
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;

	public TesseraDAOImplement() {
		super();
	
	}

	
}
