package it.unirc.pwm.eureca.action.evento;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import it.unirc.pwm.eureca.evento.dao.EventoDAOFactory;
import it.unirc.pwm.eureca.evento.dao.EventoDAOInterface;
import it.unirc.pwm.eureca.evento.model.Evento;


public class UpdateEvento extends ActionSupport implements ServletRequestAware
{
	private static final long serialVersionUID = 1L;
	private Evento evento=new Evento();
	private EventoDAOInterface edao=EventoDAOFactory.getDAO();
	private File uploadDoc;
	private String uploadDocFileName;
	private String uploadDocContentType;
	public HttpServletRequest request;

	
	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public File getUploadDoc() {
		return uploadDoc;
	}

	public void setUploadDoc(File uploadDoc) {
		this.uploadDoc = uploadDoc;
	}

	public String getUploadDocFileName() {
		return uploadDocFileName;
	}

	public void setUploadDocFileName(String uploadDocFileName) {
		this.uploadDocFileName = uploadDocFileName;
	}

	public String getUploadDocContentType() {
		return uploadDocContentType;
	}

	public void setUploadDocContentType(String uploadDocContentType) {
		this.uploadDocContentType = uploadDocContentType;
	}

	public String execute()
	{

		return SUCCESS;
	}

	public String modificaEvento()
	{
		String appPath = request.getServletContext().getRealPath("");

		if ((uploadDocFileName!=null))
		{
			String[] parts = uploadDocContentType.split("/");
			String part2 = parts[1];
			String nomeFile=evento.getNome()+"."+part2;
			evento.setLocandina(nomeFile);
			uploadDocFileName=nomeFile;
//			File fileToCreate = new File(appPath+"webApp/assets/img/eventi", uploadDocFileName);
			File fileToCreate = new File("C:/Users/User/Desktop/eclipseNeon/pwm/eureca/WebContent/webApp/assets/img/eventi", uploadDocFileName);
			try
			{
				FileUtils.copyFile(this.uploadDoc, fileToCreate);
			}
			catch (IOException e) 
			{
				addActionError(e.getMessage());
			}
		}
		if(edao.modificaEvento(evento))
		{
			
			addActionMessage("Evento modificato correttamente");

			return SUCCESS;
		}
		else 
			addActionError("Errore nel modifica Evento");;
		return INPUT;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
