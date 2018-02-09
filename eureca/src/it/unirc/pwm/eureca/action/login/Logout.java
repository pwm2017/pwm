package it.unirc.pwm.eureca.action.login;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;

public class Logout extends ActionSupport implements SessionAware 
{

	private static final long serialVersionUID = 1L;

	private Map<String,Object> session; 

	public String execute(){
		
		if(session.isEmpty())
			return SUCCESS;  
		if(session.containsKey("socio"))
		{ 
			session.remove("socio");
			session.remove("tessera");
		}	
		if(session.containsKey("amministratore"))
		{
			session.remove("amministratore");
			session.remove("tessera");
		}

		return SUCCESS;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
