package it.unirc.pwm.eureca.Attivit‡.DAO;

import it.unirc.pwm.eureca.Attivita.Model.Attivit‡;
import it.unirc.pwm.eureca.hibernate.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Attivit‡DAOImplement implements Attivit‡DAOInterface{

	private static Logger logger = LogManager.getLogger(Attivit‡DAOImplement.class); 
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;

	public Attivit‡DAOImplement()
	{
		super();
	}
	@Override
	public boolean creaAttivit‡(Attivit‡ a) 
	{
		session = HibernateUtil.getSessionFactory().openSession();
		boolean control=false;
		try {
			transaction=session.beginTransaction();
			session.save(a);
			logger.info("Attivit‡ inserito");
			control=true;
			transaction.commit();
		} catch (Exception e) {
			control=false;
			e.printStackTrace();
			System.out.println("errore dentro il creaAttivit‡");
			transaction.rollback();
		} finally{
			session.close();
		}

		return control;
	}
	//
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
	//				logger.info("L'esame √® stato modificato");
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
