package it.unirc.pwm.eureca.action.socio;

import com.opensymphony.xwork2.ActionSupport;
import it.unirc.pwm.eureca.tessera.dao.TesseraDAOFactory;
import it.unirc.pwm.eureca.tessera.dao.TesseraDAOInterface;
import it.unirc.pwm.eureca.tessera.model.Tessera;

public class UpdateTessera extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private Tessera tessera=new Tessera();
	private TesseraDAOInterface tdao=TesseraDAOFactory.getDAO();


	public Tessera getTessera() {
		return tessera;
	}

	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}


	public String execute()
	{

		return SUCCESS;
	}

	
	public String modificaTessera()
	{
		
		if(tdao.modificaTessera(tessera))
		{
			addActionMessage("Tessera modificata correttemente");

			return SUCCESS;
		}
		else 
			addActionError("Errore nel modifica Tessera");;
		return INPUT;
	}
	
}
