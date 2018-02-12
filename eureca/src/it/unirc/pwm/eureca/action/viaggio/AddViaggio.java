package it.unirc.pwm.eureca.action.viaggio;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import it.unirc.pwm.eureca.viaggio.dao.ViaggioDAOFactory;
import it.unirc.pwm.eureca.viaggio.dao.ViaggioDAOInterface;
import it.unirc.pwm.eureca.viaggio.model.Viaggio;

public class AddViaggio extends ActionSupport implements ModelDriven<Viaggio>, ServletRequestAware 
{
	private static final long serialVersionUID = 1L;
	private Viaggio viaggio = new Viaggio();
	private ViaggioDAOInterface vdao=ViaggioDAOFactory.getDAO();
	private File uploadDoc;
	private String uploadDocFileName;
	private String uploadDocContentType;
	public HttpServletRequest request;

	public Viaggio getModel() {

		return viaggio;
	}
	
	
	public Viaggio getViaggio() {
		return viaggio;
	}


	public void setViaggio(Viaggio viaggio) {
		this.viaggio = viaggio;
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
		String appPath = request.getServletContext().getRealPath("");
	
		if ((uploadDocFileName!=null)){
			String[] parts = uploadDocContentType.split("/");
			String part2 = parts[1];
			String nomeFile=getModel().getNome()+"."+part2;
			getModel().setLocandina(nomeFile);
			uploadDocFileName=nomeFile;
			File fileToCreate = new File(appPath+"webApp/assets/img/viaggi/", uploadDocFileName);
			try
			{
				FileUtils.copyFile(this.uploadDoc, fileToCreate);
			}
			catch (IOException e) 
			{
				addActionError(e.getMessage());
			}
		}
		if(vdao.creaViaggio(getModel()))
		{
			addActionMessage("Viaggio aggiunto correttamente");
			
			return SUCCESS;
		}
		else 
			addActionError("Errore nel aggiungere il viaggio");
		return INPUT;
	
	}


	public void setServletRequest(HttpServletRequest request) 
	{
		this.request = request;
	}
	
	public void validate(){

		if( getModel().getNome().length()==0){

			this.addFieldError("nome", "Il nome è rischiesto.");

		}
		
		if(getModel().getNumPartecipanti()==0){

			this.addFieldError("numPartecipanti", "Numero Partecipanti richiesto");

		}	

	}
}
