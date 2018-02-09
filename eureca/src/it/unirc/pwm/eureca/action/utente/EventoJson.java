package it.unirc.pwm.eureca.action.utente;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.eureca.evento.dao.EventoDAOFactory;
import it.unirc.pwm.eureca.evento.model.Evento;


public class EventoJson  extends ActionSupport{

	private static Logger log= LogManager.getLogger();
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
