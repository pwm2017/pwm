package it.unirc.pwm.eureca.action.evento;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import it.unirc.pwm.eureca.evento.dao.EventoDAOFactory;
import it.unirc.pwm.eureca.evento.dao.EventoDAOInterface;
import it.unirc.pwm.eureca.evento.model.Evento;
import it.unirc.pwm.eureca.utils.Costant;


public class ControllerEvento extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private Evento evento;
	private EventoDAOInterface edao=EventoDAOFactory.getDAO();
	private List<Evento> listaEventi;
	private List<Evento> listaEventiPagina;
	private int numeroPagina;
	private int pagine;
	
	
	public List<Evento> getListaEventi() {
		return listaEventi;
	}

	public void setListaEventi(List<Evento> listaEventi) {
		this.listaEventi = listaEventi;
	}

	public List<Evento> getListaEventiPagina() {
		return listaEventiPagina;
	}

	public void setListaEventiPagina(List<Evento> listaEventiPagina) {
		this.listaEventiPagina = listaEventiPagina;
	}

	public int getNumeroPagina() {
		return numeroPagina;
	}

	public void setNumeroPagina(int numeroPagina) {
		this.numeroPagina = numeroPagina;
	}

	public int getPagine() {
		return pagine;
	}

	public void setPagine(int pagine) {
		this.pagine = pagine;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String execute()
	{		
		listaEventi=edao.getEventi();
		if(listaEventi==null)
		{
			addActionError("Non ci sono eventi");
			return INPUT;
		}
		pagine= (int) Math.ceil((double) listaEventi.size()/Costant.SIZE_LIST_SOCI);
		listaEventiPagina=edao.cercaEventiPagina(numeroPagina);
		if(listaEventiPagina==null)
		{
			addActionError("Errore nel visuliazzare i soci");
			return INPUT;
		}
		else
			return SUCCESS;
	}

	public String redirectInserisciEvento()
	{
		return SUCCESS;
	}
	


	public String eliminaEvento()
	{
		if(edao.eliminaEvento(evento))
		{
			addActionMessage("Evento eliminato correttamente");

			return SUCCESS;
		}
		else 
			addActionError("Errore nell'eliminare l'evento"+ getText(evento.getNome()));
		return INPUT;
	}

	public String setEvento()
	{
		evento=edao.getEvento(evento);
		if(evento==null)
		{
			addActionError("Impossibile caricare l'evento "+ getText(evento.getNome()));
			return INPUT;
		}
		else 
			return SUCCESS;
	}
	
}
