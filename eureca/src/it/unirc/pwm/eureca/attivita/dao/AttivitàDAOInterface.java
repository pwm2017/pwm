package it.unirc.pwm.eureca.attivita.dao;

import java.util.List;

import it.unirc.pwm.eureca.attivita.model.Attivita;
import it.unirc.pwm.eureca.evento.model.Evento;


public interface Attivit‡DAOInterface {
	
	public int creaAttivit‡(Attivita a) ;
	public boolean modificaAttivit‡(Attivita a) ;
	public Attivita getAttivita(Attivita a);
	public Attivita getUltimaAttivita();
	public List<Attivita> getAttivit‡Evento(Evento ev);
	public Boolean eliminaAttivit‡(Attivita a);
}
