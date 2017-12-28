package it.unirc.pwm.eureca.action.socio;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.eureca.socio.dao.SocioDAOFactory;
import it.unirc.pwm.eureca.socio.dao.SocioDAOInterface;
import it.unirc.pwm.eureca.socio.model.Socio;
import it.unirc.pwm.eureca.tessera.dao.TesseraDAOFactory;
import it.unirc.pwm.eureca.tessera.dao.TesseraDAOInterface;
import it.unirc.pwm.eureca.tessera.model.Tessera;

public class ControllerSocio extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private Socio socio = null;
	private SocioDAOInterface sdao=SocioDAOFactory.getDAO();
	private List<Socio> listaSoci= null;
	private Tessera tessera=new Tessera();
	private TesseraDAOInterface tdao=TesseraDAOFactory.getDAO();
	public HttpServletRequest request;


	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	
	
	public Tessera getTessera() {
		return tessera;
	}

	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}

	public List<Socio> getListaSoci() {
		return listaSoci;
	}

	public void setListaSoci(List<Socio> listaSoci) {
		this.listaSoci = listaSoci;
	}

	public String execute() throws Exception{
		
		listaSoci=sdao.getSoci();
		if(listaSoci==null)
		return INPUT;
		else
			return SUCCESS;
	}

	public String redirectInserisciSocio()
	{
		return SUCCESS;
	}


	public String eliminaSocio()
	{
		if(sdao.eliminaSocio(socio))
		{
			addActionMessage("Socio eliminato correttemente");

			return SUCCESS;
		}
		else 
			addActionMessage("errore");
		return INPUT;
	}

	public String setSocio()
	{
		socio=sdao.getSocio(socio);
		tessera=tdao.getTesseraSocio(socio);
		if(socio==null)
			return INPUT;

		else 
			return SUCCESS;
	}
}
