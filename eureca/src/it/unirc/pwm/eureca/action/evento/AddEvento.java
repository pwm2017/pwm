package it.unirc.pwm.eureca.action.evento;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import it.unirc.pwm.eureca.attivita.model.Attivita;
import it.unirc.pwm.eureca.evento.model.Evento;
import it.unirc.pwm.eureca.socio.dao.SocioDAOFactory;
import it.unirc.pwm.eureca.socio.dao.SocioDAOInterface;
import it.unirc.pwm.eureca.socio.model.Socio;


public class AddEvento extends ActionSupport implements ServletRequestAware
{
	private static final long serialVersionUID = 1L;
	private Evento evento = new Evento();
	private Attivita attivita;
	private SocioDAOInterface sdao=SocioDAOFactory.getDAO();
	private List<Socio> listaSoci;
	private File uploadDoc;
	private String uploadDocFileName;
	private String uploadDocContentType;
	public HttpServletRequest request;
	
	public List<Socio> getListaSoci() {
		return listaSoci;
	}

	public void setListaSoci(List<Socio> listaSoci) {
		this.listaSoci = listaSoci;
	}

	public Attivita getAttivita() {
		return attivita;
	}

	public void setAttivita(Attivita attivita) {
		this.attivita = attivita;
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

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	
	public String execute() 
	{
		return SUCCESS;
	}
	
	public String inserisciEvento()
	{
		String appPath = request.getServletContext().getRealPath("");

		if ((uploadDocFileName!=null)){
			String[] parts = uploadDocContentType.split("/");
			String part2 = parts[1];
			String nomeFile=evento.getNome()+"."+part2;
			evento.setLocandina(nomeFile);
			uploadDocFileName=nomeFile;
			File fileToCreate = new File(appPath+"webApp/assets/img/eventi/", uploadDocFileName);
			try
			{
				FileUtils.copyFile(this.uploadDoc, fileToCreate);
			}
			catch (IOException e) 
			{
				addActionError(e.getMessage());
			}
		}
		if(evento!=null)
		{
			listaSoci=sdao.getSoci();
			addActionMessage("Dati evento aggiunti correttamente!!! Associa una attività all'evento "+getText(evento.getNome()));
			return SUCCESS;
		}
		else 
			addActionError("Errore");
		return INPUT;
	}

	public void validate()
	{

		if( evento.getNome().length()==0)
		{
			this.addFieldError("evento.nome", "Il nome è rischiesto.");
		}
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
