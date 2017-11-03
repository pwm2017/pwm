package it.unirc.pwm.eureca.utente.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import it.unirc.pwm.eureca.hibernate.util.HibernateUtil;
import it.unirc.pwm.eureca.utente.model.Utente;
 
public class UtenteDAOImplement implements UtenteDAOInterface{
	
	private static Logger logger = LogManager.getLogger(UtenteDAOImplement.class); 
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;

	public UtenteDAOImplement() 
	{
		super();
	
	}
	
	@Override
	public boolean creaUtente(Utente u) 
	{
		session = HibernateUtil.getSessionFactory().openSession();
		boolean control=false;
		try {
			transaction=session.beginTransaction();
			session.save(u);
			logger.info("Utente inserito");
			control=true;
			transaction.commit();
		} catch (Exception e) {
			control=false;
			e.printStackTrace();
			System.out.println("errore dentro il creaUtente");
			transaction.rollback();
		} finally{
			session.close();
		}

		return control;
	}
	
	
	public boolean modificaUtente(Utente u) 
	{
		boolean result=false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(u);
			result=true;
			logger.info("Utente modificato");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("errore dentro il modificata Utente");
			transaction.rollback();
		}finally{
			session.close();
		}
		return result;
	}
}
