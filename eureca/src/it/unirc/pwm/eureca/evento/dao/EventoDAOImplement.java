package it.unirc.pwm.eureca.evento.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import it.unirc.pwm.eureca.evento.model.Evento;
import it.unirc.pwm.eureca.hibernate.util.HibernateUtil;
import it.unirc.pwm.eureca.utente.model.Utente;
import it.unirc.pwm.eureca.utils.Costant;

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

	@SuppressWarnings("unchecked")
	public List<Evento> getEventi(){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Evento> res = null;
		try {
			transaction=session.beginTransaction();
			res = (List<Evento>)session.createQuery("from Evento ORDER BY idEvento DESC").list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			logger.error("errore nella ricerca degli Eventi");
		}finally{
			session.close();
		}

		return res;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Evento> getEventiRecenti()
	{
		session = HibernateUtil.getSessionFactory().openSession();
		List<Evento> res = null;
		try {
			transaction=session.beginTransaction();
			res = (List<Evento>)session.createQuery("from Evento ORDER BY idEvento DESC").setMaxResults(4).list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			logger.error("errore nella ricerca degli Eventi");
		}finally{
			session.close();
		}

		return res;
	}


	public Evento getEvento(Evento ev){
		Evento eve = null;

		String hql = "from Evento where idEvento ='"+ev.getIdEvento()+"'";
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			Query query = session.createQuery(hql);
			if (query.list().size()>0)
				eve=(Evento)query.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("errore nel getEvento");
		}finally{
			session.close();
		}
		return eve;
	}

	@SuppressWarnings("unchecked")
	public List<Evento> cercaEventiPagina(int numeroPagina)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		List<Evento> res = null;
		try {
			transaction=session.beginTransaction();
			res = (List<Evento>)session.createQuery("from Evento").setFirstResult((numeroPagina*Costant.SIZE_LIST)).setMaxResults(Costant.SIZE_LIST).list();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			logger.error("errore nella ricerca dei Eventi");
		}finally{
			session.close();
		}

		return res;
	}

	public Boolean eliminaEvento(Evento ev)
	{
		session = HibernateUtil.getSessionFactory().openSession();
		boolean control=false;
		try {
			transaction=session.beginTransaction();
			session.delete(ev);
			logger.info("Evento cancellato");
			transaction.commit();
			control=true;
		} catch (Exception e) {
			control=false;
			e.printStackTrace();
			System.out.println("errore dentro l'eliminaEvento");
			transaction.rollback();
		} finally{
			session.close();
		}

		return control;

	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Utente> getUtentiEvento(Evento ev)
	{
		List<Utente> utenti = new ArrayList<>();
		
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			
			utenti=(List<Utente>) session.createSQLQuery("select p.*, u.ente"
					+ " from personafisica p"
					+ " join utente as u on u.idPersonaFisica=p.idPersonaFisica"
					+ " join utente_evento as ue on ue.IDUTENTE=u.idPersonaFisica"
					+ " join evento as e on e.idEvento=ue.IDEVENTO"
					+ " where e.idEvento='"+ev.getIdEvento()+"'").addEntity(Utente.class).list();

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			session.close();
		}

		return utenti;

	}

}
