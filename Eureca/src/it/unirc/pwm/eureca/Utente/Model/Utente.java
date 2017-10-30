package it.unirc.pwm.eureca.Utente.Model;
import it.unirc.pwm.eureca.PersonaFisica.Model.*;

public class Utente extends PersonaFisica{
	private int idUtente;
	private String ente;

	public Utente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEnte() {
		return ente;
	}

	public void setEnte(String ente) {
		this.ente = ente;
	}

	public int getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}
	

}
