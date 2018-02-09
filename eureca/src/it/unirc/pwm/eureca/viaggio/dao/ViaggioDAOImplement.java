package it.unirc.pwm.eureca.viaggio.dao;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import it.unirc.pwm.eureca.hibernate.util.HibernateUtil;
import it.unirc.pwm.eureca.socio.model.Socio;
import it.unirc.pwm.eureca.utils.Costant;
import it.unirc.pwm.eureca.viaggio.model.Viaggio;

public class ViaggioDAOImplement implements ViaggioDAOInterface
{
	
	private static Logger logger = LogManager.getLogger(ViaggioDAOImplement.class); 
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;

	public ViaggioDAOImplement()
	{
		super();
	
	}
	
	@Override
	public boolean creaViaggio(Viaggio v) 
	{
		session = HibernateUtil.getSessionFactory().openSession();
		boolean control=false;
		try {
			transaction=session.beginTransaction();
			session.save(v);
			logger.info("Viaggio inserito");
			control=true;
			transaction.commit();
		} catch (Exception e) {
			control=false;
			e.printStackTrace();
			System.out.println("errore dentro il creaViaggio");
			transaction.rollback();
		} finally{
			session.close();
		}

		return control;
	}
	
	
	public boolean modificaViaggio(Viaggio v) 
	{
		boolean result=false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(v);
			result=true;
			logger.info("Viaggio modificato");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("errore dentro il modificata Viaggio");
			transaction.rollback();
		}finally{
			session.close();
		}
		return result;
	}
	
	
	public boolean aggiungiSocioViaggio(Viaggio v, Socio s) 
	{
	
		boolean result=false;
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		try {
			v.getSoci().add(s);
			session.update(v);
			logger.info("Viaggio modificato");
			transaction.commit();
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("errore dentro il modificata Viaggio");
			transaction.rollback();
		}finally{
			session.close();
		}
		return result;
	}
	
	public Viaggio getViaggio(Viaggio v)
	{
		Viaggio vi = null;

		String hql = "from Viaggio where idViaggio ='"+v.getIdViaggio()+"'";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			if (query.list().size()>0)
				vi=(Viaggio)query.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return vi;
	}
	
	public List<Viaggio> getViaggi()
	{
		List<Viaggio> viaggi = new ArrayList<>();
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "FROM Viaggio";
			Query query = session.createQuery(hql);
			viaggi=query.list();


		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}

		return viaggi;

	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Viaggio> getViaggiSoci()
	{
		List<Viaggio> viaggi = new ArrayList<>();
		
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			
			viaggi=(List<Viaggio>) session.createSQLQuery("SELECT * FROM viaggio WHERE numPartecipanti>0 AND IDVIAGGIO NOT IN (SELECT idViaggio FROM socio_viaggio)").addEntity(Viaggio.class).list();

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}

		return viaggi;

	}
	
	public Boolean eliminaViaggio(Viaggio v)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		boolean result=false;
		try 
		{
			Viaggio res = (Viaggio)session.createQuery( "from Viaggio where idViaggio= :idViaggio" ).setParameter("idViaggio", v.getIdViaggio()).uniqueResult();
			session.delete(res);
			logger.info("Viaggio cancellato");
			transaction.commit();
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;

	}
	
	@SuppressWarnings("unchecked")
	public List<Viaggio> cercaViaggiPagina(int numeroPagina)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		List<Viaggio> res = null;
		try {
			transaction=session.beginTransaction();
		    res = (List<Viaggio>)session.createQuery("from Viaggio").setFirstResult((numeroPagina*Costant.SIZE_LIST)).setMaxResults(Costant.SIZE_LIST).list();
		    transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			logger.error("errore nella ricerca dei Viaggi");
		}finally{
			session.close();
		}
		
		return res;
	}
	
}
