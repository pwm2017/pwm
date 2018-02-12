package it.unirc.pwm.eureca.svolge.dao;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.unirc.pwm.eureca.attivita.model.Attivita;
import it.unirc.pwm.eureca.hibernate.util.HibernateUtil;
import it.unirc.pwm.eureca.socio.model.Socio;
import it.unirc.pwm.eureca.svolge.model.Svolge;
import it.unirc.pwm.eureca.svolge.model.SvolgeId;

public class SvolgeDAOImplement implements SvolgeDAOInterface
{

	private static Logger logger = LogManager.getLogger(SvolgeDAOImplement.class); 
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;

	public SvolgeDAOImplement() {
		super();

	}
	@Override
	public boolean Socio_Svolge_Attivita(Svolge s)
	{
		boolean control=false;;
		session = HibernateUtil.getSessionFactory().openSession();
		SvolgeId id=new SvolgeId();
		try {
			transaction=session.beginTransaction();
			id =(SvolgeId) session.save(s);
			logger.info("Socio_Svolge_Attivita inserito");
			control=true;
			transaction.commit();

		} catch (Exception ex) {
			control=false;
			ex.printStackTrace();
			logger.info("errore dentro il Socio_Svolge_Attivita");
			transaction.rollback();
		}finally{
			session.close();
		}

		return control;
	}


	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Attivita> SocioSvolgeAttivita(Socio s)
	{
		List<Attivita> res = null;
		session = HibernateUtil.getSessionFactory().openSession();
		transaction=session.beginTransaction();
		try {

			res = (List<Attivita>)session.createSQLQuery("Select * from attivita a, socio_svolge_attivita s where a.dataScadenza>CURRENT_DATE() and a.idAttivita= s.idAttivita and idSocio ='"+s.getIdPersonaFisica()+"'").addEntity(Attivita.class).list();
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
}
