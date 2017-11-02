package it.unirc.pwm.eureca.attivita.dao;

import it.unirc.pwm.eureca.attivita.model.Attivita;
import it.unirc.pwm.eureca.hibernate.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Attivit‡DAOImplement implements Attivit‡DAOInterface{

	private static Logger logger = LogManager.getLogger(Attivit‡DAOImplement.class); 
	
	Session session = null;
	Transaction transaction = null;

	public Attivit‡DAOImplement()
	{
		super();
	}
	@Override
	public boolean creaAttivit‡(Attivita a) 
	{
		session = HibernateUtil.getSessionFactory().openSession();
		boolean control=false;
		try {
			transaction=session.beginTransaction();
			session.save(a);
			logger.info("Attivit‡ inserita");
			control=true;
			transaction.commit();
		} catch (Exception e) {
			control=false;
			e.printStackTrace();
			System.out.println("errore dentro il creaAttivit‡");
			transaction.rollback();
		} finally{
			session.close();
		}

		return control;
	}
	
	
	public boolean modificaAttivit‡(Attivita a) 
	{
		boolean result=false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(a);
			result=true;
			logger.info("Attivit‡ modificata");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("errore dentro il modificata attivit‡");
			transaction.rollback();
		}finally{
			session.close();
		}
		return result;
	}
}
