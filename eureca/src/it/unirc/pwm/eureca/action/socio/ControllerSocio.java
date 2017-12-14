package it.unirc.pwm.eureca.action.socio;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.eureca.socio.dao.SocioDAOFactory;
import it.unirc.pwm.eureca.socio.dao.SocioDAOInterface;
import it.unirc.pwm.eureca.socio.model.Socio;

public class ControllerSocio extends ActionSupport implements ServletRequestAware
{
	private static final long serialVersionUID = 1L;
	private Socio socio = null;
	private SocioDAOInterface sdao=SocioDAOFactory.getDAO();
	private List<Socio> listaSoci= null;
	private File uploadDoc;
	private String uploadDocFileName;
	private String uploadDocContentType;
	public HttpServletRequest request;

	
	
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


	public List<Socio> getListaSoci() {
		return listaSoci;
	}

	public void setListaSoci(List<Socio> listaSoci) {
		this.listaSoci = listaSoci;
	}

	public String execute() throws Exception{
		
		listaSoci=sdao.getSoci();
		if(listaSoci==null)
		return INPUT;
		else
			return SUCCESS;
	}

	public String redirectInserisciSocio()
	{
		return SUCCESS;
	}

	public String inserisciSocio()
	{
		String path = request.getRealPath("/");
		System.out.println(path);
		if ((uploadDocFileName!=null)){
		String[] parts = uploadDocContentType.split("/");
    	String part2 = parts[1];
    	
    	
    	uploadDocFileName=socio.getNome()+"."+part2;
    	String targetPath ="/eureca/webApp/assets/img/";
    	//String targetPath = this.getPath();
    	File fileToCreate = new File(targetPath, uploadDocFileName);
    	        try
    	        {
    	                FileUtils.copyFile(this.uploadDoc, fileToCreate);
    	        }
    	        catch (IOException e) 
    	        {
    	                addActionError(e.getMessage());
    	        }}
		if(sdao.creaSocio(socio)){
			addActionMessage("Socio aggiunto correttemente");

			return SUCCESS;}
		else 
			addActionMessage("errore");
		return INPUT;
	}

	public String eliminaSocio()
	{
		if(sdao.eliminaSocio(socio))
		{
			addActionMessage("Socio eliminato correttemente");

			return SUCCESS;
		}
		else 
			addActionMessage("errore");
		return INPUT;
	}

	public String settingSocio()
	{
		socio=sdao.getSocio(socio);

		if(socio==null)
			return INPUT;

		else 
			return SUCCESS;
	}
	
	public String modificaSocio()
	{
		System.out.println(socio.getIdPersonaFisica());
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
	
//	public void validate()
//	{
//		if(socio.getNome().length()==0){
//			this.addFieldError("socio.nome","nome richiesto");
//		}
//	}
}
