package it.unirc.pwm.eureca.action.evento;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import it.unirc.pwm.eureca.evento.dao.EventoDAOFactory;
import it.unirc.pwm.eureca.evento.dao.EventoDAOInterface;
import it.unirc.pwm.eureca.evento.model.Evento;


public class ControllerEvento extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private Evento evento = null;
	private EventoDAOInterface edao=EventoDAOFactory.getDAO();
	private List<Evento> listaEventi= null;
	

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String execute(){
		
		listaEventi=edao.getEventi();
		if(listaEventi==null){
			addActionError("Non ci sono eventi");
		return INPUT;}
		else
			return SUCCESS;
	}

	public String redirectInserisciEvento()
	{
		return SUCCESS;
	}
	
	
	public String redirectPertecipaEvento()
	{
		return SUCCESS;
	}


	public String eliminaEvento()
	{
//		if(edao.eliminaEvento(evento))
//		{
//			addActionMessage("Evento eliminato correttemente");
//
//			return SUCCESS;
//		}
//		else 
//			addActionError("Errore nell'eliminare l'evento"+ getText(evento.getNome()));
		return INPUT;
	}

	public String setEvento()
	{
//		evento=edao.getSocio(evento);
//		if(evento==null)
//		{
//			addActionError("Impossibile caricare l'evento "+ getText(evento.getNome()));
//			return INPUT;
//		}
//		else 
			return SUCCESS;
	}
	
}