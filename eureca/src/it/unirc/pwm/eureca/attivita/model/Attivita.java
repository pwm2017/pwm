package it.unirc.pwm.eureca.attivita.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import it.unirc.pwm.eureca.evento.model.Evento;
import it.unirc.pwm.eureca.Socio.Model.*;

public class Attivita 
{
	private int idAttivita;
	private String nome;
	private String tipologia;
	private String descrizione;
	private Date dataScadenza;
	private Evento evento;
	 //importante
	public Attivita() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdAttivita() {
		return idAttivita;
	}
	public void setIdAttivita(int idAttivita) {
		this.idAttivita = idAttivita;
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
	public Date getDataScadenza() {
		return dataScadenza;
	}
	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	
}
