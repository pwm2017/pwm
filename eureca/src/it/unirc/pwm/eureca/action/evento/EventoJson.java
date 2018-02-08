package it.unirc.pwm.eureca.action.evento;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.eureca.evento.dao.EventoDAOFactory;
import it.unirc.pwm.eureca.evento.model.Evento;


public class EventoJson  extends ActionSupport{

	private static Logger log= LogManager.getLogger();
	private static final long serialVersionUID = 1L;
	private int id; // iniettato
	private Evento result; // return

	public String execute() {
		Evento tmp = new Evento();
		tmp.setIdEvento(id);
		result = EventoDAOFactory.getDAO().getEvento(tmp);

		return "SUCCESS";
	} 

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
