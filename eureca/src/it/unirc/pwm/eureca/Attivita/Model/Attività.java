package it.unirc.pwm.eureca.Attivita.Model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import it.unirc.pwm.eureca.Evento.Model.*;
import it.unirc.pwm.eureca.Socio.Model.*;

public class Attività {
	private int idAttività;
	private String nome;
	private String tipologia;
	private String descrizione;
	private Set<Socio> soci = new HashSet<Socio>(0);
	private Evento evento;
	private Date dataScadenza; //importante
	public Attività() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdAttività() {
		return idAttività;
	}
	public void setIdAttività(int idAttività) {
		this.idAttività = idAttività;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Set<Socio> getSoci() {
		return soci;
	}
	public void setSoci(Set<Socio> soci) {
		this.soci = soci;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	
	

}
