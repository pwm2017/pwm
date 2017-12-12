package it.unirc.pwm.eureca.action.socio;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.eureca.socio.dao.SocioDAOFactory;
import it.unirc.pwm.eureca.socio.dao.SocioDAOInterface;
import it.unirc.pwm.eureca.socio.model.Socio;

public class ControllerSocio extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private Socio socio = null;
	private SocioDAOInterface sdao=SocioDAOFactory.getDAO();
	private List<Socio> listaSoci= null;
	private int idPersonaFisica;
	
	
	public int getIdPersonaFisica() {
		return idPersonaFisica;
	}

	public void setIdPesonaFisica(int idPersonaFisica) {
		this.idPersonaFisica = idPersonaFisica;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}


	public List<Socio> getListaSoci() {
		return listaSoci;
	}

	public void setListaSoci(List<Socio> listaSoci) {
		this.listaSoci = listaSoci;
	}

	public String execute() throws Exception{

		setListaSoci(sdao.getSoci());
		return SUCCESS;
	}

	public String redirectInserisciSocio()
	{
		return SUCCESS;
	}

	public String inserisciSocio()
	{
		if(sdao.creaSocio(socio)){
			addActionMessage("Socio aggiunto correttemente");

			return SUCCESS;}
		else 
			addActionMessage("errore");
		return INPUT;
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
	
	public String modificaSocio()
	{
		socio=sdao.getSocio(socio);
		
//		if(sdao.modificaSocio(socio))
//		{
//			addActionMessage("Socio modificato correttemente");

			return SUCCESS;
//		}
//		else 
//			addActionMessage("errore");
//		return INPUT;
	}
}
