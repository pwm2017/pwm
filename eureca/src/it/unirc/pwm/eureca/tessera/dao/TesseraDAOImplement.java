package it.unirc.pwm.eureca.tessera.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.unirc.pwm.eureca.hibernate.util.HibernateUtil;
import it.unirc.pwm.eureca.socio.model.Socio;
import it.unirc.pwm.eureca.tessera.model.Tessera;


public class TesseraDAOImplement implements TesseraDAOInterface
{
	
	private static Logger logger = LogManager.getLogger(TesseraDAOImplement.class); 
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;

	public TesseraDAOImplement() {
		super();
	
	}
	
	public boolean creaTessera(Tessera t) 
	{
		session = HibernateUtil.getSessionFactory().openSession();
		boolean control=false;
		try {
			transaction=session.beginTransaction();
			session.save(t);
			logger.info("Tessera inserito");
			control=true;
			transaction.commit();
		} catch (Exception e) {
			control=false;
			e.printStackTrace();
			System.out.println("errore dentro il creaTessera");
			transaction.rollback();
		} finally{
			session.close();
		}

		return control;
	}
	
	public boolean modificaTessera(Tessera t) 
	{
		boolean result=false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(t);
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
	
	public Tessera getTesseraSocio(Socio s) 
	{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction=session.beginTransaction();
		Tessera res = null;
		try {
			
		    res = (Tessera)session.createQuery( "from Tessera where idSocio= :idSocio" ).setParameter("idSocio", s.getIdPersonaFisica()).uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			logger.error("errore nella ricerca della TesseraSocio");
		}finally{
			session.close();
		}
		
		return res;
	}

}
