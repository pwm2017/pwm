package it.unirc.pwm.eureca.action.utente;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.eureca.evento.dao.EventoDAOFactory;
import it.unirc.pwm.eureca.evento.dao.EventoDAOInterface;
import it.unirc.pwm.eureca.evento.model.Evento;
import it.unirc.pwm.eureca.utente.dao.UtenteDAOFactory;
import it.unirc.pwm.eureca.utente.dao.UtenteDAOInterface;
import it.unirc.pwm.eureca.utente.model.Utente;

public class PartecipaEventoAndroid extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private Utente utente;
	private EventoDAOInterface edao=EventoDAOFactory.getDAO();
	private UtenteDAOInterface udao=UtenteDAOFactory.getDAO();

	private int id = 0;
	private boolean risultato = false;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public boolean isRisultato() {
		return risultato;
	}
	public void setRisultato(boolean risultato) {
		this.risultato = risultato;
	}

	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public String execute() {
		Evento tmp = new Evento();
		tmp.setIdEvento(id);
		utente.getEventi().add(edao.getEvento(tmp));

		if(udao.creaUtente(utente))
		{
			risultato = true;
			return INPUT;
		}
		else	
		{
			risultato = false;
			return ERROR;
		}
	}
}
