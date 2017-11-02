package it.unirc.pwm.eureca.evento.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import it.unirc.pwm.eureca.evento.model.Evento;
import it.unirc.pwm.eureca.hibernate.util.HibernateUtil;
 
public class EventoDAOImplement implements EventoDAOInterface{
	
	private static Logger logger = LogManager.getLogger(EventoDAOImplement.class); 
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;

	public EventoDAOImplement() {
		super();
	
	}
	
	@Override
	public boolean creaEvento(Evento eve) 
	{
		session = HibernateUtil.getSessionFactory().openSession();
		boolean control=false;
		try {
			transaction=session.beginTransaction();
			session.save(eve);
			logger.info("Evento inserito");
			control=true;
			transaction.commit();
		} catch (Exception e) {
			control=false;
			e.printStackTrace();
			System.out.println("errore dentro il creaEvento");
			transaction.rollback();
		} finally{
			session.close();
		}

		return control;
	}
	
	
	public boolean modificaEvento(Evento eve) 
	{
		boolean result=false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(eve);
			result=true;
			logger.info("Evento modificato");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("errore dentro il modificata Evento");
			transaction.rollback();
		}finally{
			session.close();
		}
		return result;
	}
}
