package it.unirc.pwm.eureca.action.support;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;
import it.unirc.pwm.eureca.evento.dao.EventoDAOFactory;
import it.unirc.pwm.eureca.evento.dao.EventoDAOInterface;
import it.unirc.pwm.eureca.evento.model.Evento;
import it.unirc.pwm.eureca.utils.QrCode;

public class Event extends ActionSupport  implements ServletRequestAware
{

	private static final long serialVersionUID = 1L;
	private EventoDAOInterface edao=EventoDAOFactory.getDAO();
	private Evento evento;
	public HttpServletRequest request;
	
	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	public String execute() 
	{
		String appPath = request.getServletContext().getRealPath("");
		String appPath1=appPath+"webApp/assets/img/eventi/";
		String path="C:/Users/User/Desktop/eclipseNeon/pwm/eureca/WebContent/webApp/assets/img/eventi/";
		evento=edao.getEvento(evento);
		QrCode qr=new QrCode();
		qr.generaQrCode(evento.getNome(), evento.getIdEvento(), appPath1+evento.getNome()+evento.getIdEvento()+".png");
		return SUCCESS;
	}
}
