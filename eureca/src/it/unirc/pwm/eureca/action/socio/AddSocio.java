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

public class AddSocio extends ActionSupport implements ServletRequestAware
{
	private static final long serialVersionUID = 1L;
	private Socio socio = new Socio();
	private SocioDAOInterface sdao=SocioDAOFactory.getDAO();
	private TesseraDAOInterface tdao=TesseraDAOFactory.getDAO();
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

	public String execute() throws Exception
	{

		return SUCCESS;
	}


	@SuppressWarnings("deprecation")
	public String inserisciSocio()
	{
		String appPath = request.getServletContext().getRealPath("");

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
			addActionMessage("Socio aggiunto correttamente");
			
			Date d=new Date();
			tessera.setDataRilascio(d);
			tessera.setSocio(socio);
			tessera.setPunti(0);
			GregorianCalendar gc=new GregorianCalendar();
			String validita=(gc.get(Calendar.YEAR)+1)+"/"+(gc.get(Calendar.MONTH)+1)+"/"+gc.get(Calendar.DAY_OF_MONTH);
			tessera.setDataScadenza(new Date(validita));
			tdao.creaTessera(tessera);

			return SUCCESS;
		}
		else 
			addActionError("Errore");
		return INPUT;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

}
