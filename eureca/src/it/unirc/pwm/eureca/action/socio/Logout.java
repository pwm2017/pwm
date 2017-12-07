package it.unirc.pwm.eureca.action.socio;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.eureca.socio.dao.SocioDAOFactory;
import it.unirc.pwm.eureca.socio.dao.SocioDAOInterface;
import it.unirc.pwm.eureca.socio.model.Socio;

public class Logout extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;

	private Map<String,Object> session; 

	public String execute(){
		
		if(session.isEmpty())
			return SUCCESS;  
		if(session.containsKey("socio")) 
			session.remove("socio");
		
		if(session.containsKey("amministratore"))
			session.remove("amministratore");

		return SUCCESS;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
