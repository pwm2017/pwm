package it.unirc.pwm.eureca.viaggio.dao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import it.unirc.pwm.eureca.hibernate.util.HibernateUtil;
import it.unirc.pwm.eureca.socio.model.Socio;
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
		v.getSoci().add(s);
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
	
	
	
}
