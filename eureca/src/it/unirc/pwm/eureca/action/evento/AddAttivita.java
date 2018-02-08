package it.unirc.pwm.eureca.action.evento;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import it.unirc.pwm.eureca.attivita.dao.Attivit‡DAOFactory;
import it.unirc.pwm.eureca.attivita.dao.Attivit‡DAOInterface;
import it.unirc.pwm.eureca.attivita.model.Attivita;
import it.unirc.pwm.eureca.socio.dao.SocioDAOFactory;
import it.unirc.pwm.eureca.socio.dao.SocioDAOInterface;
import it.unirc.pwm.eureca.socio.model.Socio;
import it.unirc.pwm.eureca.svolge.dao.SvolgeDAOFactory;
import it.unirc.pwm.eureca.svolge.dao.SvolgeDAOInterface;
import it.unirc.pwm.eureca.svolge.model.Svolge;
import it.unirc.pwm.eureca.svolge.model.SvolgeId;

public class AddAttivita extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private Attivita attivita=new Attivita();
	private String [] idSocio;
	private List<Socio> listaSoci;
	private Attivit‡DAOInterface adao=Attivit‡DAOFactory.getDAO();
	private SvolgeDAOInterface svodao=SvolgeDAOFactory.getDAO();
	private SocioDAOInterface sdao=SocioDAOFactory.getDAO();
	
	
	
	public List<Socio> getListaSoci() {
		return listaSoci;
	}

	public void setListaSoci(List<Socio> listaSoci) {
		this.listaSoci = listaSoci;
	}

	public String[] getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(String[] idSocio) {
		this.idSocio = idSocio;
	}

	public Attivita getAttivita() {
		return attivita;
	}

	public void setAttivita(Attivita attivita) {
		this.attivita = attivita;
	}
	
	public String execute() throws Exception
	{
		return SUCCESS;
	}
	
	public String inserisciEventoDefinitivo()
	{	
		int idAttivita = adao.creaAttivit‡(attivita);
		
		for(String idS: idSocio)
		{
			Svolge svolge=new Svolge();
			SvolgeId svolgeId=new SvolgeId();
			svolgeId.setIdAttivita(idAttivita);
			svolgeId.setIdSocio(Integer.valueOf(idS));;
			svolge.setId(svolgeId);
			
			if(svodao.Socio_Svolge_Attivita(svolge)==false)
			{
				addActionError("Errore");
				return INPUT;
			}
			
		}
		addActionMessage("Evento aggiunto correttamente");  
			return SUCCESS;
	}
	

	public void validate()
	{

		if(idSocio==null)
		{
			addActionMessage(getText("Devi aggiungere almeno un socio!!!"));
			listaSoci=sdao.getSoci();
			this.addFieldError("idSocio",getText( "Devi aggiungere almeno un socio!!!"));
		}
	}
}
