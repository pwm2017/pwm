package it.unirc.pwm.eureca.viaggio.dao;

import it.unirc.pwm.eureca.viaggio.model.Viaggio;

public interface ViaggioDAOInterface
{
	public boolean creaViaggio(Viaggio v);
	public boolean modificaViaggio(Viaggio v);

}
