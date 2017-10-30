package it.unirc.pwm.eureca.Socio.Model;
import it.unirc.pwm.eureca.PersonaFisica.Model.*;
import it.unirc.pwm.eureca.Tessera.Model.*;

public class Socio extends PersonaFisica{
	private int idSocio;
	private String password;
	private String username;
	private String biografia;
	private int cap;
	private String via;
	private String città;
	private String foto;//ho immaginato fosse un url altrimenti non saprei come gestirla
	private Tessera tessera;
	
	public Socio() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBiografia() {
		return biografia;
	}
	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	public String getVia() {
		return via;
	}
	public void setVia(String via) {
		this.via = via;
	}
	public String getCittà() {
		return città;
	}
	public void setCittà(String città) {
		this.città = città;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public Tessera getTessera() {
		return tessera;
	}
	public void setTessera(Tessera tessera) {
		this.tessera = tessera;
	}
	
	
	
	
	

}
