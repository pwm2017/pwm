package it.unirc.pwm.eureca.Viaggio.Model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import it.unirc.pwm.eureca.Utente.Model.Utente;

public class Viaggio {
	private int idViaggio;
	private String nome;
	private String locandina;
	private String descrizione;
	private int numPartecipanti;
	private Timestamp dataInizio;
	private Timestamp dataFine;
	private Set<Utente> utente = new HashSet<Utente>(0);
	public Viaggio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdViaggio() {
		return idViaggio;
	}
	public void setIdViaggio(int idViaggio) {
		this.idViaggio = idViaggio;
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
	public int getNumPartecipanti() {
		return numPartecipanti;
	}
	public void setNumPartecipanti(int numPartecipanti) {
		this.numPartecipanti = numPartecipanti;
	}
	public Timestamp getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Timestamp dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Timestamp getDataFine() {
		return dataFine;
	}
	public void setDataFine(Timestamp dataFine) {
		this.dataFine = dataFine;
	}
	public Set<Utente> getUtente() {
		return utente;
	}
	public void setUtente(Set<Utente> utente) {
		this.utente = utente;
	}
	
	
	

}
