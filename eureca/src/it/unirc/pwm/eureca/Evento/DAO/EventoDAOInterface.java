package it.unirc.pwm.eureca.Evento.DAO;

import it.unirc.pjam.Esame.Model.Esame;
import it.unirc.pjam.Esame.Model.EsameId;


public interface EventoDAOInterface {
	
	public EsameId creaEsame(Esame e);
	public int modificaVotoEsame(Esame e);

}
