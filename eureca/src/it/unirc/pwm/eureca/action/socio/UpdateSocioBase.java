package it.unirc.pwm.eureca.action.socio;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.eureca.socio.dao.SocioDAOFactory;
import it.unirc.pwm.eureca.socio.dao.SocioDAOInterface;
import it.unirc.pwm.eureca.socio.model.Socio;
import it.unirc.pwm.eureca.tessera.model.Tessera;

public class UpdateSocioBase extends ActionSupport implements ServletRequestAware, SessionAware
{
	private static final long serialVersionUID = 1L;
	private Socio socio;
	private Map<String,Object> session;
	private SocioDAOInterface sdao=SocioDAOFactory.getDAO();
	private Tessera tessera=new Tessera();
	private File uploadDoc;
	private String uploadDocFileName;
	private String uploadDocContentType;
	public HttpServletRequest request;



	public Tessera getTessera() {
		return tessera;
	}

	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
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

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	
	public void setSession(Map<String, Object> session) {
		this.session=session;
	}


	public String execute()
	{

		return SUCCESS;
	}

	public String modificaSocioBase()
	{
		String appPath = request.getServletContext().getRealPath("");
		if ((uploadDocFileName!=null))
		{
			String[] parts = uploadDocContentType.split("/");
			String part2 = parts[1];
			String nomeFile=socio.getUsername()+"."+part2;
			socio.setFoto(nomeFile);
			uploadDocFileName=nomeFile;
			File fileToCreate = new File(appPath+"webApp/assets/img/soci/", uploadDocFileName);
			try
			{
				FileUtils.copyFile(this.uploadDoc, fileToCreate);
			}
			catch (IOException e) 
			{
				addActionError(e.getMessage());
			}
		}
		
		if(sdao.modificaSocio(socio))
		{
			Socio s = (Socio) session.get( "socio" );
			if((socio.getIdPersonaFisica()==s.getIdPersonaFisica()))
			session.replace("socio", socio);
			addActionMessage("Socio modificato correttamente");

			return SUCCESS;
		}
		else 
			addActionError("Errore nel modifica socio");;
		return INPUT;
	}
	
	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
