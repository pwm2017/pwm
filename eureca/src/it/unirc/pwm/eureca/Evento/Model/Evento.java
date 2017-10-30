package it.unirc.pwm.eureca.Evento.Model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import it.unirc.pwm.eureca.Attivita.Model.*;
import it.unirc.pwm.eureca.Utente.Model.*;

public class Evento {
	private int idEvento;
	private String nome;
	private String locandina;
	private String descrizione;
	private String luogo;
	private Date dataEvento;
	private Set<Attività> attività = new HashSet<Attività>(0);
	private Set<Utente> utente = new HashSet<Utente>(0);
	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}

}
