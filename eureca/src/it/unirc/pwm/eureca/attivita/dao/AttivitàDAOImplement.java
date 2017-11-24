package it.unirc.pwm.eureca.attivita.dao;
import it.unirc.pwm.eureca.attivita.model.Attivita;
import it.unirc.pwm.eureca.hibernate.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class Attivit�DAOImplement implements Attivit�DAOInterface{

	private static Logger logger = LogManager.getLogger(Attivit�DAOImplement.class); 
	
	Session session = null;
	Transaction transaction = null;

	public Attivit�DAOImplement()
	{
		super();
	}
	@Override
	public boolean creaAttivit�(Attivita a) 
	{
		session = HibernateUtil.getSessionFactory().openSession();
		boolean control=false;
		try {
			transaction=session.beginTransaction();
			session.save(a);
			logger.info("Attivit� inserita");
			control=true;
			transaction.commit();
		} catch (Exception e) {
			control=false;
			e.printStackTrace();
			System.out.println("errore dentro il creaAttivit�");
			transaction.rollback();
		} finally{
			session.close();
		}

		return control;
	}
	
	
	public boolean modificaAttivit�(Attivita a) 
	{
		boolean result=false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(a);
			result=true;
			logger.info("Attivit� modificata");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("errore dentro il modificata attivit�");
			transaction.rollback();
		}finally{
			session.close();
		}
		return result;
	}
	
	
	@Override
	public Attivita getAttivita(Attivita a) 
	{
		Attivita attivita = null;
		
		String hql = "from Attivita where idAttivita ='"+a.getIdAttivita()+"'";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			@SuppressWarnings("deprecation")
			Query<?> query = session.createQuery(hql);
			if (query.getResultList().size()>0)
				attivita=(Attivita)query.getResultList().get(0);
			logger.info("Attivit� trovata");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("errore dentro il getAttivita");
		}finally{
			session.close();
		}
		return attivita;
	}
}
