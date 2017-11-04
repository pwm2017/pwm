package it.unirc.pwm.eureca.svolge.model;

import it.unirc.pwm.eureca.attivita.model.Attivita;
import it.unirc.pwm.eureca.socio.model.Socio;

public class Svolge
{
	private SvolgeId id;
	private Socio socio;
	private Attivita attivita;
	private boolean disponibilita;
	
	public Svolge() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SvolgeId getId() {
		return id;
	}


	public void setId(SvolgeId id) {
		this.id = id;
	}


	public Socio getSocio() {
		return socio;
	}


	public void setSocio(Socio socio) {
		this.socio = socio;
	}


	public Attivita getAttivita() {
		return attivita;
	}


	public void setAttivita(Attivita attivita) {
		this.attivita = attivita;
	}


	public boolean isDisponibilita() {
		return disponibilita;
	}


	public void setDisponibilita(boolean disponibilita) {
		this.disponibilita = disponibilita;
	}

}
