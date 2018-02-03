package it.unirc.pwm.eureca.attivita.dao;

import it.unirc.pwm.eureca.attivita.model.Attivita;


public interface AttivitaDAOInterface {

    public boolean creaAttivita(Attivita a);

    public boolean modificaAttivita(Attivita a);

    public Attivita getAttivita(Attivita a);
	public Attivita getUltimaAttivita();
}
