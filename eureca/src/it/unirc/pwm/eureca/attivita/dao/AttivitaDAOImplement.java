package it.unirc.pwm.eureca.attivita.dao;

import it.unirc.pwm.eureca.attivita.model.Attivita;
import it.unirc.pwm.eureca.hibernate.util.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AttivitaDAOImplement implements AttivitaDAOInterface {

	private static Logger logger = LogManager.getLogger(AttivitaDAOImplement.class);
	
	Session session = null;
	Transaction transaction = null;

	public AttivitaDAOImplement()
	{
		super();
	}
	@Override
	public boolean creaAttivita(Attivita a)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		boolean control=false;
		try {
			transaction=session.beginTransaction();
			session.save(a);
			logger.info("Attivita inserita");
			control=true;
			transaction.commit();
		} catch (Exception e) {
			control=false;
			e.printStackTrace();
			System.out.println("errore dentro il creaAttivita");
			transaction.rollback();
		} finally{
			session.close();
		}

		return control;
	}


	public boolean modificaAttivita(Attivita a)
	{
		boolean result=false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(a);
			result=true;
			logger.info("Attivita modificata");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("errore dentro il modificata attivita");
			transaction.rollback();
		}finally{
			session.close();
		}
		return result;
	}
	
	
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
			logger.info("Attivita trovata");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("errore dentro il getAttivita");
		}finally{
			session.close();
		}
		return attivita;
	}
	
	
	public Attivita getUltimaAttivita() 
	{
		Attivita attivita = null;
		
		String hql = "from Attivita order by idAttivita DESC";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			@SuppressWarnings("deprecation")
			Query<?> query = session.createQuery(hql);
			if (query.getResultList().size()>0)
				attivita=(Attivita)query.getResultList().get(0);
			logger.info("Attivita trovata");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("errore dentro il getUltimaAttivita");
		}finally{
			session.close();
		}
		return attivita;
	}
}
