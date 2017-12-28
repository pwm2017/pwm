package it.unirc.pwm.eureca.action.viaggio;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.eureca.socio.dao.SocioDAOFactory;
import it.unirc.pwm.eureca.socio.dao.SocioDAOInterface;
import it.unirc.pwm.eureca.socio.model.Socio;
import it.unirc.pwm.eureca.tessera.dao.TesseraDAOFactory;
import it.unirc.pwm.eureca.tessera.dao.TesseraDAOInterface;
import it.unirc.pwm.eureca.tessera.model.Tessera;
import it.unirc.pwm.eureca.viaggio.dao.ViaggioDAOFactory;
import it.unirc.pwm.eureca.viaggio.dao.ViaggioDAOInterface;
import it.unirc.pwm.eureca.viaggio.model.Viaggio;

public class ControllerViaggio extends ActionSupport implements ServletRequestAware
{
	private static final long serialVersionUID = 1L;
	private Viaggio viaggio = null;
	private ViaggioDAOInterface vdao=ViaggioDAOFactory.getDAO();
	private List<Viaggio> listaViaggi= null;
	
	public HttpServletRequest request;

	public String execute() throws Exception{
		
		//listaViaggi=vdao.getViaggi();
		if(listaViaggi==null)
		return INPUT;
		else
			return SUCCESS;
	}

	public String redirectInserisciViaggio()
	{
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

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
//	public void validate()
//	{
//		if(socio.getNome().length()==0){
//			this.addFieldError("socio.nome","nome richiesto");
//		}
//	}
}
