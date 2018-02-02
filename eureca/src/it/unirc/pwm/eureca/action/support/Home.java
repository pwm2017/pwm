package it.unirc.pwm.eureca.action.support;


import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import it.unirc.pwm.eureca.evento.dao.EventoDAOFactory;
import it.unirc.pwm.eureca.evento.dao.EventoDAOInterface;
import it.unirc.pwm.eureca.evento.model.Evento;

public class Home extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private EventoDAOInterface edao=EventoDAOFactory.getDAO();
	private List<Evento> eventiRecenti;
	
	

	public List<Evento> getEventiRecenti() {
		return eventiRecenti;
	}



	public void setEventiRecenti(List<Evento> eventiRecenti) {
		this.eventiRecenti = eventiRecenti;
	}



	public String execute() throws Exception{

		eventiRecenti=edao.getEventi();
		return SUCCESS;


	}

}
