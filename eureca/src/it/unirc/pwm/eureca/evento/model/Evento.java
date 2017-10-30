package it.unirc.pwm.eureca.Evento.Model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import it.unirc.pwm.eureca.Utente.Model.*;
import it.unirc.pwm.eureca.attivita.model.*;

public class Evento {
	private int idEvento;
	private String nome;
	private String locandina;
	private String descrizione;
	private String luogo;
	private Date dataEvento;
	private Set<Attivita> attivita = new HashSet<Attivita>(0);
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
	public Date getDataEvento() {
		return dataEvento;
	}
	public void setDataEvento(Date dataEvento) {
		this.dataEvento = dataEvento;
	}
	public Set<Attivita> getAttivita() {
		return attivita;
	}
	public void setAttivita(Set<Attivita> attivita) {
		this.attivita = attivita;
	}
}
