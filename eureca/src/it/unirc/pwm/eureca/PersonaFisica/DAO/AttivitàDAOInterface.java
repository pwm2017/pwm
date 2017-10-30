package it.unirc.pwm.eureca.PersonaFisica.DAO;

import it.unirc.pjam.Esame.Model.Esame;
import it.unirc.pjam.Esame.Model.EsameId;


public interface Attivit‡DAOInterface {
	
	public EsameId creaEsame(Esame e);
	public int modificaVotoEsame(Esame e);

}
