package it.unirc.pwm.eureca.viaggio.dao;

import java.util.List;

import it.unirc.pwm.eureca.socio.model.Socio;
import it.unirc.pwm.eureca.viaggio.model.Viaggio;

public interface ViaggioDAOInterface
{
	public boolean creaViaggio(Viaggio v);
	public boolean modificaViaggio(Viaggio v);
	public boolean aggiungiSocioViaggio(Viaggio v, Socio s);
	public Viaggio getViaggio(Viaggio v);
	public List<Viaggio> getViaggi();
	public List<Viaggio> getViaggiSoci();
}
