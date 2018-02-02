package it.unirc.pwm.eureca.action.evento;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;


import it.unirc.pwm.eureca.attivita.dao.Attivit‡DAOFactory;
import it.unirc.pwm.eureca.attivita.dao.Attivit‡DAOInterface;
import it.unirc.pwm.eureca.attivita.model.Attivita;
import it.unirc.pwm.eureca.svolge.dao.SvolgeDAOFactory;
import it.unirc.pwm.eureca.svolge.dao.SvolgeDAOInterface;
import it.unirc.pwm.eureca.svolge.model.Svolge;
import it.unirc.pwm.eureca.svolge.model.SvolgeId;

public class AddAttivita extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private Attivita attivita=new Attivita();
	private String idSocio;
	private Attivit‡DAOInterface adao=Attivit‡DAOFactory.getDAO();
	private SvolgeDAOInterface svodao=SvolgeDAOFactory.getDAO();
	
	
	public String getIdSocio() {
		return idSocio;
	}

	public void setIdSocio(String idSocio) {
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
		adao.creaAttivit‡(attivita);//todo
		int idAttivita = adao.getUltimaAttivita().getIdAttivita();
		HttpServletRequest request= ServletActionContext.getRequest();
		System.out.println(request.getParameterValues("idSocio"));
		for(String idS:request.getParameterValues("idSocio"))
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
}
