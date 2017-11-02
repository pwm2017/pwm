package it.unirc.pwm.eureca.personaFisica.dao;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import it.unirc.pwm.eureca.hibernate.util.HibernateUtil;

public class PersonaFisicaDAOImplement implements PersonaFisicaDAOInterface{
	
	private static Logger logger = LogManager.getLogger(PersonaFisicaDAOImplement.class); 
	Session session = HibernateUtil.getSessionFactory().openSession();
	Transaction transaction = null;

	public PersonaFisicaDAOImplement() {
		super();
	
	}
	
}
