package it.unirc.pwm.eureca.action.evento;

import com.opensymphony.xwork2.ActionSupport;
import it.unirc.pwm.eureca.attivita.dao.AttivitaDAOFactory;
import it.unirc.pwm.eureca.attivita.dao.AttivitaDAOInterface;
import it.unirc.pwm.eureca.attivita.model.Attivita;
import it.unirc.pwm.eureca.svolge.dao.SvolgeDAOFactory;
import it.unirc.pwm.eureca.svolge.dao.SvolgeDAOInterface;
import it.unirc.pwm.eureca.svolge.model.Svolge;
import it.unirc.pwm.eureca.svolge.model.SvolgeId;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;

public class AddAttivita extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private Attivita attivita=new Attivita();
	private String idSocio;
	private AttivitaDAOInterface adao = AttivitaDAOFactory.getDAO();
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
		adao.creaAttivita(attivita);//todo
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
