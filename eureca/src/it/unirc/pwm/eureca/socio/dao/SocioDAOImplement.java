package it.unirc.pwm.eureca.socio.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import it.unirc.pwm.eureca.hibernate.util.HibernateUtil;
import it.unirc.pwm.eureca.socio.model.Socio;
 
public class SocioDAOImplement implements SocioDAOInterface{
	
	private static Logger logger = LogManager.getLogger(SocioDAOImplement.class); 
	
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;

	public SocioDAOImplement() 
	{
		super();
	
	}
	
	@Override
	public boolean creaSocio(Socio s) 
	{
		session = HibernateUtil.getSessionFactory().openSession();
		boolean control=false;
		try {
			transaction=session.beginTransaction();
			session.save(s);
			logger.info("Socio inserito");
			control=true;
			transaction.commit();
		} catch (Exception e) {
			control=false;
			e.printStackTrace();
			System.out.println("errore dentro il creaSocio");
			transaction.rollback();
		} finally{
			session.close();
		}

		return control;
	}
	
	
	public boolean modificaSocio(Socio s) 
	{
		boolean result=false;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.update(s);
			result=true;
			logger.info("Socio modificato");
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			logger.info("errore dentro il modificata Socio");
			transaction.rollback();
		}finally{
			session.close();
		}
		return result;
	}
	
	
	public Socio verificaLogin(Socio s)
	{
		Socio trovato =null;
		session = HibernateUtil.getSessionFactory().openSession();
		try {
				
			String hql = "from Socio s "
					   + "where  "
					   + "s.username ='"+s.getUsername()+"' and "
					   + "s.password ='"+s.getPassword()+"'";
			Query query = session.createQuery(hql);
			if(query.list().size()>0)
			{
				trovato = (Socio) query.list().get(0);
				logger.info("socio trovato");
			}
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("socio non trovato");
		}finally{
			if(session.isOpen())
			session.close();
		}
		return trovato;
	}
}
