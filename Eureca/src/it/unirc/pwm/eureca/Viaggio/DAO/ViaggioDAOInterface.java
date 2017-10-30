package it.unirc.pwm.eureca.Viaggio.DAO;

import it.unirc.pjam.Esame.Model.Esame;
import it.unirc.pjam.Esame.Model.EsameId;


public interface ViaggioDAOInterface {
	
	public EsameId creaEsame(Esame e);
	public int modificaVotoEsame(Esame e);

}
