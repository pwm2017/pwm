package it.unirc.pwm.eureca.attivita.dao;

import it.unirc.pwm.eureca.attivita.model.Attivita;


public interface Attivit�DAOInterface {
	
	public int creaAttivit�(Attivita a) ;
	public boolean modificaAttivit�(Attivita a) ;
	public Attivita getAttivita(Attivita a);
	public Attivita getUltimaAttivita();
}
