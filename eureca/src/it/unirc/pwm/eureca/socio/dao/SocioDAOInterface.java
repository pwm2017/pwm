package it.unirc.pwm.eureca.socio.dao;

import java.util.List;

import it.unirc.pwm.eureca.socio.model.Socio;

public interface SocioDAOInterface
{
	public boolean creaSocio(Socio s) ;
	public boolean modificaSocio(Socio s) ;
	public Socio verificaLogin(Socio s);
	public Boolean verificaUsername(String username);
	public List<Socio> getSoci();
	public Boolean eliminaSocio(Socio s);
}
