package it.unirc.pwm.eureca.svolge.dao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import it.unirc.pwm.eureca.hibernate.util.HibernateUtil;
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
	public boolean creaSocio_Svolge_Attivita(Svolge s)
	{
		boolean control=false;
		SvolgeId id=new SvolgeId();
		session = HibernateUtil.getSessionFactory().openSession();
		try {
			transaction=session.beginTransaction();
			id =(SvolgeId) session.save(s);
			logger.info("Socio_Svolge_Attivita inserito");
			control=true;
			transaction.commit();
			
		} catch (Exception ex) {
			control=false;
			ex.printStackTrace();
			System.out.println("errore dentro il creaSocio_Svolge_Attivita");
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
//				logger.info("L'esame Ã¨ stato modificato");
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
//				logger.info("L'esame non è stato modificato");
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
