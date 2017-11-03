package it.unirc.pwm.eureca.utente.dao;


public class UtenteDAOFactory {

	  private static UtenteDAOInterface dao = null;
	  
	  private UtenteDAOFactory(){
	  }
	  
	  public static UtenteDAOInterface getDAO() {
		  
	    if ( dao == null ) {
	    	dao = new UtenteDAOImplement();
	    }
	    return dao;
	  } 
}
