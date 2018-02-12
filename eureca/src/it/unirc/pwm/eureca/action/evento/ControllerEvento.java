package it.unirc.pwm.eureca.action.evento;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.eureca.attivita.dao.Attivit‡DAOFactory;
import it.unirc.pwm.eureca.attivita.dao.Attivit‡DAOInterface;
import it.unirc.pwm.eureca.attivita.model.Attivita;
import it.unirc.pwm.eureca.evento.dao.EventoDAOFactory;
import it.unirc.pwm.eureca.evento.dao.EventoDAOInterface;
import it.unirc.pwm.eureca.evento.model.Evento;
import it.unirc.pwm.eureca.socio.dao.SocioDAOFactory;
import it.unirc.pwm.eureca.socio.dao.SocioDAOInterface;
import it.unirc.pwm.eureca.socio.model.Socio;
import it.unirc.pwm.eureca.utente.model.Utente;
import it.unirc.pwm.eureca.utils.Costant;


public class ControllerEvento extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private Evento evento;
	private Attivita attivita;
	private EventoDAOInterface edao=EventoDAOFactory.getDAO();
	private Attivit‡DAOInterface adao=Attivit‡DAOFactory.getDAO();
	private SocioDAOInterface sDao=SocioDAOFactory.getDAO();
	private List<Socio> listaSoci; 
	private List<Evento> listaEventi;
	private List<Utente> listaUtenti;
	private List<Evento> listaEventiPagina;
	private List<Attivita> attivit‡Evento;
	private int numeroPagina;
	private int pagine;

	
	
	public List<Socio> getListaSoci() {
		return listaSoci;
	}

	public void setListaSoci(List<Socio> listaSoci) {
		this.listaSoci = listaSoci;
	}

	public List<Utente> getListaUtenti() {
		return listaUtenti;
	}

	public void setListaUtenti(List<Utente> listaUtenti) {
		this.listaUtenti = listaUtenti;
	}

	public Attivita getAttivita() {
		return attivita;
	}

	public void setAttivita(Attivita attivita) {
		this.attivita = attivita;
	}

	public List<Attivita> getAttivit‡Evento() {
		return attivit‡Evento;
	}

	public void setAttivit‡Evento(List<Attivita> attivit‡Evento) {
		this.attivit‡Evento = attivit‡Evento;
	}

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
		pagine= (int) Math.ceil((double) listaEventi.size()/Costant.SIZE_LIST);
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
	
	public String partecipantiEvento()
	{
		listaUtenti=edao.getUtentiEvento(evento);
		if(listaUtenti==null)
		{
			addActionError("Non ci sono utenti che partecipano a questo evento");
			return INPUT;
		}
		else
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
		    addActionMessage("Errore nell'eliminare l'evento");
		return INPUT;
	}
	
	public String eliminaAttivit‡()
	{
		if(adao.eliminaAttivit‡(attivita))
		{
			addActionMessage("Attivit‡ eliminata correttamente");

			return SUCCESS;
		}
		else 
			addActionError("Errore nell'eliminare Attivit‡");
		    addActionMessage("Errore nell'eliminare Attivit‡");
		return INPUT;
	}

	public String setEvento()
	{
		evento=edao.getEvento(evento);
		attivit‡Evento=adao.getAttivit‡Evento(evento);
		
		if(evento==null)
		{
			addActionError("Impossibile caricare l'evento "+ getText(evento.getNome()));
			return INPUT;
		}
		else 
			return SUCCESS;
	}
	
	public String aggiungiAltreAttivita()
	{
		evento=edao.getEvento(evento);
		listaSoci = sDao.getSoci();
		
		if(evento==null)
		{
			addActionError("Impossibile caricare l'evento "+ getText(evento.getNome()));
			return INPUT;
		}
		else 
			return SUCCESS;
	}
	
}
