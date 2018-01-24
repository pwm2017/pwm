package it.unirc.pwm.eureca.action.evento;
import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.eureca.attivita.dao.Attivit‡DAOFactory;
import it.unirc.pwm.eureca.attivita.dao.Attivit‡DAOInterface;
import it.unirc.pwm.eureca.attivita.model.Attivita;

public class AddAttivita extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private Attivita attivita=new Attivita();
	private Attivit‡DAOInterface adao=Attivit‡DAOFactory.getDAO();

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
		
		if(adao.creaAttivit‡(attivita))
		{
			addActionMessage("Evento aggiunto correttamente");

			return SUCCESS;
		}
		else 
			addActionError("Errore");
		return INPUT;
	}

}
