package it.unirc.pwm.eureca.PersonaFisica.DAO;


public class Attivit‡DAOFactory {

	  private static Attivit‡DAOInterface dao = null;
	  
	  private Attivit‡DAOFactory(){
	  }
	  
	  public static Attivit‡DAOInterface getDAO() {
		  
	    if ( dao == null ) {
	    	dao = new Attivit‡DAOImplement();
	    }
	    return dao;
	  } 
}
