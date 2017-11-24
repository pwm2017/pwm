package it.unirc.pwm.eureca.action.socio;

import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.eureca.socio.dao.SocioDAOFactory;
import it.unirc.pwm.eureca.socio.dao.SocioDAOInterface;
import it.unirc.pwm.eureca.socio.model.Socio;

public class Login extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private Map<String,Object> session; 
	
	private SocioDAOInterface daoS= SocioDAOFactory.getDAO();
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute(){
		
		Socio s=new Socio();
		s.setUsername(username);
		s.setPassword(password);
		if(daoS.verificaLogin(s)==(null))
			return INPUT;

		
		return SUCCESS;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
