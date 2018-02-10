package it.unirc.pwm.eureca.action.support;
import com.opensymphony.xwork2.ActionSupport;
import it.unirc.pwm.eureca.evento.dao.EventoDAOFactory;
import it.unirc.pwm.eureca.evento.dao.EventoDAOInterface;
import it.unirc.pwm.eureca.evento.model.Evento;
import it.unirc.pwm.eureca.utils.QrCode;

public class Event extends ActionSupport 
{

	private static final long serialVersionUID = 1L;
	private EventoDAOInterface edao=EventoDAOFactory.getDAO();
	private Evento evento;
	
	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public String execute() 
	{
		String path="C:/Users/User/Desktop/eclipseNeon/pwm/eureca/WebContent/webApp/assets/img/eventi/";
		evento=edao.getEvento(evento);
		QrCode qr=new QrCode();
		qr.generaQrCode(evento.getNome(), evento.getIdEvento(), path+evento.getNome()+evento.getIdEvento()+".png");
		return SUCCESS;
	}
}
