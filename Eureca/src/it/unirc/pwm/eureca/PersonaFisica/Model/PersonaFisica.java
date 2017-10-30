package it.unirc.pwm.eureca.PersonaFisica.Model;

import java.sql.Timestamp;

public class PersonaFisica {
	private String nome;
	private String cognome;
	private int cf;
	private String email;
	private int telefono;
	private Timestamp dataNascita;
	public PersonaFisica() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public int getCf() {
		return cf;
	}
	public void setCf(int cf) {
		this.cf = cf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public Timestamp getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Timestamp dataNascita) {
		this.dataNascita = dataNascita;
	}

}
