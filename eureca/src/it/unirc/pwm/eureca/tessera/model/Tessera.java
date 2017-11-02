package it.unirc.pwm.eureca.tessera.model;

import java.sql.Timestamp;
import it.unirc.pwm.eureca.socio.model.Socio;

public class Tessera {
	private int idTessera;
	private int punti;
	private Timestamp dataRilascio;
	private Timestamp dataScadenza;
	private Socio socio;
	public Tessera() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdTessera() {
		return idTessera;
	}
	public void setIdTessera(int idTessera) {
		this.idTessera = idTessera;
	}
	public int getPunti() {
		return punti;
	}
	public void setPunti(int punti) {
		this.punti = punti;
	}
	public Timestamp getDataRilascio() {
		return dataRilascio;
	}
	public void setDataRilascio(Timestamp dataRilascio) {
		this.dataRilascio = dataRilascio;
	}
	public Timestamp getDataScadenza() {
		return dataScadenza;
	}
	public void setDataScadenza(Timestamp dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	

}
