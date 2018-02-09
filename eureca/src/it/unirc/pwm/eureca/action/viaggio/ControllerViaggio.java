package it.unirc.pwm.eureca.action.viaggio;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import it.unirc.pwm.eureca.socio.model.Socio;
import it.unirc.pwm.eureca.utils.Costant;
import it.unirc.pwm.eureca.viaggio.dao.ViaggioDAOFactory;
import it.unirc.pwm.eureca.viaggio.dao.ViaggioDAOInterface;
import it.unirc.pwm.eureca.viaggio.model.Viaggio;

public class ControllerViaggio extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	private Viaggio viaggio;
	private Map<String,Object> session;
	private ViaggioDAOInterface vdao=ViaggioDAOFactory.getDAO();
	private List<Viaggio> listaViaggi;
	private List<Viaggio> listaViaggiPagina;
	private int numeroPagina;
	private int pagine;
	


	public List<Viaggio> getListaViaggiPagina() {
		return listaViaggiPagina;
	}

	public void setListaViaggiPagina(List<Viaggio> listaViaggiPagina) {
		this.listaViaggiPagina = listaViaggiPagina;
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

	public Viaggio getViaggio() {
		return viaggio;
	}

	public void setViaggio(Viaggio viaggio) {
		this.viaggio = viaggio;
	}

	public List<Viaggio> getListaViaggi() {
		return listaViaggi;
	}

	public void setListaViaggi(List<Viaggio> listaViaggi) {
		this.listaViaggi = listaViaggi;
	}

	public void setSession(Map<String, Object> session) {
		this.session=session;
	}

	public String execute() 
	{

		listaViaggi=vdao.getViaggi();
		pagine= (int) Math.ceil((double) listaViaggi.size()/Costant.SIZE_LIST);
		listaViaggiPagina=vdao.cercaViaggiPagina(numeroPagina);
		if(listaViaggiPagina==null)
		{
			addActionError("Errore nel visuliazzare i Viaggi");
			return INPUT;
		}
		else
			return SUCCESS;
	}

	public String redirectInserisciViaggio()
	{
		return SUCCESS;
	}

	public String visualizzaViaggiSocio() 
	{

		listaViaggi=vdao.getViaggiSoci();
		if(listaViaggi==null)
			return INPUT;
		else
			return SUCCESS;
	}


	public String eliminaViaggio()
	{
		if(vdao.eliminaViaggio(viaggio))
		{
			addActionMessage("Viaggio eliminato correttamente");

			return SUCCESS;
		}
		else 
			addActionError("errore impossibile eliminare il viaggio");
		return INPUT;
	}

	public String setViaggio()
	{
		viaggio=vdao.getViaggio(viaggio);

		if(viaggio==null)
			return INPUT;

		else 
			return SUCCESS;
	}

	public String socioPartecipaViaggio()
	{
		Socio s = (Socio) session.get("socio");
		viaggio=vdao.getViaggio(viaggio);
		viaggio.setNumPartecipanti(viaggio.getNumPartecipanti()-1);
		if(vdao.aggiungiSocioViaggio(viaggio,s))
		{
			addActionMessage("Prenotazione avvenuta con successo!");
			return SUCCESS;
		}else	
		{
			addActionError("Errore");
			return SUCCESS;
		}
	}	
}