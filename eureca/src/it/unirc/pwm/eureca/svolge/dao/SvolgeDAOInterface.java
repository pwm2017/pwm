package it.unirc.pwm.eureca.svolge.dao;

import java.util.List;

import it.unirc.pwm.eureca.attivita.model.Attivita;
import it.unirc.pwm.eureca.socio.model.Socio;
import it.unirc.pwm.eureca.svolge.model.Svolge;

public interface SvolgeDAOInterface 
{
	
	public boolean Socio_Svolge_Attivita(Svolge s);
	public List<Attivita> SocioSvolgeAttivita(Socio s);
}
