package it.unirc.pwm.eureca.svolge.dao;

import it.unirc.pwm.eureca.hibernate.util.HibernateUtil;
import it.unirc.pwm.eureca.svolge.model.Svolge;
import it.unirc.pwm.eureca.svolge.model.SvolgeId;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

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

//	
//	@Override
//	public int modificaVotoEsame(Esame e) {
//		session = HibernateUtil.getSessionFactory().openSession();
//		try {
//			transaction= session.beginTransaction();
//			Esame esameDaModificare = (Esame) session.get(e.getClass(), e.getId());
//			if(esameDaModificare==null){
//				session.save(e);
//				logger.info("E' stato inserito un nuovo esame");
//			}else{
//				esameDaModificare.setVoto(e.getVoto());
//				logger.info("L'esame è stato modificato");
//			}
//			transaction.commit();
//		} catch (Exception e2) {
//			e2.printStackTrace();
//			transaction.rollback();
//		} finally{
//			session.close();
//		}
//		
//		return 0;
//	}
//
//	public int eliminaEsame(Esame e) {
//		session = HibernateUtil.getSessionFactory().openSession();
//		try {
//			transaction= session.beginTransaction();
//			Esame esameDaModificare = (Esame) session.get(e.getClass(), e.getId());
//			if(esameDaModificare==null){
//				session.delete(e);;
//				logger.info("E' stato inserito un nuovo esame");
//			}else{
//				logger.info("L'esame non a stato modificato");
//			}
//			transaction.commit();
//		} catch (Exception e2) {
//			e2.printStackTrace();
//			transaction.rollback();
//		} finally{
//			session.close();
//		}
//		
//		return 0;
//	}
}
