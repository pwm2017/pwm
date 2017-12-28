package it.unirc.pwm.eureca.socio.model;
import java.util.HashSet;
import java.util.Set;
import it.unirc.pwm.eureca.personaFisica.model.*;
import it.unirc.pwm.eureca.svolge.model.Svolge;
import it.unirc.pwm.eureca.tessera.model.*;
import it.unirc.pwm.eureca.viaggio.model.Viaggio;

public class Socio extends PersonaFisica
{
	private String password;
	private String username;
	private String codiceFiscale;
	private Indirizzo indirizzo;
	private String foto;//ho immaginato fosse un url altrimenti non saprei come gestirla
	private Tessera tessera;
	private boolean amministratore;
	private boolean abilitato;
	private Set<Viaggio> viaggi = new HashSet<Viaggio>(0);
	private Set<Svolge> svolges = new HashSet<Svolge>(0);
	
	public Socio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public boolean isAbilitato() {
		return abilitato;
	}



	public void setAbilitato(boolean abilitato) {
		this.abilitato = abilitato;
	}



	public boolean isAmministratore() {
		return amministratore;
	}

	public void setAmministratore(boolean amministratore) {
		this.amministratore = amministratore;
	}



	public Set<Svolge> getSvolges() {
		return svolges;
	}



	public void setSvolges(Set<Svolge> svolges) {
		this.svolges = svolges;
	}

	public Set<Viaggio> getViaggi() {
		return viaggi;
	}

	public void setViaggi(Set<Viaggio> viaggi) {
		this.viaggi = viaggi;
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

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Indirizzo getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
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
