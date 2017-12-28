package it.unirc.pwm.eureca.tessera.dao;

import it.unirc.pwm.eureca.socio.model.Socio;
import it.unirc.pwm.eureca.tessera.model.Tessera;

public interface TesseraDAOInterface 
{
	public boolean creaTessera(Tessera t);
	public boolean modificaTessera(Tessera t);
	public Tessera getTesseraSocio(Socio s);
}
