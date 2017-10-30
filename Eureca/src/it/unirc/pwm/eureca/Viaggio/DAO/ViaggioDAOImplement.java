package it.unirc.pwm.eureca.Viaggio.DAO;
// default package
// Generated 13-apr-2015 18.28.21 by Hibernate Tools 4.0.0


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

//import it.unirc.pjam.Esame.Model.Esame;
//import it.unirc.pjam.Esame.Model.EsameId;
//import it.unirc.pjam.Materia.Model.DAO.MateriaDAOImplement;
//import it.unirc.pjam.hibernate.util.HibernateUtil;


/**
 * Home object for domain model class Esame.
 * @see .Esame
 * @author Maurizio Rizzo
 */
public class ViaggioDAOImplement implements ViaggioDAOInterface{
	
	private static Logger logger = LogManager.getLogger(ViaggioDAOImplement.class); 
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;

	public ViaggioDAOImplement() {
		super();
	
	}

//	private static final Log log = LogFactory.getLog(EsameDAOImplement.class);
//
//	private final SessionFactory sessionFactory = getSessionFactory();

	/**
	 * Questo medoto funziona col dirty checking automatico grazie alla proprietà
	 * dentro il file cfg. Dato l'id preleva l'esame e, senza dirlo esplicitamente, 
	 * si accorge della modifica, e la rende persistente
	 * @see .Esame
	 * @author Maurizio Rizzo
	 */
	@Override
	public EsameId creaEsame(Esame e) {
		session = HibernateUtil.getSessionFactory().openSession();
		EsameId id = new EsameId();
		try {
			transaction= session.beginTransaction();
			id =(EsameId) session.save(e);
			transaction.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			transaction.rollback();
		}finally{
			session.close();
		}
		
		return id;
	}

	
	@Override
	public int modificaVotoEsame(Esame e) {
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction= session.beginTransaction();
			Esame esameDaModificare = (Esame) session.get(e.getClass(), e.getId());
			if(esameDaModificare==null){
				session.save(e);
				logger.info("E' stato inserito un nuovo esame");
			}else{
				esameDaModificare.setVoto(e.getVoto());
				logger.info("L'esame è stato modificato");
			}
			transaction.commit();
		} catch (Exception e2) {
			e2.printStackTrace();
			transaction.rollback();
		} finally{
			session.close();
		}
		
		return 0;
	}

	
}
