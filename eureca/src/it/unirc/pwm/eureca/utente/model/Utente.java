package it.unirc.pwm.eureca.utente.model;
import java.util.HashSet;
import java.util.Set;

import it.unirc.pwm.eureca.evento.model.Evento;
import it.unirc.pwm.eureca.personaFisica.model.*;

public class Utente extends PersonaFisica
{
	private String ente;
	private Set<Evento> eventi = new HashSet<Evento>(0);
	
	public Utente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEnte() {
		return ente;
	}

	public void setEnte(String ente) {
		this.ente = ente;
	}

	public Set<Evento> getEventi() {
		return eventi;
	}

	public void setEventi(Set<Evento> eventi) {
		this.eventi = eventi;
	}
	
}
