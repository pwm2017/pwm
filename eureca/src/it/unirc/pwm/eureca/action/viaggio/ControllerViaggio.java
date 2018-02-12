package it.unirc.pwm.eureca.action.viaggio;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import it.unirc.pwm.eureca.socio.model.Socio;
import it.unirc.pwm.eureca.tessera.dao.TesseraDAOFactory;
import it.unirc.pwm.eureca.tessera.dao.TesseraDAOInterface;
import it.unirc.pwm.eureca.tessera.model.Tessera;
import it.unirc.pwm.eureca.utils.Costant;
import it.unirc.pwm.eureca.viaggio.dao.ViaggioDAOFactory;
import it.unirc.pwm.eureca.viaggio.dao.ViaggioDAOInterface;
import it.unirc.pwm.eureca.viaggio.model.Viaggio;

public class ControllerViaggio extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 1L;
	private Viaggio viaggio;
	private List<Socio> listaSoci;
	private Map<String,Object> session;
	private ViaggioDAOInterface vdao=ViaggioDAOFactory.getDAO();
	private TesseraDAOInterface tdao=TesseraDAOFactory.getDAO();
	private List<Viaggio> listaViaggi;
	private List<Viaggio> listaViaggiPagina;
	private int numeroPagina;
	private int pagine;

	public List<Socio> getListaSoci() {
		return listaSoci;
	}

	public void setListaSoci(List<Socio> listaSoci) {
		this.listaSoci = listaSoci;
	}

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
			Tessera t = (Tessera) session.get( "tessera" );
			t.setPunti(t.getPunti()+Costant.PUNTI_VIAGGI);
			tdao.modificaTessera(t);
			session.replace("tessera", t);
			addActionMessage("Prenotazione avvenuta con successo!");
			return SUCCESS;
		}else	
		{
			addActionError("Errore");
			return SUCCESS;
		}
	}
	
	public String partecipantiViaggio()
	{
		listaSoci=vdao.getSociViaggio(viaggio);
		if(listaSoci==null)
		{
			addActionError("Non ci sono Soci che partecipano a questo viaggio");
			return INPUT;
		}
		else
			return SUCCESS;
	}public ControllerViaggio() {
		// TODO Auto-generated constructor stub
	}
}