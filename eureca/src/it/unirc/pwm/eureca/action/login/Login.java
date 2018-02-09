package it.unirc.pwm.eureca.action.login;

import java.security.NoSuchAlgorithmException;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.eureca.socio.dao.SocioDAOFactory;
import it.unirc.pwm.eureca.socio.dao.SocioDAOInterface;
import it.unirc.pwm.eureca.socio.model.Socio;
import it.unirc.pwm.eureca.tessera.dao.TesseraDAOFactory;
import it.unirc.pwm.eureca.tessera.dao.TesseraDAOInterface;
import it.unirc.pwm.eureca.tessera.model.Tessera;
import it.unirc.pwm.eureca.utils.ControlSha;

public class Login extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private Tessera tessera;
	private SocioDAOInterface daoS= SocioDAOFactory.getDAO();
	private TesseraDAOInterface tdao=TesseraDAOFactory.getDAO();
	private Map<String,Object> session; 
	
	
	public Tessera getTessera() {
		return tessera;
	}

	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}

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
		try {
			socio.setPassword(ControlSha.sha256(password));
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		socio=daoS.verificaLogin(socio);
		tessera=tdao.getTesseraSocio(socio);
		session.put("tessera", tessera);
		
		if(socio==(null))
		{
			addActionMessage(getText("error.message"));
			return INPUT;
		}
		else if(socio.isAbilitato()==false)
		{
			addActionMessage(getText("Socio non abilitato"));
			return INPUT;
		}
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

	public void validate()
	{
		addActionMessage(getText("errorGeneric.message"));

		if(getPassword().length()==0){
			this.addFieldError("password",getText( "password.required"));
		}

		if(getPassword().length()<3){
			this.addFieldError("password", getText("password.short"));
		}

		if(getUsername().length()==0){
			this.addFieldError("username", getText("username.required"));
		}	
	}



	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
