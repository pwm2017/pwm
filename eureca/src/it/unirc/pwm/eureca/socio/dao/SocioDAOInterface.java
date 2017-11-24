package it.unirc.pwm.eureca.socio.dao;

import it.unirc.pwm.eureca.socio.model.Socio;

public interface SocioDAOInterface
{
	public boolean creaSocio(Socio s) ;
	public boolean modificaSocio(Socio s) ;
	public Socio verificaLogin(Socio s);
}
