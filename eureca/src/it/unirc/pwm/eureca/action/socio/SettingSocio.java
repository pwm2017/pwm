package it.unirc.pwm.eureca.action.socio;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.eureca.socio.dao.SocioDAOFactory;
import it.unirc.pwm.eureca.socio.dao.SocioDAOInterface;
import it.unirc.pwm.eureca.socio.model.Socio;
import it.unirc.pwm.eureca.tessera.dao.TesseraDAOFactory;
import it.unirc.pwm.eureca.tessera.dao.TesseraDAOInterface;
import it.unirc.pwm.eureca.tessera.model.Tessera;

public class SettingSocio extends ActionSupport implements ServletRequestAware
{
	private static final long serialVersionUID = 1L;
	private Socio socio = null;
	private SocioDAOInterface sdao=SocioDAOFactory.getDAO();
	private Tessera tessera=new Tessera();
	private File uploadDoc;
	private TesseraDAOInterface tdao=TesseraDAOFactory.getDAO();
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

	public String execute() throws Exception
	{

		return SUCCESS;
	}


	public String inserisciSocio()
	{
		String appPath = request.getServletContext().getRealPath("");
		
		
		System.out.println(appPath);
		if ((uploadDocFileName!=null)){
			String[] parts = uploadDocContentType.split("/");
			String part2 = parts[1];
			String nomeFile=socio.getUsername()+"."+part2;
			socio.setFoto(nomeFile);
			uploadDocFileName=nomeFile;
//			File fileToCreate = new File(appPath+"webApp/assets/img/soci", uploadDocFileName);
			File fileToCreate = new File("C:/Users/User/Desktop/eclipseNeon/pwm/eureca/WebContent/webApp/assets/img/soci", uploadDocFileName);
			try
			{
				FileUtils.copyFile(this.uploadDoc, fileToCreate);
			}
			catch (IOException e) 
			{
				addActionError(e.getMessage());
			}
		}
		if(sdao.creaSocio(socio))
		{
			addActionMessage("Socio aggiunto correttemente");
			
			tessera.setSocio(socio);
			tessera.setPunti(0);
			Date d=new Date();
			int anno= d.getYear()+1;
			int mese=d.getMonth();
			int giorno=d.getDay();
			Date d1=new Date(anno,mese,giorno);
			System.out.println(d);
			System.out.println(d1);
			tessera.setDataRilascio(d);
			tessera.setDataScadenza(d1);
			
			tdao.creaTessera(tessera);

			return SUCCESS;
		}
		else 
			addActionMessage("errore");
		return INPUT;
	}



	public String modificaSocio()
	{
		if(sdao.modificaSocio(socio))
		{
			addActionMessage("Socio modificato correttemente");

			return SUCCESS;
		}
		else 
			addActionMessage("errore");
		return INPUT;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
