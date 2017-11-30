package it.unirc.pwm.eureca.action.socio;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.eureca.action.socio.utils.SocioAware;
import it.unirc.pwm.eureca.socio.model.Socio;



public class AuthenticatedSocio extends ActionSupport implements SocioAware, Action {

	private static final long serialVersionUID = 1L;
	private Socio socio;
	
	
	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}


	public String execute(){
		return SUCCESS;
	}
		
}
