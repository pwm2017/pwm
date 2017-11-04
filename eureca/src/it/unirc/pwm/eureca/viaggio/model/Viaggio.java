package it.unirc.pwm.eureca.viaggio.model;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import it.unirc.pwm.eureca.socio.model.Socio;


public class Viaggio {
	private int idViaggio;
	private String nome;
	private String locandina;
	private String descrizione;
	private int numPartecipanti;
	private Date dataInizio;
	private Date dataFine;
	private Set<Socio> soci = new HashSet<Socio>(0);
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
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public Set<Socio> getSoci() {
		return soci;
	}
	public void setSoci(Set<Socio> soci) {
		this.soci = soci;
	}
}
