package it.unirc.pwm.eureca.action.login;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.eureca.action.login.utils.AmministratoreAware;
import it.unirc.pwm.eureca.socio.model.Socio;



public class Authenticated extends ActionSupport implements AmministratoreAware, Action {

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

	@Override
	public void setAmministratore(Socio socio) {
		this.socio = socio;
		
	}
}
