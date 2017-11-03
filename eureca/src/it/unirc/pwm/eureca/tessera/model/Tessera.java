package it.unirc.pwm.eureca.tessera.model;

import java.util.Date;
import it.unirc.pwm.eureca.socio.model.Socio;

public class Tessera {
	private int idSocio;
	private int punti;
	private Date dataRilascio;
	private Date dataScadenza;
	private Socio socio;
	public Tessera() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public int getIdSocio() {
		return idSocio;
	}



	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}



	public int getPunti() {
		return punti;
	}
	public void setPunti(int punti) {
		this.punti = punti;
	}
	public Date getDataRilascio() {
		return dataRilascio;
	}
	public void setDataRilascio(Date dataRilascio) {
		this.dataRilascio = dataRilascio;
	}
	public Date getDataScadenza() {
		return dataScadenza;
	}
	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	
	
}
