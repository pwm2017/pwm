package it.unirc.pwm.eureca.evento.dao;

import java.util.List;

import it.unirc.pwm.eureca.evento.model.Evento;

public interface EventoDAOInterface
{
	
	public boolean creaEvento(Evento eve) ;
	public boolean modificaEvento(Evento eve) ;
	public List<Evento> getEventi();
	public Evento getEvento(Evento ev);
	public List<Evento> cercaEventiPagina(int numeroPagina);
	public Boolean eliminaEvento(Evento ev);
}
