package it.unirc.pwm.eureca.evento.dao;

import it.unirc.pwm.eureca.evento.model.Evento;

public interface EventoDAOInterface
{
	
	public boolean creaEvento(Evento eve) ;
	public boolean modificaEvento(Evento eve) ;
}
