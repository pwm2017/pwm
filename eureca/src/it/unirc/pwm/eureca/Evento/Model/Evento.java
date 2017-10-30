package it.unirc.pwm.eureca.Evento.Model;

import java.sql.Timestamp;
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
	private Timestamp data;
	private Set<Attività> attività = new HashSet<Attività>(0);
	private Set<Utente> utente = new HashSet<Utente>(0);
	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdEvento() {
		return idEvento;
	}
	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocandina() {
		return locandina;
	}
	public void setLocandina(String locandina) {
		this.locandina = locandina;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getLuogo() {
		return luogo;
	}
	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}
	public Timestamp getData() {
		return data;
	}
	public void setData(Timestamp data) {
		this.data = data;
	}
	public Set<Attività> getAttività() {
		return attività;
	}
	public void setAttività(Set<Attività> attività) {
		this.attività = attività;
	}
	public Set<Utente> getUtente() {
		return utente;
	}
	public void setUtente(Set<Utente> utente) {
		this.utente = utente;
	}
	
	

}
