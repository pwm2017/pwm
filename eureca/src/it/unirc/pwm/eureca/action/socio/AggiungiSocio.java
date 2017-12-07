package it.unirc.pwm.eureca.action.socio;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.eureca.socio.dao.SocioDAOFactory;
import it.unirc.pwm.eureca.socio.dao.SocioDAOInterface;
import it.unirc.pwm.eureca.socio.model.Socio;

public class AggiungiSocio extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private Socio socio;
	private SocioDAOInterface sdao=SocioDAOFactory.getDAO();
	
	
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	} 
	
     public String execute() throws Exception{
		
		if(sdao.creaSocio(socio)){
		addActionMessage("Socio Aggiunto correttemente");
		
		return SUCCESS;}
		else 
			addActionMessage("errore");
		return INPUT;
		
	}
}
