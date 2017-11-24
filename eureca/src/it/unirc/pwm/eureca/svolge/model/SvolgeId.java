package it.unirc.pwm.eureca.svolge.model;

public class SvolgeId implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private int idSocio, idAttivita;

	public SvolgeId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}

	public int getIdAttivita() {
		return idAttivita;
	}

	public void setIdAttivita(int idAttivita) {
		this.idAttivita = idAttivita;
	}

}
