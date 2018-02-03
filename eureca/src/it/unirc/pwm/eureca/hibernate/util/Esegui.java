package it.unirc.pwm.eureca.hibernate.util;

import it.unirc.pwm.eureca.attivita.model.Attivita;
import it.unirc.pwm.eureca.evento.model.Evento;
import it.unirc.pwm.eureca.socio.model.Socio;
import it.unirc.pwm.eureca.svolge.dao.SvolgeDAOFactory;
import it.unirc.pwm.eureca.svolge.dao.SvolgeDAOInterface;
import it.unirc.pwm.eureca.svolge.model.Svolge;
import it.unirc.pwm.eureca.svolge.model.SvolgeId;


public class Esegui 
{

	public static void main(String[] args)
	{
		Attivita a=new Attivita();
		a.setNome("pinco");
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
//        AttivitaDAOInterface dao= AttivitaDAOFactory.getDAO();
//		
//        try 
//		{
//			System.out.println("l'esame inserito ha codice "+dao.modificaAttivita(a));
//		} catch (Exception e2) 
//		{
//			e2.printStackTrace();
//			System.out.println("errore dentro il main");		
//		}
//        
          Evento e=new Evento();
         e.setNome("veventomodificato");
//        Evento e1=new Evento();
//        e1.setNome("veventomodificato");
		
		
//       ViaggioDAOInterface dao= ViaggioDAOFactory.getDAO();
//       Viaggio v=new Viaggio();
//       v.setDescrizione("primo viaggio");
//       
       Socio s=new Socio();
       s.setNome("antonio");
//       v.getSoci().add(s);
//    
//       
//       
//     try 
//		{			System.out.println("l'esame inserito ha codice "+dao.creaViaggio(v));
//		} catch (Exception e2) 
//		{
//		e2.printStackTrace();
//		System.out.println("errore dentro il main");
//		}

//      EventoDAOInterface dao= EventoDAOFactory.getDAO();
//      dao.creaEvento(e);

//		AttivitaDAOInterface daoA= AttivitaDAOFactory.getDAO();
//		SocioDAOInterface daoS= SocioDAOFactory.getDAO();
		SvolgeDAOInterface dao= SvolgeDAOFactory.getDAO();
		Svolge sv=new Svolge();
		a.setEvento(e);
		a.setEvento(e);
		SvolgeId svo=new SvolgeId();
		svo.setIdAttivita(1);
		svo.setIdSocio(1);
		sv.setId(svo);
		dao.Socio_Svolge_Attivita(sv);
//		daoA.creaAttivita(a);
//		System.out.println(daoA.getAttivita(a).getNome());
		
		
		
//		Socio so=new Socio();
//		so.setNome("antonio");
//		so.setPassword("ciao");
//		so.setUsername("ciao");
////		
//		ViaggioDAOInterface daoS= ViaggioDAOFactory.getDAO();
//		Viaggio v=new Viaggio();
//		v.setIdViaggio(1);
//		Socio s=new Socio();
//		s.setIdPersonaFisica(1);
//		daoS.aggiungiSocioViaggio(v, s);
//		daoS.creaSocio(so);
//		so.setPassword("ciao");
//		so.setAmministratore(false);
		
//		System.out.println(daoS.getSoci().size());
		//System.out.println(daoS.verificaLogin(so).toString());
//		System.out.println(daoS.verificaLogin(so).toString());
//		if(daoS.verificaLogin(so)==(null))
//			System.out.println("non trovato");
//		so.setIdPersonaFisica(1);
//		a.setIdAttivita(1);
//		daoS.creaSocio(so);
//		s.setSocio(so);
//		s.setAttivita(a);
//		SvolgeId id=new SvolgeId();
//		id.setIdAttivita(1);
//		id.setIdSocio(1);
//		s.setId(id);
		
		
		
		
		
		
		
		
		HibernateUtil.close();
	}

}
