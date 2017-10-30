package it.unirc.pwm.eureca.Attivita.Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import it.unirc.pwm.eureca.Evento.Model.*;
import it.unirc.pwm.eureca.Socio.Model.*;

public class Attività 
{
	private int idAttivita;
	private String nome;
	private String tipologia;
	private String descrizione;
	private Date dataScadenza;
	private Set<Socio> soci = new HashSet<Socio>(0);
	private Evento evento;
	 //importante
	public Attività() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
