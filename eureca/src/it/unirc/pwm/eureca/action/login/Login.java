package it.unirc.pwm.eureca.action.login;

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

	public String execute()
	{
		Socio socio=new Socio();
		socio.setUsername(username);
		socio.setPassword(password);
		socio=daoS.verificaLogin(socio);

		if(socio==(null))
			return INPUT;

		else if(socio.isAmministratore())
		{
			session.put("amministratore", socio); 
			return "successAdmin";
		}
		else
		{
			session.put("socio", socio);
			return "successSocio";
		}
	}
	

	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
