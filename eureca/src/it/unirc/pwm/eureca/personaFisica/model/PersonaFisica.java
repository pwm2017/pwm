package it.unirc.pwm.eureca.personaFisica.model;

import java.util.Date;

public class PersonaFisica
{
	private int idPersonaFisica;
	private String nome;
	private String cognome;
	private String email;
	private long telefono;
	private Date dataNascita;
	
	
	public PersonaFisica() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getIdPersonaFisica() {
		return idPersonaFisica;
	}


	public void setIdPersonaFisica(int idPersonaFisica) {
		this.idPersonaFisica = idPersonaFisica;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public long getTelefono() {
		return telefono;
	}


	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}


	public Date getDataNascita() {
		return dataNascita;
	}


	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	
	
}
