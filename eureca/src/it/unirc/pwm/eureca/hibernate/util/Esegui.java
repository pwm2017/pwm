package it.unirc.pwm.eureca.hibernate.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import it.unirc.pwm.eureca.attivita.dao.Attivit‡DAOFactory;
import it.unirc.pwm.eureca.attivita.dao.Attivit‡DAOInterface;
import it.unirc.pwm.eureca.attivita.model.Attivita;
import it.unirc.pwm.eureca.evento.dao.EventoDAOFactory;
import it.unirc.pwm.eureca.evento.dao.EventoDAOInterface;
import it.unirc.pwm.eureca.evento.model.Evento;
import it.unirc.pwm.eureca.personaFisica.dao.PersonaFisicaDAOImplement;
import it.unirc.pwm.eureca.socio.model.Socio;
import it.unirc.pwm.eureca.tessera.dao.TesseraDAOFactory;
import it.unirc.pwm.eureca.tessera.dao.TesseraDAOInterface;
import it.unirc.pwm.eureca.tessera.model.Tessera;
import it.unirc.pwm.eureca.utente.dao.UtenteDAOFactory;
import it.unirc.pwm.eureca.utente.dao.UtenteDAOInterface;
import it.unirc.pwm.eureca.utente.model.Utente;


public class Esegui {

	public static void main(String[] args)
	{
//		
//		Attivita a=new Attivita();
//		a.setNome("pinco");
//		a.setIdAttivita(0);
//        Evento e=new Evento();
//        e.setNome("ciao");
//        Utente u=new Utente();
//		u.setNome("anto");
//		Utente u1=new Utente();
//		u.setNome("ciao"); 
//		u.getEventi().add(e);
//		e.getUtenti().add(u);
//		e.getUtenti().add(u1);
//		a.setEvento(e);
//		Set<Attivita> a1=new HashSet<Attivita>(0);
//		a1.add(a);
//		
//		
//        Attivit‡DAOInterface dao= Attivit‡DAOFactory.getDAO();
//		
//        try 
//		{
//			System.out.println("l'esame inserito ha codice "+dao.modificaAttivit‡(a));
//		} catch (Exception e2) 
//		{
//			e2.printStackTrace();
//			System.out.println("errore dentro il main");		
//		}
//        
//        Evento e=new Evento();
//        e.setNome("veventomodificato");
//        Evento e1=new Evento();
//        e1.setNome("veventomodificato");
		
		
       TesseraDAOInterface dao= TesseraDAOFactory.getDAO();
       Tessera t=new Tessera();
       t.setPunti(10);
       
       Socio s=new Socio();
       s.setNome("antonio");
       s.setIdPersonaFisica(3);
       t.setSocio(s);
    
       
       
     try 
		{			System.out.println("l'esame inserito ha codice "+dao.creaTessera(t));
		} catch (Exception e2) 
		{
		e2.printStackTrace();
		System.out.println("errore dentro il main");
		}

//      EventoDAOInterface dao= EventoDAOFactory.getDAO();
//  
//      
//   try 
//		{			System.out.println("l'esame inserito ha codice "+ dao.creaEvento(e));
//		} catch (Exception e2) 
//		{
//		e2.printStackTrace();
//		System.out.println("errore dentro il main");
//		}
//   
		
		HibernateUtil.close();
	}

}
