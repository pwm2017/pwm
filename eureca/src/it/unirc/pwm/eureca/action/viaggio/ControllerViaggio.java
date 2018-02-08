package it.unirc.pwm.eureca.action.viaggio;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import it.unirc.pwm.eureca.socio.model.Socio;
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
		if(listaViaggi==null)
		return INPUT;
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
//		if(vdao.eliminaViaggio(viaggio))
//		{
//			addActionMessage("Viaggio eliminato correttemente");
//
//			return SUCCESS;
//		}
//		else 
//			addActionError("errore impossibile eliminare il viaggio");
		return INPUT;
	}

	public String setViaggio()
	{
		//viaggio=vdao.getViaggio(viaggio);
		
		if(viaggio==null)
			return INPUT;

		else 
			return SUCCESS;
	}
	
	public String socioPartecipaViaggio()
	{
		Socio s = (Socio) session.get("socio");
		Viaggio v=new Viaggio();
		v=vdao.getViaggio(viaggio);
		if(vdao.aggiungiSocioViaggio(v,s))
		{
		addActionMessage("Prenotazione avvenuta con successo!");
		return SUCCESS;
		}
		else return INPUT;

	}	
}