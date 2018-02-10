package it.unirc.pwm.eureca.action.utente;
import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.eureca.evento.dao.EventoDAOFactory;
import it.unirc.pwm.eureca.evento.dao.EventoDAOInterface;
import it.unirc.pwm.eureca.evento.model.Evento;
import it.unirc.pwm.eureca.utente.dao.UtenteDAOFactory;
import it.unirc.pwm.eureca.utente.dao.UtenteDAOInterface;
import it.unirc.pwm.eureca.utente.model.Utente;


public class UtentePartecipaEvento extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private Evento evento=null;
	private Utente utente;
	private EventoDAOInterface edao=EventoDAOFactory.getDAO();
	private UtenteDAOInterface udao=UtenteDAOFactory.getDAO();

	
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public Utente getUtente() {
		return utente;
	}
	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public String execute()
	{
		return SUCCESS;
	}

	public String partecipaEvento()
	{	
		utente.getEventi().add(edao.getEvento(evento));

		if(udao.creaUtente(utente))
		{
			addActionMessage("Dati inseriti correttamente!!");
			return SUCCESS;
		}
		else	
		{
			addActionError("Errore");
			return INPUT;
		}
	}
}
