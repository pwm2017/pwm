package it.unirc.pwm.eureca.hibernate.util;

import java.util.ArrayList;
import java.util.Date;

import it.unirc.pjam.Esame.Model.Esame;
import it.unirc.pjam.Esame.Model.EsameId;
import it.unirc.pjam.Esame.Model.DAO.EsameDAOFactory;
import it.unirc.pjam.Esame.Model.DAO.EsameDAOInterface;
import it.unirc.pjam.Materia.Model.Materia;
import it.unirc.pjam.Studente.Model.Studente;
import it.unirc.pjam.Studente.Model.DAO.StudenteDAOFactory;
import it.unirc.pjam.Studente.Model.DAO.StudenteDAOInterface;

public class Esegui {

	public static void main(String[] args) {
		
		
		Studente studente1= new Studente(1111,"paolo","m");	
		Studente studente2= new Studente(2222,"marcello","m");	
		
		Materia materia1 = new Materia();
		materia1.setAnno(2013);
		materia1.setNome("basi due");
		
		
		/*
		Esame e = new Esame(new EsameId(122867,4),new Date(),30);
		
		EsameDAOInterface dao = EsameDAOFactory.getDAO();
		try {
			System.out.println("l'esame inserito ha codice "+dao.creaEsame(e).toString());
		} catch (Exception e2) {
			e2.printStackTrace();
			System.out.println("errore dentro il main");
		}*/
		
		/*
		try {
			System.out.println("la materia inserito ha codice "+dao1.creaMateria(materia1));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("errore dentro il main");
		}
		
		
		
		StudenteDAOInterface dao = StudenteDAOFactory.getDAO();
		try {
			System.out.println("lo studente inserito ha codice "+dao.creaStudente(studente1));
			System.out.println("lo studente inserito ha codice "+dao.creaStudente(studente2));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("errore dentro il main");
		}
		*/
		
		
		/*
		 * StudenteDAOInterface dao = StudenteDAOFactory.getDAO();
		try {
			System.out.println("Lo studente che hai ricercato è "+dao.cercaStudentePerNome("marcello").toString());
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("errore dentro il main");
		}
		*/
		
		/*
		try {
			
			ArrayList<Esame> esamiSostenuti = dao.cercaEsamiPerStudente(studente2);
			System.out.println("Gli esami sostenuti da  "+studente2.getNome()+" sono: ");
			if(esamiSostenuti.size()>0){
				for(Esame esame: esamiSostenuti){
					System.out.println(esame.toString());
				}
			}else{
				System.out.println(studente2.getNome()+" non ha sostenuto esami");
			}
			
		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("errore dentro il main");
		}
		*/
		EsameId id = new EsameId(122867,4);
		Esame esameDaModificare = new Esame();
		esameDaModificare.setId(id);
		esameDaModificare.setVoto(18);
		EsameDAOInterface dao = EsameDAOFactory.getDAO();
		dao.modificaVotoEsame(esameDaModificare);
		

	}

}
