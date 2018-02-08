package it.unirc.pwm.eureca.attivita.dao;
import it.unirc.pwm.eureca.attivita.model.Attivita;
import it.unirc.pwm.eureca.evento.model.Evento;
import it.unirc.pwm.eureca.hibernate.util.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
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
	public int creaAttivit‡(Attivita a) 
	{
		int id=0;
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			transaction=session.beginTransaction();
			id=(int)session.save(a);
			logger.info("Attivit‡ inserita");

			transaction.commit();
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println("errore dentro il creaAttivit‡");
			transaction.rollback();
		} finally{
			session.close();
		}

		return id;
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
			logger.info("Attivit‡ trovata");
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
			logger.info("Attivit‡ trovata");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("errore dentro il getUltimaAttivita");
		}finally{
			session.close();
		}
		return attivita;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Attivita> getAttivit‡Evento(Evento ev) 
	{
		List<Attivita> attivita = new ArrayList<>();

		String hql = "from Attivita where EVENTO=:evento";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			attivita=(List<Attivita>) session.createQuery(hql).setEntity("evento", ev).list();
			logger.info("Attivit‡ trovata");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("errore dentro il getUltimaAttivita");
		}finally{
			session.close();
		}
		return attivita;
	}
}
