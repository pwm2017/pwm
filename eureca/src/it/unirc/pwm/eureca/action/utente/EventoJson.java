package it.unirc.pwm.eureca.action.utente;
import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.eureca.evento.dao.EventoDAOFactory;
import it.unirc.pwm.eureca.evento.model.Evento;


public class EventoJson  extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	private int id; // iniettato
	private Evento evento;

	public String execute() {
		Evento tmp = new Evento();
		tmp.setIdEvento(id);
		evento = EventoDAOFactory.getDAO().getEvento(tmp);
		return INPUT;    
	} 

	public int getId() { 
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
}
