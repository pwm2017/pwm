package it.unirc.pwm.eureca.action.socio;
import java.security.NoSuchAlgorithmException;

import com.opensymphony.xwork2.ActionSupport;
import it.unirc.pwm.eureca.socio.dao.SocioDAOFactory;
import it.unirc.pwm.eureca.socio.dao.SocioDAOInterface;
import it.unirc.pwm.eureca.socio.model.Socio;
import it.unirc.pwm.eureca.utils.ControlSha;


public class UpdatePasswordSocioBase extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private Socio socio=new Socio();
	private SocioDAOInterface sdao=SocioDAOFactory.getDAO();


	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	

	public String execute()
	{

		return SUCCESS;
	}

	public String modificaPasswordSocio()
	{
		try {
			socio.setPassword(ControlSha.sha256(socio.getPassword()));
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(sdao.modificaSocio(socio))
		{
			
			addActionMessage("Password modificata correttamente");

			return SUCCESS;
		}
		else 
			addActionError("Errore nel modifica socio");;
		return INPUT;
	}
	
}
