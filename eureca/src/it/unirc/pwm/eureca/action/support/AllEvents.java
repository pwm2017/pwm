package it.unirc.pwm.eureca.action.support;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;
import it.unirc.pwm.eureca.evento.dao.EventoDAOFactory;
import it.unirc.pwm.eureca.evento.dao.EventoDAOInterface;
import it.unirc.pwm.eureca.evento.model.Evento;
import it.unirc.pwm.eureca.utils.Costant;

public class AllEvents extends ActionSupport 
{

	private static final long serialVersionUID = 1L;
	private EventoDAOInterface edao=EventoDAOFactory.getDAO();
	private List<Evento> eventi;
	private int numeroPagina;
	private int pagine;
	private List<Evento> listaEventiPagina;

	
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

	public List<Evento> getListaEventiPagina() {
		return listaEventiPagina;
	}

	public void setListaEventiPagina(List<Evento> listaEventiPagina) {
		this.listaEventiPagina = listaEventiPagina;
	}

	public List<Evento> getEventi() {
		return eventi;
	}

	public void setEventi(List<Evento> eventi) {
		this.eventi = eventi;
	}

	public String execute() 
	{
		eventi=edao.getEventi();
		if(eventi==null)
		{
			addActionError("Non ci sono eventi");
			return INPUT;
		}
		pagine= (int) Math.ceil((double) eventi.size()/Costant.SIZE_LIST);
		listaEventiPagina=edao.cercaEventiPagina(numeroPagina);
		if(listaEventiPagina==null)
		{
			addActionError("Errore nel visuliazzare i soci");
			return INPUT;
		}
		else
			return SUCCESS;
	}

}
