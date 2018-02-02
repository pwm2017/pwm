package it.unirc.pwm.eureca.action.socio;
import java.util.List;
import com.opensymphony.xwork2.ActionSupport;

import it.unirc.pwm.eureca.socio.dao.SocioDAOFactory;
import it.unirc.pwm.eureca.socio.dao.SocioDAOInterface;
import it.unirc.pwm.eureca.socio.model.Socio;
import it.unirc.pwm.eureca.tessera.dao.TesseraDAOFactory;
import it.unirc.pwm.eureca.tessera.dao.TesseraDAOInterface;
import it.unirc.pwm.eureca.tessera.model.Tessera;

public class ControllerSocio extends ActionSupport
{
	private static final long serialVersionUID = 1L;
	private Socio socio;
	private SocioDAOInterface sdao=SocioDAOFactory.getDAO();
	private List<Socio> listaSoci;
	private List<Socio> listaSociPagina;
	private Tessera tessera=new Tessera();
	private TesseraDAOInterface tdao=TesseraDAOFactory.getDAO();
	private int numeroPagina;
	private int pagine;


	public List<Socio> getListaSociPagina() {
		return listaSociPagina;
	}

	public void setListaSociPagina(List<Socio> listaSociPagina) {
		this.listaSociPagina = listaSociPagina;
	}

	public int getNumeroPagina() {
		return numeroPagina;
	}

	public void setNumeroPagina(int numeroPagina) {
		this.numeroPagina = numeroPagina;
	}

	public int getPagine() {
		return pagine;
	}

	public void setPagine(int pagine) {
		this.pagine = pagine;
	}

	public Socio getSocio() {
		return socio;
	}

	public void setSocio(Socio socio) {
		this.socio = socio;
	}


	public Tessera getTessera() {
		return tessera;
	}

	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}

	public List<Socio> getListaSoci() {
		return listaSoci;
	}

	public void setListaSoci(List<Socio> listaSoci) {
		this.listaSoci = listaSoci;
	}

	public String execute()
	{
		listaSoci=sdao.getSoci();
		pagine= (int) Math.ceil((double) listaSoci.size()/4);
		listaSociPagina=sdao.cercaSociPagina(numeroPagina);
		if(listaSociPagina==null)
		{
			addActionError("Errore nel visuliazzare i soci");
			return INPUT;
		}
		else
			return SUCCESS;
	}

	public String redirectInserisciSocio()
	{
		return SUCCESS;
	}


	public String eliminaSocio()
	{
		if(sdao.eliminaSocio(socio))
		{
			addActionMessage("Socio eliminato correttamente");

			return SUCCESS;
		}
		else 
			addActionError("Errore nell'eliminare il socio"+ getText(socio.getNome()));
		return INPUT;
	}

	public String setSocio()
	{
		socio=sdao.getSocio(socio);
		tessera=tdao.getTesseraSocio(socio);
		if(socio==null)
		{
			addActionError("Impossibile caricare il socio "+ getText(socio.getNome()));
			return INPUT;
		}
		else 
			return SUCCESS;
	}
}
