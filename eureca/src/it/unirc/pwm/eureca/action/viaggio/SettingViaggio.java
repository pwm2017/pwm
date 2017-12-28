package it.unirc.pwm.eureca.action.viaggio;

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

public class SettingViaggio extends ActionSupport implements ServletRequestAware
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

			
			uploadDocFileName=socio.getNome()+".png";
			int dot1=System.getProperty("catalina.base").indexOf(".");
			String targetPath =System.getProperty("catalina.base").substring(0,dot1);
			//    	File fileToCreate = new File(targetPath+"eureca/WebContent/webApp/assets/img", uploadDocFileName);
			File fileToCreate = new File(appPath+"webApp/assets/img/soci", uploadDocFileName);
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
			GregorianCalendar gc=new GregorianCalendar();
			Integer anno = gc.get(Calendar.YEAR) + 1;
			Integer mese = gc.get(Calendar.MONTH);
			String validita=gc.get(Calendar.DAY_OF_MONTH)+"/"+mese.toString()+"/"+anno.toString();
			tessera.setDataRilascio(new Date());
			tessera.setDataScadenza(new Date(validita));
			
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
