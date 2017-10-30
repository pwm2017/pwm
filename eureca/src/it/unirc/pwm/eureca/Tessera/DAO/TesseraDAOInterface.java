package it.unirc.pwm.eureca.Tessera.DAO;

import it.unirc.pjam.Esame.Model.Esame;
import it.unirc.pjam.Esame.Model.EsameId;


public interface TesseraDAOInterface {
	
	public EsameId creaEsame(Esame e);
	public int modificaVotoEsame(Esame e);

}
