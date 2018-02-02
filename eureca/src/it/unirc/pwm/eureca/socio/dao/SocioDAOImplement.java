package it.unirc.pwm.eureca.socio.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
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
		transaction=session.beginTransaction();
		boolean control=false;
		try {
			s.setAbilitato(true);;
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
			s.setAbilitato(true);
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

	//con hql
	//	public Socio verificaLogin(Socio s)
	//	{
	//		Socio trovato =null;
	//		session = HibernateUtil.getSessionFactory().openSession();
	//		try {
	//
	//			String hql = "from Socio s "
	//					+ "where  "
	//					+ "s.username ='"+s.getUsername()+"' and "
	//					+ "s.password ='"+s.getPassword()+"'";
	//			Query query = session.createQuery(hql);
	//			if(query.list().size()>0)
	//			{
	//				trovato = (Socio) query.list().get(0);
	//				logger.info("socio trovato");
	//			}
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//			logger.error("socio non trovato");
	//		}finally{
	//			if(session.isOpen())
	//				session.close();
	//		}
	//		return trovato;
	//	}


	public Socio verificaLogin(Socio s) {
		session = HibernateUtil.getSessionFactory().openSession();
		Socio res = null;
		try {
			transaction=session.beginTransaction();
			res = (Socio)session.createQuery( "from Socio where username= :username AND " +
					"password= :password").setParameter("username", s.getUsername()).setParameter("password",s.getPassword()).uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("errore dentro l'esisteAccount");
			transaction.rollback();
		} finally{
			session.close();
		}

		return res;

	}


	//Criteria
	public Boolean verificaUsername(String username) 
	{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		Socio s = null;
		Boolean trovato = false;
		try 
		{
			Criteria cr = session.createCriteria(Socio.class);
			cr.add(Restrictions.eq("username", username));
			s = (Socio)cr.uniqueResult();
			if(s!=null)
				trovato = true;

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}

		return trovato;

	}

	public List<Socio> getSoci()
	{
		List<Socio> soci = new ArrayList<>();
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "FROM Socio where abilitato=1";
			Query query = session.createQuery(hql);
			soci=query.list();


		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}

		return soci;

	}

	public Boolean eliminaSocio(Socio s)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		boolean result=false;

		try 
		{
			Socio res = (Socio)session.createQuery( "from Socio where idPersonaFisica= :idPersonaFisica" ).setParameter("idPersonaFisica", s.getIdPersonaFisica()).uniqueResult();
			res.setAbilitato(false);;
			session.update(res);
			logger.info("Socio cancellato");
			transaction.commit();
			result=true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return result;

	}


	public Socio getSocio(Socio s){
		Socio so = null;

		String hql = "from Socio where abilitato=1 and idPersonaFisica ='"+s.getIdPersonaFisica()+"'";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			if (query.list().size()>0)
				so=(Socio)query.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return so;
	}

	public Socio getSocioById(Socio s){
		session = HibernateUtil.getSessionFactory().openSession();
		Socio trovato = null;
		try {
			Criteria cr = session.createCriteria(Socio.class);
			cr.add(Restrictions.eq("nome", s.getNome()));
			trovato = (Socio)cr.uniqueResult();

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}
		return trovato;
	}

}
