package it.unirc.pwm.eureca.action.support;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import it.unirc.pwm.eureca.evento.dao.EventoDAOFactory;
import it.unirc.pwm.eureca.evento.dao.EventoDAOInterface;
import it.unirc.pwm.eureca.evento.model.Evento;

public class AllEvents extends ActionSupport 
{

	private static final long serialVersionUID = 1L;
	private EventoDAOInterface edao=EventoDAOFactory.getDAO();
	private List<Evento> eventi;


	public List<Evento> getEventi() {
		return eventi;
	}



	public void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}



	public String execute() 
	{
		eventi=edao.getEventi();
		return SUCCESS;
	}

}
