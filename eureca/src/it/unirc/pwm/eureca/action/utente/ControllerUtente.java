package it.unirc.pwm.eureca.action.utente;

import com.opensymphony.xwork2.ActionSupport;
import it.unirc.pwm.eureca.evento.model.Evento;


public class ControllerUtente extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private Evento evento;	

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String execute(){
	
		return SUCCESS;
	}
	
	public String redirectPertecipaEvento()
	{
		return SUCCESS;
	}	
}
